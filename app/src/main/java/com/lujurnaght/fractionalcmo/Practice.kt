package com.lujurnaght.fractionalcmo

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ExerciseScreen(id: String, nav: Nav) {
    val l = Curriculum.lesson(id)
    val ex = l.exercise ?: return
    val prev = Store.st.exercises[id]
    val scope = rememberCoroutineScope()
    var answer by rememberSaveable { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var err by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<Score?>(null) }
    val niche = Store.st.niche

    Page {
        BackRow("Back", nav.back)
        Label("Exercise · ${l.title}")
        Gap(10)
        Text(ex.prompt, style = T.h2.copy(fontSize = 21.sp, lineHeight = 28.sp))
        Gap(10)
        Text(if (niche.isNotBlank()) "Your niche: $niche" else "Tip: set your niche in Field → Positioning, and the panel will grade you against it.", style = T.small)
        Gap(6)
        Text("Graded on: ${ex.rubric.joinToString(" · ")}", style = T.small)
        Gap(20)
        val r = result
        if (r != null) {
            ScoreView(r)
            Gap(18)
            GhostButton("Try again", Modifier.fillMaxWidth()) { result = null }
            return@Page
        }
        if (prev != null) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Label("Your best: ${prev.score}/100")
                Spacer(Modifier.weight(1f))
                Text("Load it", style = T.small.copy(color = P.ink), modifier = Modifier.tap { answer = prev.answer })
            }
            Gap(10)
        }
        Input(answer, { answer = it }, "Write it as if a real founder will read it.", singleLine = false, minLines = 10)
        Gap(14)
        PrimaryButton(if (busy) "The panel is reading…" else "Submit to the panel", Modifier.fillMaxWidth(), enabled = !busy && Groq.ready && answer.trim().length > 30) {
            busy = true; err = null
            scope.launch {
                runCatching { Groq.gradeExercise(l, answer.trim()) }
                    .onSuccess { sc ->
                        val best = Store.st.exercises[id]?.score
                        val xp = if (best == null) sc.score / 2 + 10 else maxOf(0, sc.score - best) / 2
                        if (best == null || sc.score >= best) {
                            Store.edit { it.copy(exercises = it.exercises + (id to ExResult(now(), sc.score, sc.verdict, sc.best, sc.elite, answer.trim()))) }
                        }
                        if (xp > 0) Store.award("exercise", "Exercise: ${l.title} (${sc.score})", xp)
                        result = sc
                    }
                    .onFailure { err = it.message }
                busy = false
            }
        }
        Gap(8)
        Text(if (!Groq.ready) "Add your Groq key in Rank → Settings." else if (prev == null) "First attempt earns half your score in XP, plus 10." else "Beating your best earns half the improvement in XP.", style = T.small)
        err?.let { Gap(12); Text(it, style = T.strong) }
    }
}

@Composable
fun TemplateScreen(id: String, nav: Nav) {
    val t = Toolkit.get(id)
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    var busy by remember { mutableStateOf(false) }
    var err by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<Score?>(null) }
    val values = Store.st.docs[id] ?: List(t.fields.size) { "" }

    fun set(i: Int, v: String) = Store.edit { st ->
        val cur = (st.docs[id] ?: List(t.fields.size) { "" }).toMutableList()
        while (cur.size < t.fields.size) cur.add("")
        cur[i] = v
        st.copy(docs = st.docs + (id to cur))
    }

    Page {
        BackRow("Back", nav.back)
        Label("Toolkit")
        Gap(10)
        Text(t.title, style = T.h1)
        Gap(6)
        Text(t.why, style = T.small)
        t.fields.forEachIndexed { i, f ->
            Gap(22)
            Text(f.title, style = T.strong)
            Text(f.hint, style = T.small)
            Gap(8)
            Input(values.getOrNull(i).orEmpty(), { set(i, it) }, "…", singleLine = false, minLines = f.lines)
        }
        Gap(24)
        val filled = values.count { it.isNotBlank() }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PrimaryButton(if (busy) "Reviewing…" else "Panel review", Modifier.weight(1f), enabled = !busy && Groq.ready && filled >= (t.fields.size + 1) / 2) {
                busy = true; err = null
                scope.launch {
                    runCatching { Groq.reviewDoc(t, values) }
                        .onSuccess { sc ->
                            result = sc
                            val first = Store.st.events.none { it.kind == "doc" && it.label.startsWith(t.title) }
                            Store.award("doc", "${t.title} reviewed (${sc.score})", if (first) 30 else 5)
                        }
                        .onFailure { err = it.message }
                    busy = false
                }
            }
            GhostButton("Share", Modifier.weight(1f), enabled = filled > 0) {
                val text = t.fields.mapIndexed { i, f -> "${f.title.uppercase()}\n${values.getOrNull(i).orEmpty()}" }
                    .filterIndexed { i, _ -> values.getOrNull(i).orEmpty().isNotBlank() }.joinToString("\n\n")
                ctx.startActivity(Intent.createChooser(Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, text), t.title))
            }
        }
        Gap(8)
        Text("Saved as you type. Review needs at least half the sections filled.", style = T.small)
        err?.let { Gap(12); Text(it, style = T.strong) }
        result?.let { Gap(24); Rule(color = P.ink, thick = 2.dp); Gap(16); ScoreView(it) }
    }
}

/** "Ask about this lesson": a short conversation with a senior CMO who knows what you just read. */
@Composable
fun AskBox(l: Lesson) {
    val scope = rememberCoroutineScope()
    val qa = remember(l.id) { mutableStateListOf<Msg>() }
    var q by remember(l.id) { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var err by remember { mutableStateOf<String?>(null) }
    Column(Modifier.fillMaxWidth()) {
        Rule(color = P.ink, thick = 2.dp)
        Gap(14)
        Label("Go deeper", color = P.ink)
        Gap(4)
        Text("Ask a senior CMO anything about this lesson — applied to your niche.", style = T.small)
        Gap(12)
        qa.forEach { m ->
            if (m.role == "user") Text(m.text, style = T.strong, modifier = Modifier.padding(top = 10.dp))
            else Text(m.text, style = T.body, modifier = Modifier.padding(top = 6.dp, bottom = 10.dp))
        }
        if (busy) Text("Thinking…", style = T.small, modifier = Modifier.padding(vertical = 8.dp))
        err?.let { Text(it, style = T.strong, modifier = Modifier.padding(vertical = 8.dp)) }
        Row(verticalAlignment = Alignment.Bottom) {
            Input(q, { q = it }, if (Groq.ready) "e.g. How would this work for my niche?" else "Add your Groq key in Settings", Modifier.weight(1f), singleLine = false)
            Spacer(Modifier.width(8.dp))
            PrimaryButton("Ask", enabled = !busy && q.isNotBlank() && Groq.ready) {
                qa.add(Msg("user", q.trim())); q = ""; busy = true; err = null
                scope.launch {
                    runCatching { Groq.askLesson(l, qa.toList()) }
                        .onSuccess { qa.add(Msg("assistant", it)) }
                        .onFailure { err = it.message }
                    busy = false
                }
            }
        }
    }
}
