package com.lujurnaght.fractionalcmo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LearnScreen(nav: Nav) {
    val s = Store.st
    val total = Curriculum.allLessons.size
    val done = Curriculum.allLessons.count { it.id in s.lessons }
    val due = s.dueCards().size
    Page {
        Masthead("Learn", "$done of $total lessons · ${s.cards.count { it.value.reps > 0 }} cards in memory")
        Gap(22)
        if (due > 0) {
            InkPanel {
                Label("Spaced review", color = P.onInkDim)
                Gap(6)
                Text("$due card${if (due == 1) "" else "s"} due", style = T.h1.copy(color = P.onInk))
                Gap(4)
                Text("Reviewing at the right moment is what makes it stick.", style = T.small.copy(color = P.onInkDim))
                Gap(16)
                PaperButton("Start review →") { nav.go(Route.ReviewR) }
            }
        } else {
            Text("No cards due. Every lesson you complete adds its cards to your review.", style = T.small)
        }
        Curriculum.tracks.forEachIndexed { i, t ->
            val d = t.lessons.count { it.id in s.lessons }
            Section(i + 1, t.title, trailing = { Text("$d/${t.lessons.size}", style = T.small) })
            Text(t.blurb, style = T.small)
            Gap(6)
            t.lessons.forEach { l ->
                Row(
                    Modifier.fillMaxWidth().tap { nav.go(Route.LessonR(l.id)) }.padding(vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Tick(l.id in s.lessons, size = 18.dp)
                    Spacer(Modifier.width(14.dp))
                    Text(l.title, style = T.strong, modifier = Modifier.weight(1f))
                    Text("${l.minutes} min", style = T.small)
                }
                Rule()
            }
        }
    }
}

@Composable
fun LessonScreen(id: String, nav: Nav) {
    val l = Curriculum.lesson(id)
    val t = Curriculum.trackOf(id)
    val ti = Curriculum.tracks.indexOf(t) + 1
    val done = id in Store.st.lessons
    Page {
        BackRow("Back", nav.back)
        Label("${ti.toString().padStart(2, '0')} · ${t.title}")
        Gap(10)
        Text(l.title, style = T.h1)
        Gap(6)
        Text("${l.minutes} min read", style = T.small)
        Gap(22)
        l.body.split("\n\n").forEach { p ->
            Text(p.trim(), style = T.body)
            Gap(16)
        }
        Rule(color = P.ink, thick = 2.dp)
        Gap(14)
        Label("Key moves", color = P.ink)
        Gap(10)
        Bullets(l.moves)
        Gap(24)
        Label("Cards you'll keep")
        Gap(8)
        l.cards.forEach { Text(it.q, style = T.small.copy(color = P.inkSoft)); Gap(6) }
        Gap(24)
        if (!done) {
            PrimaryButton("Complete lesson   +20 XP", Modifier.fillMaxWidth()) {
                Store.edit { st ->
                    st.copy(lessons = st.lessons + id, cards = st.cards + l.cards.indices.associate { "$id:$it" to (st.cards["$id:$it"] ?: CardS(due = today())) })
                }
                Store.award("lesson", l.title, 20)
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Tick(true)
                Spacer(Modifier.width(10.dp))
                Text("Completed. Its cards are in your review.", style = T.strong)
            }
        }
        val all = Curriculum.allLessons
        val next = all.getOrNull(all.indexOf(l) + 1)
        if (next != null) {
            Gap(14)
            GhostButton("Next: ${next.title} →", Modifier.fillMaxWidth()) { nav.replace(Route.LessonR(next.id)) }
        }
    }
}

@Composable
fun ReviewScreen(nav: Nav) {
    val queue = remember { mutableStateListOf<String>().apply { addAll(Store.st.dueCards().shuffled()) } }
    var shown by remember { mutableStateOf(false) }
    var reviewed by remember { mutableIntStateOf(0) }
    Page {
        BackRow("Back", nav.back)
        if (queue.isEmpty()) {
            Gap(30)
            Text("Done.", style = T.hero)
            Gap(8)
            Text(if (reviewed == 0) "Nothing was due." else "$reviewed review${if (reviewed == 1) "" else "s"}. They'll come back when you're about to forget them.", style = T.body)
            Gap(24)
            PrimaryButton("Back", Modifier.fillMaxWidth()) { nav.back() }
            return@Page
        }
        val id = queue.first()
        val qa = Curriculum.card(id)
        val lesson = Curriculum.lesson(id.substringBefore(':'))
        Row(Modifier.fillMaxWidth()) {
            Label("$reviewed done")
            Spacer(Modifier.weight(1f))
            Label("${queue.size} left")
        }
        Gap(8)
        Bar(reviewed.toFloat() / (reviewed + queue.size))
        Gap(22)
        Column(
            Modifier.fillMaxWidth().heightIn(min = 260.dp).background(P.sheet, Sharp).border(1.dp, P.rule, Sharp).tap { shown = true }.padding(22.dp),
        ) {
            Label(lesson.title)
            Gap(14)
            Text(qa.q, style = T.h2.copy(fontSize = 22.sp, lineHeight = 28.sp))
            if (shown) {
                Gap(18)
                Rule()
                Gap(18)
                Text(qa.a, style = T.body.copy(color = P.ink))
            }
        }
        Gap(18)
        if (!shown) {
            PrimaryButton("Show answer", Modifier.fillMaxWidth()) { shown = true }
        } else {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Again", "Hard", "Good", "Easy").forEachIndexed { g, name ->
                    val m = Modifier.weight(1f)
                    val act = {
                        val c = Store.st.cards[id] ?: CardS()
                        Store.edit { it.copy(cards = it.cards + (id to schedule(c, g, today()))) }
                        queue.removeAt(0)
                        if (g == 0) queue.add(id) else { reviewed++; awardReview() }
                        shown = false
                    }
                    if (g == 2) PrimaryButton(name, m, onClick = act) else GhostButton(name, m, onClick = act)
                }
            }
            Gap(10)
            Text("Again brings it back in this session. Easy pushes it far out.", style = T.small)
        }
    }
}

/** Reviews add up into one entry a day, two XP a card, up to 60. */
private fun awardReview() = Store.edit { st ->
    val e = st.events.firstOrNull()
    if (e != null && e.kind == "review" && dayOf(e.t) == today()) {
        if (e.xp >= 60) st
        else st.copy(xp = st.xp + 2, events = listOf(e.copy(xp = e.xp + 2, label = "Reviewed ${(e.xp + 2) / 2} cards")) + st.events.drop(1))
    } else st.copy(xp = st.xp + 2, events = (listOf(Ev(now(), "review", "Reviewed 1 card", 2)) + st.events).take(800))
}
