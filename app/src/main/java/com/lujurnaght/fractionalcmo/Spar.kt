package com.lujurnaght.fractionalcmo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

private val shortDate = DateTimeFormatter.ofPattern("d MMM", Locale.ENGLISH)
fun shortDay(t: Long): String = Instant.ofEpochMilli(t).atZone(ZoneId.systemDefault()).toLocalDate().format(shortDate)

@Composable
fun SparTab(nav: Nav) {
    val s = Store.st
    Page {
        Masthead("Spar", "Where mistakes are free and the feedback is honest.")
        Gap(22)
        if (!Groq.ready) {
            InkPanel {
                Text("Sparring needs your Groq key", style = T.h2.copy(color = P.onInk))
                Gap(6)
                Text("The same free key SovReadr uses. It stays on this phone.", style = T.small.copy(color = P.onInkDim))
                Gap(16)
                PaperButton("Add it in Settings →") { nav.tab(4) }
            }
        }

        Section(1, "Today's case")
        val c = s.case?.takeIf { it.day == today() }
        Column(Modifier.fillMaxWidth().tap { nav.go(Route.CaseR) }) {
            if (c == null) {
                Text("A new company, a real problem, numbers that don't all add up.", style = T.strong)
                Gap(4)
                Text("Write your decision and 30-day plan. A panel of top-1% CMOs grades it and shows you their answer.", style = T.small)
                Gap(14)
                PrimaryButton("Open today's case", Modifier.fillMaxWidth()) { nav.go(Route.CaseR) }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text(c.title, style = T.h2)
                        Text(if (c.score >= 0) "Graded" else "Waiting for your answer", style = T.small)
                    }
                    Text(if (c.score >= 0) c.score.toString() else "→", style = T.num)
                }
            }
        }

        Section(2, "Scenarios")
        Scenarios.all.forEach { sc ->
            Row(
                Modifier.fillMaxWidth().tap { nav.go(Route.SparR(sc.id)) }.padding(vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(Modifier.weight(1f)) {
                    Label(sc.role)
                    Gap(3)
                    Text(sc.title, style = T.h2)
                    Gap(3)
                    Text(sc.setup, style = T.small)
                }
                Spacer(Modifier.width(16.dp))
                val best = s.bestSpar(sc.id)
                Column(horizontalAlignment = Alignment.End) {
                    Text(best?.toString() ?: "—", style = T.num.copy(color = if (best == null) P.faint else P.ink))
                    Label("Best")
                }
            }
            Rule()
        }

        if (s.spars.isNotEmpty()) {
            Section(3, "Record")
            s.spars.sortedByDescending { it.t }.take(8).forEach { r ->
                Row(Modifier.fillMaxWidth().padding(vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(shortDay(r.t), style = T.small, modifier = Modifier.width(56.dp))
                    Column(Modifier.weight(1f)) {
                        Text(Scenarios.all.firstOrNull { it.id == r.id }?.title ?: r.id, style = T.strong)
                        if (r.verdict.isNotBlank()) Text(r.verdict, style = T.small, maxLines = 2)
                    }
                    Text(r.score.toString(), style = T.h2)
                }
                Rule()
            }
        }
    }
}

@Composable
fun CaseScreen(nav: Nav) {
    val scope = rememberCoroutineScope()
    var busy by remember { mutableStateOf(false) }
    var err by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<Score?>(null) }
    val c = Store.st.case?.takeIf { it.day == today() }
    var answer by rememberSaveable { mutableStateOf(c?.answer.orEmpty()) }

    fun draw() {
        if (!Groq.ready) { err = "Add your Groq key in Rank → Settings first."; return }
        busy = true; err = null
        scope.launch {
            runCatching { Groq.newCase() }
                .onSuccess { nc -> Store.edit { it.copy(case = nc) } }
                .onFailure { err = it.message }
            busy = false
        }
    }
    LaunchedEffect(Unit) { if (c == null && Groq.ready) draw() }

    Page {
        BackRow("Back", nav.back)
        Label("Today's case")
        Gap(10)
        if (c == null) {
            Text(if (busy) "Writing today's case…" else "No case yet.", style = T.h1)
            Gap(14)
            if (!busy) PrimaryButton("Draw today's case", Modifier.fillMaxWidth()) { draw() }
        } else {
            Text(c.title, style = T.h1)
            Gap(18)
            Text(c.situation, style = T.body)
            Gap(20)
            Rule(color = P.ink, thick = 2.dp)
            Gap(12)
            Label("The question", color = P.ink)
            Gap(8)
            Text(c.question, style = T.strong.copy(fontSize = 17.sp, lineHeight = 24.sp))
            Gap(20)
            val r = result
            if (r != null) {
                ScoreView(r)
            } else if (c.score >= 0) {
                Label("Your answer")
                Gap(6)
                Text(c.answer, style = T.body)
                Gap(22)
                ScoreView(Score(c.score, emptyList(), c.verdict, "", c.elite))
                Gap(18)
                Text("A new case arrives tomorrow.", style = T.small)
            } else {
                Input(answer, { answer = it }, "Your diagnosis, the decision, and the first 30 days. Use the numbers.", singleLine = false, minLines = 9)
                Gap(14)
                PrimaryButton(if (busy) "The panel is reading…" else "Submit to the panel", Modifier.fillMaxWidth(), enabled = !busy && answer.trim().length > 40) {
                    busy = true; err = null
                    scope.launch {
                        runCatching { Groq.gradeCase(c, answer.trim()) }
                            .onSuccess { sc ->
                                Store.edit { it.copy(case = c.copy(answer = answer.trim(), score = sc.score, verdict = sc.verdict, elite = sc.elite)) }
                                Store.award("case", "Case: ${c.title} (${sc.score})", sc.score / 2 + 10)
                                result = sc
                            }
                            .onFailure { err = it.message }
                        busy = false
                    }
                }
                Gap(8)
                Text("Earns half your score in XP, plus 10.", style = T.small)
            }
        }
        err?.let { Gap(14); Text(it, style = T.strong) }
    }
}

private fun nameOf(s: Scenario): String = s.persona.substringAfter("You are ").substringBefore(",").substringBefore(" ").ifBlank { s.role }

@Composable
fun SparScreen(id: String, nav: Nav) {
    val s = Scenarios.get(id)
    val scope = rememberCoroutineScope()
    val msgs = remember { mutableStateListOf<Msg>() }
    var input by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var err by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<Score?>(null) }
    val list = rememberLazyListState()
    val other = nameOf(s)
    LaunchedEffect(msgs.size, busy, result) { list.animateScrollToItem(maxOf(0, list.layoutInfo.totalItemsCount - 1)) }

    Column(Modifier.fillMaxSize().padding(horizontal = 22.dp)) {
        BackRow("Back", nav.back)
        Label(s.role)
        Gap(4)
        Text(s.title, style = T.h1.copy(fontSize = 24.sp, lineHeight = 28.sp))
        Gap(6)
        Text(s.setup, style = T.small)
        Gap(12)
        Rule(color = P.ink, thick = 2.dp)
        LazyColumn(Modifier.weight(1f).fillMaxWidth(), state = list) {
            item { Gap(14); Bubble(other, s.opener, mine = false) }
            items(msgs) { m -> Bubble(if (m.role == "user") "You" else other, m.text, mine = m.role == "user") }
            if (busy) item { Text(if (result == null && msgs.lastOrNull()?.role == "user") "$other is answering…" else "The panel is grading…", style = T.small, modifier = Modifier.padding(vertical = 10.dp)) }
            err?.let { e -> item { Text(e, style = T.strong, modifier = Modifier.padding(vertical = 10.dp)) } }
            result?.let { r -> item { Gap(10); Rule(color = P.ink, thick = 2.dp); Gap(16); ScoreView(r); Gap(24) } }
        }
        Gap(10)
        if (result == null) {
            Row(verticalAlignment = Alignment.Bottom) {
                Input(input, { input = it }, if (Groq.ready) "Your reply…" else "Add your Groq key in Settings", Modifier.weight(1f), singleLine = false)
                Spacer(Modifier.width(8.dp))
                PrimaryButton("Send", enabled = !busy && input.isNotBlank() && Groq.ready) {
                    msgs.add(Msg("user", input.trim())); input = ""; busy = true; err = null
                    scope.launch {
                        runCatching { Groq.reply(s, msgs.toList()) }
                            .onSuccess { msgs.add(Msg("assistant", it)) }
                            .onFailure { err = it.message }
                        busy = false
                    }
                }
            }
            Gap(8)
            val turns = msgs.count { it.role == "user" }
            GhostButton(if (turns < 3) "End and score  ·  after 3 replies" else "End and score", Modifier.fillMaxWidth(), enabled = !busy && turns >= 3) {
                busy = true; err = null
                scope.launch {
                    runCatching { Groq.gradeSpar(s, msgs.toList()) }
                        .onSuccess { sc ->
                            result = sc
                            Store.edit { it.copy(spars = it.spars + SparRun(s.id, now(), sc.score, sc.verdict)) }
                            Store.award("spar", "Spar: ${s.title} (${sc.score})", sc.score / 2)
                        }
                        .onFailure { err = it.message }
                    busy = false
                }
            }
        } else {
            PrimaryButton("Run it again", Modifier.fillMaxWidth()) { msgs.clear(); result = null; err = null }
        }
        Gap(12)
    }
}

@Composable
private fun Bubble(who: String, text: String, mine: Boolean) {
    Box(Modifier.fillMaxWidth().padding(vertical = 6.dp), contentAlignment = if (mine) Alignment.CenterEnd else Alignment.CenterStart) {
        Column(
            Modifier.fillMaxWidth(0.86f)
                .then(if (mine) Modifier.background(P.ink, Sharp) else Modifier.background(P.sheet, Sharp).border(1.dp, P.rule, Sharp))
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Label(who, color = if (mine) P.onInkDim else P.grey)
            Text(text, style = T.body.copy(color = if (mine) P.onInk else P.ink))
        }
    }
}
