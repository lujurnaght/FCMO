package com.lujurnaght.fractionalcmo

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun RankScreen(@Suppress("UNUSED_PARAMETER") nav: Nav) {
    val s = Store.st
    val ri = s.rankIndex()
    val ctx = LocalContext.current
    var msg by remember { mutableStateOf<String?>(null) }
    val exporter = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/json")) { uri ->
        if (uri != null) msg = runCatching {
            ctx.contentResolver.openOutputStream(uri)!!.use { it.write(Store.export().toByteArray()) }
            "Backup saved."
        }.getOrElse { "Couldn't save: ${it.message}" }
    }
    val importer = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) msg = runCatching {
            Store.import(ctx.contentResolver.openInputStream(uri)!!.use { it.readBytes().decodeToString() })
            "Backup restored."
        }.getOrElse { "That file isn't a Fractional CMO backup." }
    }

    Page {
        Masthead("Rank", "${fmtNum(s.xp)} XP earned")

        Section(1, "The ladder")
        RANKS.forEachIndexed { i, r ->
            val reached = i <= ri
            Row(Modifier.fillMaxWidth().padding(vertical = 13.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier.size(14.dp).then(
                        if (reached) Modifier.background(P.ink) else Modifier.border(1.5.dp, P.faint),
                    ),
                )
                Spacer(Modifier.width(14.dp))
                Column(Modifier.weight(1f)) {
                    Text(r.title, style = (if (i == ri) T.h2 else T.strong).copy(color = if (reached) P.ink else P.faint))
                    Text(fmtNum(r.xp) + " XP" + (r.gate?.let { " + $it" } ?: ""), style = T.small)
                }
                if (i == ri) Label("You", color = P.ink)
                else if (!reached && r.gate != null) Label(if (r.met(s)) "Proof ✓" else "Needs proof")
            }
            Rule()
        }

        Section(2, "Record")
        val figures = listOf(
            "${s.lessons.size}/${Curriculum.allLessons.size}" to "Lessons",
            s.cards.count { it.value.reps > 0 }.toString() to "Cards known",
            s.spars.size.toString() to "Spars",
            s.exercises.size.toString() to "Exercises",
            (s.exercises.values.maxOfOrNull { it.score }?.toString() ?: "—") to "Best exercise",
            (s.spars.maxOfOrNull { it.score }?.toString() ?: "—") to "Best spar",
            fmtNum(s.total("outreach")) to "Outreach",
            s.total("call").toString() to "Calls",
            s.won.toString() to "Clients",
            s.streak().toString() to "Day streak",
        )
        figures.chunked(2).forEach { pair ->
            Row(Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                pair.forEach { (v, l) -> Figure(v, l, Modifier.weight(1f)) }
            }
        }

        Section(3, "Settings")
        Label("Groq API key · free at console.groq.com")
        Gap(8)
        var key by remember { mutableStateOf(Keys.groq) }
        var show by remember { mutableStateOf(false) }
        Input(key, { key = it }, "gsk_…", secret = !show)
        Gap(10)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            PrimaryButton("Save key", enabled = key.trim() != Keys.groq) { Keys.saveGroq(key) }
            GhostButton(if (show) "Hide" else "Show") { show = !show }
            Spacer(Modifier.width(4.dp))
            Text(if (Keys.groq.isBlank()) "Not set" else "Saved on this phone", style = T.small)
        }
        Gap(24)
        Label("Backup · everything except the key")
        Gap(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            GhostButton("Export…") { exporter.launch("FractionalCMO-${LocalDate.now()}.json") }
            GhostButton("Import…") { importer.launch(arrayOf("application/json", "text/plain", "*/*")) }
        }
        msg?.let { Gap(8); Text(it, style = T.small.copy(color = P.ink)) }

        Section(4, "Activity")
        if (s.events.isEmpty()) Text("Nothing yet. Today's three moves are a good start.", style = T.small)
        s.events.take(40).forEach { e ->
            Row(Modifier.fillMaxWidth().padding(vertical = 9.dp), verticalAlignment = Alignment.Top) {
                Text(shortDay(e.t), style = T.small, modifier = Modifier.width(56.dp))
                Column(Modifier.weight(1f)) {
                    Text(e.label, style = T.body.copy(color = P.ink))
                    if (e.proof.isNotBlank()) Text(e.proof, style = T.small, maxLines = 2)
                }
                Text("+${e.xp}", style = T.strong)
            }
            Rule()
        }
    }
}
