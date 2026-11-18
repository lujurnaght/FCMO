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

    /** The model in use: Groq's strongest by default; if Groq retires it, the best available is found and remembered. */
    @Volatile private var model = MODEL

    private fun requestBody(m: String, system: String, messages: List<Msg>, temperature: Double, effort: String): String {
        val arr = JSONArray().put(JSONObject().put("role", "system").put("content", system))
        messages.forEach { arr.put(JSONObject().put("role", it.role).put("content", it.text)) }
        return JSONObject().put("model", m).put("messages", arr).put("temperature", temperature)
            .apply { if (m.startsWith("openai/gpt-oss")) { put("reasoning_effort", effort); put("include_reasoning", false) } }
            .toString()
    }

    /** Asks Groq which models exist and picks the strongest general one. */
    private fun replacementModel(key: String): String? = runCatching {
        val c = URL("https://api.groq.com/openai/v1/models").openConnection() as HttpURLConnection
        try {
            c.connectTimeout = 15000; c.readTimeout = 30000
            c.setRequestProperty("Authorization", "Bearer $key")
            val arr = JSONObject(c.inputStream.bufferedReader().use { it.readText() }).getJSONArray("data")
            val ids = (0 until arr.length()).map { arr.getJSONObject(it).getString("id") }
                .filter { id -> listOf("whisper", "tts", "guard", "embed", "vision").none { id.contains(it, true) } }
            ids.firstOrNull { it.contains("gpt-oss-120b") } ?: ids.firstOrNull { it.contains("120b") }
                ?: ids.firstOrNull { it.contains("70b") } ?: ids.firstOrNull()
        } finally { c.disconnect() }
    }.getOrNull()

    suspend fun chat(system: String, messages: List<Msg>, temperature: Double = 0.7, effort: String = "low"): String = withContext(Dispatchers.IO) {
        val key = Keys.groq.ifBlank { error("Add your Groq key in Rank → Settings.") }
        var last = "Groq couldn't be reached."
        var swapped = false
        var attempt = 0
        while (attempt < 3) {
            val c = URL(ENDPOINT).openConnection() as HttpURLConnection
            try {
                c.connectTimeout = 15000; c.readTimeout = 120000
                c.requestMethod = "POST"; c.doOutput = true
                c.setRequestProperty("Content-Type", "application/json")
                c.setRequestProperty("Authorization", "Bearer $key")
                val code = try { c.outputStream.use { it.write(requestBody(model, system, messages, temperature, effort).toByteArray()) }; c.responseCode }
                    catch (e: java.io.IOException) { last = "No connection to Groq (${e.javaClass.simpleName})."; attempt++; delay(2500); continue }
                if (code in 200..299) {
                    val o = JSONObject(c.inputStream.bufferedReader().use { it.readText() })
                    val text = o.getJSONArray("choices").getJSONObject(0).getJSONObject("message").optString("content").trim()
                    if (text.isNotEmpty()) return@withContext text
                    last = "Groq returned an empty answer."; attempt++; continue
                }
                val why = runCatching { JSONObject(c.errorStream.bufferedReader().use { it.readText() }).getJSONObject("error").optString("message") }
                    .getOrNull().orEmpty().take(200)
                val modelGone = code == 404 || (code == 400 && why.contains("model", true) && (why.contains("decommission", true) || why.contains("not exist", true) || why.contains("not found", true)))
                when {
                    modelGone && !swapped -> {
                        swapped = true
                        model = replacementModel(key) ?: error("Groq: $why")
                        continue
                    }
                    code == 401 || code == 403 -> error("Groq refused the key ($code). Check it in Rank → Settings.")
                    code == 429 -> error(if (why.contains("day", true) || why.contains("TPD", true) || why.contains("RPD", true))
                        "Today's free Groq allowance is used up. It resets within a day." else "Groq's per-minute limit was hit. Wait a minute and try again.")
                    code == 400 || code == 413 -> error("Groq: $why")
                    else -> { last = "Groq is busy ($code). $why".trim(); attempt++; delay(if (attempt == 1) 3000L else 7000L) }
                }
            } finally { c.disconnect() }
        }
        error(last)
    }

    /** Asks, and if the reply has no readable JSON, asks once more. */
    private suspend fun chatJson(system: String, messages: List<Msg>, temperature: Double, effort: String = "medium"): JSONObject {
        val first = chat(system, messages, temperature, effort)
        runCatching { return jsonIn(first) }
        val again = chat(system + "\nReply with one valid JSON object only. No text before or after it.", messages, 0.1, effort)
        return jsonIn(again)
    }

    /** A one-line test of the key, used by Settings. */
    suspend fun test(): String = chat("Reply with exactly: OK", listOf(Msg("user", "Test")), 0.0, "low")

    private fun jsonIn(text: String): JSONObject {
        val a = text.indexOf('{'); val b = text.lastIndexOf('}')
        if (a < 0 || b <= a) error("The grader's answer couldn't be read. Try again.")
        return JSONObject(text.substring(a, b + 1))
    }

    private fun parseScore(o: JSONObject): Score {
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
        return parseScore(chatJson(GRADER, listOf(Msg("user", prompt)), temperature = 0.2))
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
        val o = chatJson("You write realistic business cases for training senior marketers. JSON only.", listOf(Msg("user", prompt)), temperature = 0.9, effort = "low")
        return DailyCase(day, o.optString("title"), o.optString("situation"), o.optString("question"))
    }

    suspend fun gradeCase(c: DailyCase, answer: String): Score {
        val prompt = """Case: ${c.title}
${c.situation}
Question: ${c.question}

The CMO's answer:
$answer

Criteria, in this order: Diagnosis; Prioritisation; Use of the numbers; Actionability; Commercial judgment."""
        return parseScore(chatJson(GRADER, listOf(Msg("user", prompt)), temperature = 0.2))
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
        return parseScore(chatJson(GRADER, listOf(Msg("user", prompt)), temperature = 0.2))
    }

    suspend fun reviewDoc(t: Template, values: List<String>): Score {
        val doc = t.fields.mapIndexed { i, f -> "## ${f.title}\n${values.getOrNull(i).orEmpty().ifBlank { "(empty)" }}" }.joinToString("\n\n")
        val prompt = """${you()}
Document type: ${t.title} — ${t.why}

The document:
$doc

Criteria, in this order: Clarity; Specificity to the niche; Persuasiveness; Completeness; Would a real founder act on it.
Grade it as a real client-facing document. In "elite", rewrite its weakest section the way a top-1% fractional CMO would."""
        return parseScore(chatJson(GRADER, listOf(Msg("user", prompt)), temperature = 0.2))
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
