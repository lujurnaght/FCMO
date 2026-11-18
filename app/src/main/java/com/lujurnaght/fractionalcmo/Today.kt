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
        Text("Picked from your weak spots, your reviews and where your pipeline is stuck.", style = T.small)
        Gap(4)
        Coach.moves(s).forEach { m -> Move(m.done, m.title, m.sub) { m.go(nav) } }

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

data class MoveSpec(val done: Boolean, val title: String, val sub: String, val go: (Nav) -> Unit)

/** Chooses today's three moves: one to learn, one to practise, one in the field. */
object Coach {
    fun moves(s: St): List<MoveSpec> = listOf(learn(s), spar(s), field(s))

    private fun learnedToday(s: St) = listOf("lesson", "review", "exercise").any { s.todayCount(it) > 0 }

    fun learn(s: St): MoveSpec {
        val done = learnedToday(s)
        val due = s.dueCards().size
        if (due >= 5) return MoveSpec(false, "Review $due cards", "Learn · before you forget them") { it.go(Route.ReviewR) }
        val weak = s.exercises.filter { it.value.score < 60 }.minByOrNull { it.value.score }
        if (weak != null) {
            val l = Curriculum.lesson(weak.key)
            return MoveSpec(done && s.todayCount("exercise") > 0, "Redo: ${l.title}", "Learn · your weakest exercise (${weak.value.score}/100)") { it.go(Route.ExerciseR(l.id)) }
        }
        val untried = Curriculum.allLessons.lastOrNull { it.id in s.lessons && it.exercise != null && it.id !in s.exercises }
        if (untried != null) return MoveSpec(false, "Exercise: ${untried.title}", "Learn · you read it, now prove it") { it.go(Route.ExerciseR(untried.id)) }
        val next = nextLesson(s)
        if (next != null) return MoveSpec(done, if (done) "Studied today" else next.title,
            if (done) "Learn · next: ${next.title}" else "Learn · ${Curriculum.trackOf(next.id).title} · ${next.minutes} min") { it.go(Route.LessonR(next.id)) }
        if (due > 0) return MoveSpec(false, "Review $due cards", "Learn · keep it fresh") { it.go(Route.ReviewR) }
        return MoveSpec(done, "Curriculum complete", "Learn · keep your exercises above 80") { it.tab(1) }
    }

    /** Until you've signed a client, the money tracks come first. */
    fun nextLesson(s: St): Lesson? {
        val order = if (s.won == 0) listOf(PIPELINE, CLOSING) + Curriculum.tracks.filter { it !== PIPELINE && it !== CLOSING } else Curriculum.tracks
        return order.flatMap { it.lessons }.firstOrNull { it.id !in s.lessons }
    }

    fun spar(s: St): MoveSpec {
        val case = s.case?.takeIf { it.day == today() }
        if (case == null || case.score < 0) return MoveSpec(false, case?.title ?: "Solve today's case", "Spar · graded by a panel of top CMOs") { it.go(Route.CaseR) }
        val sparredToday = s.todayCount("spar") > 0
        val pick = Scenarios.everything.firstOrNull { s.bestSpar(it.id) == null }
            ?: Scenarios.everything.minByOrNull { s.bestSpar(it.id) ?: 0 }!!
        val best = s.bestSpar(pick.id)
        return MoveSpec(sparredToday, if (sparredToday) "Sparred today" else "Spar: ${pick.title}",
            if (best == null) "Spar · ${pick.role.lowercase()}, not tried yet" else "Spar · your weakest room (best $best)") { it.go(Route.SparR(pick.id)) }
    }

    fun field(s: St): MoveSpec {
        if (s.niche.isBlank()) return MoveSpec(false, "Write your niche", "Field · industry × stage × problem") { it.tab(3) }
        val week = 7 * 86_400_000L
        val stale = s.prospects.filter { it.stage == Stages.WON - 1 && now() - it.updated > week }.minByOrNull { it.updated }
        if (stale != null) {
            val days = (now() - stale.updated) / 86_400_000L
            return MoveSpec(false, "Follow up with ${stale.name}", "Field · proposal sent $days days ago — use JOLT") { it.tab(3) }
        }
        val warm = s.prospects.filter { it.stage == 1 }.maxByOrNull { it.monthly }
        if (warm != null && s.weekCount("call") < 2) return MoveSpec(false, "Book a call with ${warm.name}", "Field · ${s.weekCount("call")} of 2 calls this week") { it.tab(3) }
        val out = s.todayCount("outreach")
        return MoveSpec(out >= 5, "Send 5 outreach notes", "Field · $out of 5 today") { it.tab(3) }
    }
}
