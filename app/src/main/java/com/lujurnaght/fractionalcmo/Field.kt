package com.lujurnaght.fractionalcmo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.unit.dp

@Composable
fun FieldScreen(@Suppress("UNUSED_PARAMETER") nav: Nav) {
    val s = Store.st
    Page {
        Masthead("Field", "Only what happens outside the app counts here.")

        Section(1, "Log an action")
        var sel by remember { mutableStateOf<String?>(null) }
        var proof by remember { mutableStateOf("") }
        ACTIONS.forEach { a ->
            val open = sel == a.kind
            Column(Modifier.fillMaxWidth()) {
                Row(
                    Modifier.fillMaxWidth().tap { sel = if (open) null else a.kind; proof = "" }.padding(vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(a.name, style = T.strong)
                        Text("${s.weekCount(a.kind)} of ${a.weekly} this week · ${s.todayCount(a.kind)} today", style = T.small)
                    }
                    Text("+${a.xp}", style = T.h2)
                }
                if (open) {
                    Input(proof, { proof = it }, "Who, where, a link — proof keeps you honest", singleLine = false)
                    Gap(10)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        PrimaryButton("Log it   +${a.xp} XP") {
                            Store.award(a.kind, a.name, a.xp, proof.trim()); proof = ""
                        }
                        GhostButton("Done") { sel = null }
                    }
                    Gap(14)
                }
                Rule()
            }
        }

        Section(2, "Pipeline", trailing = { Text("${fmtMoney(s.openPipeline)}/mo open", style = T.small) })
        var adding by remember { mutableStateOf(false) }
        if (adding) {
            var name by remember { mutableStateOf("") }
            var company by remember { mutableStateOf("") }
            var monthly by remember { mutableStateOf("") }
            Input(name, { name = it }, "Contact name")
            Gap(8)
            Input(company, { company = it }, "Company")
            Gap(8)
            Input(monthly, { monthly = it.filter(Char::isDigit).take(7) }, "Monthly value in \$ (if they sign)", numeric = true)
            Gap(10)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                PrimaryButton("Add", enabled = name.isNotBlank()) {
                    val p = Prospect(now(), name.trim(), company.trim(), 0, monthly.toIntOrNull() ?: 0, updated = now())
                    Store.edit { it.copy(prospects = it.prospects + p) }
                    adding = false
                }
                GhostButton("Cancel") { adding = false }
            }
        } else {
            GhostButton("+  Add a prospect", Modifier.fillMaxWidth()) { adding = true }
        }
        Gap(8)
        if (s.prospects.isEmpty()) {
            Gap(6)
            Text("No one yet. Your first 50 targets go here.", style = T.small)
        }
        var openId by remember { mutableStateOf<Long?>(null) }
        s.prospects.sortedWith(compareBy<Prospect> { if (it.stage == Stages.LOST) 9 else if (it.stage == Stages.WON) 8 else 3 - it.stage }.thenByDescending { it.updated })
            .forEach { p -> ProspectRow(p, openId == p.id) { openId = if (openId == p.id) null else p.id } }

        Section(3, "Positioning")
        Label("Your niche · industry × stage × problem")
        Gap(8)
        Input(s.niche, { v -> Store.edit { it.copy(niche = v) } }, "e.g. B2B SaaS, \$2–10M ARR, stuck after founder-led sales", singleLine = false)
        Gap(16)
        Label("Your offer · diagnostic + retainer, with prices")
        Gap(8)
        Input(s.offer, { v -> Store.edit { it.copy(offer = v) } }, "e.g. 3-week Growth Diagnostic \$6k → retainer \$9k/mo, 2 days a week", singleLine = false, minLines = 3)

        Section(4, "Quests")
        Text("Claimed with proof. The upper ranks unlock only through these.", style = T.small)
        var openQ by remember { mutableStateOf<String?>(null) }
        Quests.chapters.forEachIndexed { ci, ch ->
            Gap(18)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Label("Chapter ${ci + 1} · ${ch.title}", color = P.ink)
                Spacer(Modifier.weight(1f))
                Label("${ch.quests.count { it.id in s.quests }}/${ch.quests.size}")
            }
            Gap(4)
            ch.quests.forEach { q -> QuestRow(q, s.quests[q.id], openQ == q.id) { openQ = if (openQ == q.id) null else q.id } }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProspectRow(p: Prospect, open: Boolean, toggle: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth().tap(toggle).padding(vertical = 13.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(p.name, style = T.strong.copy(color = if (p.stage == Stages.LOST) P.faint else P.ink))
                Text(listOf(p.company, Stages.names[p.stage]).filter { it.isNotBlank() }.joinToString(" · "), style = T.small)
            }
            if (p.monthly > 0) Text("${fmtMoney(p.monthly)}/mo", style = T.strong.copy(color = if (p.stage == Stages.LOST) P.faint else P.ink))
        }
        if (open) {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Stages.names.forEachIndexed { i, n ->
                    Chip(n, p.stage == i) { setStage(p, i) }
                }
            }
            Gap(10)
            var monthly by remember(p.id) { mutableStateOf(if (p.monthly > 0) p.monthly.toString() else "") }
            Input(monthly, { v -> monthly = v.filter(Char::isDigit).take(7); update(p.id) { it.copy(monthly = monthly.toIntOrNull() ?: 0) } }, "Monthly value in \$", numeric = true)
            Gap(8)
            Input(p.note, { v -> update(p.id) { it.copy(note = v) } }, "Notes: pain, next step, date", singleLine = false)
            Gap(10)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                GhostButton("Delete") { Store.edit { st -> st.copy(prospects = st.prospects.filter { it.id != p.id }) } }
            }
            Gap(14)
        }
        Rule()
    }
}

private fun update(id: Long, change: (Prospect) -> Prospect) = Store.edit { st ->
    st.copy(prospects = st.prospects.map { if (it.id == id) change(it).copy(updated = now()) else it })
}

private fun setStage(p: Prospect, stage: Int) {
    val first = stage == Stages.WON && !p.wonPaid
    update(p.id) { it.copy(stage = stage, wonPaid = it.wonPaid || first) }
    if (first) Store.award("client", "Signed ${p.name}${if (p.company.isNotBlank()) " (${p.company})" else ""}", 300)
}

@Composable
private fun QuestRow(q: Quest, done: Ev?, open: Boolean, toggle: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth().tap(toggle).padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Tick(done != null, size = 18.dp)
            Spacer(Modifier.width(14.dp))
            Text(q.title, style = T.strong.copy(color = if (done != null) P.grey else P.ink), modifier = Modifier.weight(1f))
            Text("+${q.xp}", style = T.small.copy(color = P.ink))
        }
        if (open) {
            Text(q.detail, style = T.body)
            Gap(10)
            if (done != null) {
                Label("Claimed ${shortDay(done.t)}")
                if (done.proof.isNotBlank()) Text(done.proof, style = T.small)
            } else {
                var proof by remember(q.id) { mutableStateOf("") }
                Input(proof, { proof = it }, "Proof: a link, a name, a number", singleLine = false)
                Gap(10)
                PrimaryButton("Claim   +${q.xp} XP", enabled = proof.isNotBlank()) {
                    val e = Ev(now(), "quest", q.title, q.xp, proof.trim())
                    Store.edit { it.copy(xp = it.xp + q.xp, quests = it.quests + (q.id to e), events = (listOf(e) + it.events).take(800)) }
                }
            }
            Gap(14)
        }
        Rule()
    }
}
