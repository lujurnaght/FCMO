package com.lujurnaght.fractionalcmo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDate

data class Msg(val role: String, val text: String)   // role: "user" (you) or "assistant" (the other side)

data class Criterion(val name: String, val score: Int, val note: String)
data class Score(val score: Int, val criteria: List<Criterion>, val verdict: String, val best: String, val elite: String)

/** Groq (console.groq.com), the same free key SovReadr uses. */
object Groq {
    private const val MODEL = "openai/gpt-oss-120b"
    private const val ENDPOINT = "https://api.groq.com/openai/v1/chat/completions"
    val ready: Boolean get() = Keys.groq.isNotBlank()

    suspend fun chat(system: String, messages: List<Msg>, temperature: Double = 0.7, effort: String = "low"): String = withContext(Dispatchers.IO) {
        val key = Keys.groq.ifBlank { error("Add your Groq key in Rank → Settings.") }
        val arr = JSONArray().put(JSONObject().put("role", "system").put("content", system))
        messages.forEach { arr.put(JSONObject().put("role", it.role).put("content", it.text)) }
        val body = JSONObject().put("model", MODEL).put("messages", arr).put("temperature", temperature)
            .put("reasoning_effort", effort).put("include_reasoning", false).toString()
        var last = "Groq couldn't be reached."
        for (attempt in 0..2) {
            val c = URL(ENDPOINT).openConnection() as HttpURLConnection
            try {
                c.connectTimeout = 15000; c.readTimeout = 120000
                c.requestMethod = "POST"; c.doOutput = true
                c.setRequestProperty("Content-Type", "application/json")
                c.setRequestProperty("Authorization", "Bearer $key")
                val code = try { c.outputStream.use { it.write(body.toByteArray()) }; c.responseCode }
                    catch (e: java.io.IOException) { last = "No connection to Groq (${e.javaClass.simpleName})."; delay(2500); continue }
                if (code in 200..299) {
                    val o = JSONObject(c.inputStream.bufferedReader().use { it.readText() })
                    return@withContext o.getJSONArray("choices").getJSONObject(0).getJSONObject("message").optString("content").trim()
                }
                val why = runCatching { JSONObject(c.errorStream.bufferedReader().use { it.readText() }).getJSONObject("error").optString("message") }
                    .getOrNull().orEmpty().take(160)
                when (code) {
                    401, 403 -> error("Groq refused the key ($code). Check it in Rank → Settings.")
                    429 -> error("Today's Groq allowance is used up. It comes back tomorrow.")
                    400, 404, 413 -> error("Groq: $why")
                    else -> { last = "Groq is busy ($code). $why".trim(); delay(if (attempt == 0) 3000L else 7000L) }
                }
            } finally { c.disconnect() }
        }
        error(last)
    }

    private fun jsonIn(text: String): JSONObject {
        val a = text.indexOf('{'); val b = text.lastIndexOf('}')
        if (a < 0 || b <= a) error("The grader's answer couldn't be read. Try again.")
        return JSONObject(text.substring(a, b + 1))
    }

    private fun parseScore(text: String): Score {
        val o = jsonIn(text)
        val cr = o.optJSONArray("criteria") ?: JSONArray()
        val list = (0 until cr.length()).map { i ->
            val c = cr.getJSONObject(i)
            Criterion(c.optString("name"), c.optInt("score", 0).coerceIn(0, 5), c.optString("note"))
        }
        return Score(o.optInt("score", 0).coerceIn(0, 100), list, o.optString("verdict"), o.optString("best"), o.optString("elite"))
    }

    private const val GRADER = """You are a panel of three top-1% fractional CMOs who train others. You grade honestly and demandingly.
Scale: 90+ is exceptional, the kind of answer you'd pay for; 70–89 is senior and solid; 50–69 is competent but generic; below 50 misses the point.
Never inflate. Generic advice that could apply to any company scores below 60. Specific numbers, sharp questions, clear trade-offs and decisions score high.
Reply with JSON only, no prose around it:
{"score": 0-100, "criteria": [{"name": "...", "score": 1-5, "note": "one short sentence"}], "verdict": "two blunt sentences on the performance", "best": "the strongest thing they did or said, briefly (or 'Nothing yet')", "elite": "what a top-1% fractional CMO would have done or said instead, concrete, 80-130 words"}"""

    suspend fun gradeSpar(s: Scenario, transcript: List<Msg>): Score {
        val convo = transcript.joinToString("\n") { (if (it.role == "user") "CMO: " else "${s.role.uppercase()} (other side): ") + it.text }
        val prompt = """Scenario: ${s.title} (${s.role}).
Brief given to the CMO: ${s.setup}
Hidden facts the other side held: ${s.persona}
Criteria, in this order: ${s.rubric.joinToString("; ")}.

Transcript:
$convo

Grade the CMO only."""
        return parseScore(chat(GRADER, listOf(Msg("user", prompt)), temperature = 0.2, effort = "medium"))
    }

    suspend fun reply(s: Scenario, transcript: List<Msg>): String {
        val system = """${s.persona}
You are in a live ${s.role.lowercase()} with a fractional CMO. Stay fully in character. Speak naturally, like a real person on a call, in 1–4 sentences (never more than 90 words).
Push back realistically. Reveal hidden facts only when the CMO asks good, specific questions. Never coach the CMO or break character. No stage directions, no markdown."""
        val msgs = listOf(Msg("assistant", s.opener)) + transcript
        return chat(system, msgs, temperature = 0.8)
    }

    private val THEMES = listOf(
        "repositioning a commoditised product", "pricing and packaging", "choosing between two channels with a limited budget",
        "a 30% budget cut", "rising churn blamed on marketing", "a product launch in a crowded category", "product-led growth stalling",
        "outbound that stopped working", "brand vs performance spend", "visibility in AI assistants", "an underperforming agency",
        "the first marketing hire", "a board asking for efficiency", "entering a new country", "a B2B company moving upmarket",
        "a DTC brand dependent on paid social", "a services firm with no pipeline", "a marketplace with a supply-demand imbalance",
    )

    suspend fun newCase(): DailyCase {
        val day = LocalDate.now().toEpochDay()
        val theme = THEMES[(day % THEMES.size).toInt()]
        val prompt = """Write today's training case for someone becoming a top-1% fractional CMO. Theme: $theme.
Invent a realistic, specific company (name, industry, stage) with concrete numbers: revenue, growth, CAC or acquisition costs, conversion or churn, channels and spend, team, constraints. Include one or two misleading details and one buried clue, like real life.
Reply with JSON only:
{"title": "short headline, max 8 words", "situation": "130-180 words, plain prose, numbers included", "question": "one sharp question asking for a decision and a 30-day plan"}"""
        val o = jsonIn(chat("You write realistic business cases for training senior marketers. JSON only.", listOf(Msg("user", prompt)), temperature = 0.9))
        return DailyCase(day, o.optString("title"), o.optString("situation"), o.optString("question"))
    }

    suspend fun gradeCase(c: DailyCase, answer: String): Score {
        val prompt = """Case: ${c.title}
${c.situation}
Question: ${c.question}

The CMO's answer:
$answer

Criteria, in this order: Diagnosis; Prioritisation; Use of the numbers; Actionability; Commercial judgment."""
        return parseScore(chat(GRADER, listOf(Msg("user", prompt)), temperature = 0.2, effort = "medium"))
    }

    private fun you(): String {
        val st = Store.st
        return buildString {
            append("The learner is training to become a top-1% fractional CMO.")
            if (st.niche.isNotBlank()) append(" Their niche: ${st.niche}.")
            if (st.offer.isNotBlank()) append(" Their offer: ${st.offer}.")
        }
    }

    suspend fun gradeExercise(l: Lesson, answer: String): Score {
        val ex = l.exercise ?: error("No exercise")
        val prompt = """${you()}
Lesson: ${l.title}
Lesson content (what they were taught):
${l.body.take(2500)}

Exercise: ${ex.prompt}
Criteria, in this order: ${ex.rubric.joinToString("; ")}.

Their answer:
$answer

Grade it as you would a real client deliverable. In "elite", write the answer a top-1% fractional CMO would give for THEIR niche (or a sensible niche if none is given)."""
        return parseScore(chat(GRADER, listOf(Msg("user", prompt)), temperature = 0.2, effort = "medium"))
    }

    suspend fun reviewDoc(t: Template, values: List<String>): Score {
        val doc = t.fields.mapIndexed { i, f -> "## ${f.title}\n${values.getOrNull(i).orEmpty().ifBlank { "(empty)" }}" }.joinToString("\n\n")
        val prompt = """${you()}
Document type: ${t.title} — ${t.why}

The document:
$doc

Criteria, in this order: Clarity; Specificity to the niche; Persuasiveness; Completeness; Would a real founder act on it.
Grade it as a real client-facing document. In "elite", rewrite its weakest section the way a top-1% fractional CMO would."""
        return parseScore(chat(GRADER, listOf(Msg("user", prompt)), temperature = 0.2, effort = "medium"))
    }

    suspend fun askLesson(l: Lesson, history: List<Msg>): String {
        val system = """You are a top-1% fractional CMO coaching a protégé. ${you()}
They are studying this lesson: "${l.title}".
${l.body.take(3000)}
Worked example: ${l.example.take(1200)}
Answer their question directly and concretely, with numbers or examples from their niche where possible. Be honest when something is uncertain or depends on context. Plain prose, at most 180 words, no markdown headings."""
        return chat(system, history, temperature = 0.5, effort = "medium")
    }
}
