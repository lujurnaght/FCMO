package com.lujurnaght.fractionalcmo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodayScreen(nav: Nav) {
    val s = Store.st
    val ri = s.rankIndex()
    val rank = RANKS[ri]
    val next = RANKS.getOrNull(ri + 1)
    Page {
        Masthead("Today")
        Gap(22)
        InkPanel {
            Label("Rank", color = P.onInkDim)
            Gap(6)
            Text(rank.title, style = T.hero.copy(color = P.onInk, fontSize = 36.sp, lineHeight = 38.sp))
            Gap(16)
            if (next != null) {
                Row(Modifier.fillMaxWidth()) {
                    Text("${fmtNum(s.xp)} XP", style = T.small.copy(color = P.onInk))
                    Spacer(Modifier.weight(1f))
                    Text("${next.title} at ${fmtNum(next.xp)}", style = T.small.copy(color = P.onInkDim))
                }
                Gap(8)
                Bar((s.xp - rank.xp).toFloat() / (next.xp - rank.xp), track = Color(0xFF3A3936), fill = P.onInk)
                if (next.gate != null) {
                    Gap(12)
                    val blocked = s.xp >= next.xp && !next.met(s)
                    Text(
                        if (blocked) "Locked until ${next.gate}. XP alone doesn't make a CMO." else "${next.title} also needs ${next.gate}.",
                        style = T.small.copy(color = if (blocked) P.onInk else P.onInkDim),
                    )
                }
            } else {
                Text("The top. Now stay there.", style = T.small.copy(color = P.onInkDim))
            }
            Gap(16)
            Row {
                Text("${s.streak()}-day streak", style = T.small.copy(color = P.onInk))
                Text("   ·   +${s.xpToday()} XP today", style = T.small.copy(color = P.onInkDim))
            }
        }

        Section(1, "Three moves")
        val due = s.dueCards().size
        val nextLesson = Curriculum.allLessons.firstOrNull { it.id !in s.lessons }
        val learnedToday = s.todayCount("lesson") > 0 || s.todayCount("review") > 0
        when {
            due > 0 -> Move(false, "Review $due cards", "Learn · keeps what you studied") { nav.go(Route.ReviewR) }
            nextLesson != null -> Move(learnedToday, if (learnedToday) "Studied today" else nextLesson.title,
                if (learnedToday) "Learn · next: ${nextLesson.title}" else "Learn · ${nextLesson.minutes} min lesson") { nav.go(Route.LessonR(nextLesson.id)) }
            else -> Move(learnedToday, "Curriculum complete", "Learn · keep reviewing") { nav.tab(1) }
        }
        val case = s.case?.takeIf { it.day == today() }
        Move(case != null && case.score >= 0,
            when { case == null -> "Solve today's case"; case.score >= 0 -> "Case scored ${case.score}/100"; else -> case.title },
            "Spar · graded by an AI panel") { nav.go(Route.CaseR) }
        val out = s.todayCount("outreach")
        Move(out >= 5, "Send 5 outreach notes", "Field · $out of 5 today") { nav.tab(3) }

        Section(2, "This week")
        val week = ACTIONS.take(4)
        week.chunked(2).forEach { pair ->
            Row(Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                pair.forEach { a ->
                    val n = s.weekCount(a.kind)
                    Figure(n.toString(), a.name, Modifier.weight(1f).padding(end = 18.dp), sub = "target ${a.weekly}", fraction = n.toFloat() / a.weekly)
                }
            }
        }

        Section(3, "The book")
        Row(Modifier.fillMaxWidth()) {
            Figure(fmtMoney(s.retainers), "Signed / month", Modifier.weight(1f))
            Figure(fmtMoney(s.openPipeline), "Open pipeline", Modifier.weight(1f))
        }
        Gap(14)
        Text("${s.won} client${if (s.won == 1) "" else "s"} won · ${s.prospects.count { it.stage < Stages.WON }} open conversations", style = T.small)

        Section(4, "Card of the day")
        val ids = Curriculum.allCards
        val qa = Curriculum.card(ids[(today() % ids.size).toInt()])
        var open by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth().tap { open = !open }) {
            Text(qa.q, style = T.h2)
            Gap(10)
            if (open) Text(qa.a, style = T.body) else Text("Tap to answer it in your head, then check.", style = T.small)
        }
    }
}

@Composable
private fun Move(done: Boolean, title: String, sub: String, onClick: () -> Unit) {
    Column(Modifier.fillMaxWidth().tap(onClick)) {
        Row(Modifier.fillMaxWidth().padding(vertical = 14.dp), verticalAlignment = Alignment.CenterVertically) {
            Tick(done)
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(title, style = T.strong.copy(color = if (done) P.grey else P.ink))
                Text(sub, style = T.small)
            }
            Text("→", style = T.strong)
        }
        Rule()
    }
}
