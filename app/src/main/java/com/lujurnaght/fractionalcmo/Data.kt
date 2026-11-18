package com.lujurnaght.fractionalcmo

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters
import java.util.concurrent.Executors
import kotlin.math.max
import kotlin.math.roundToInt

/** A flashcard's schedule. `due` is an epoch day. */
@Serializable data class CardS(val due: Long = 0, val interval: Int = 0, val ease: Double = 2.5, val reps: Int = 0)

/** Anything that earned XP. `kind` groups them: lesson, review, spar, case, quest, client, and the field actions. */
@Serializable data class Ev(val t: Long, val kind: String, val label: String, val xp: Int, val proof: String = "")

@Serializable data class Prospect(
    val id: Long, val name: String, val company: String = "", val stage: Int = 0,
    val monthly: Int = 0, val note: String = "", val updated: Long = 0, val wonPaid: Boolean = false,
)

@Serializable data class SparRun(val id: String, val t: Long, val score: Int, val verdict: String)

@Serializable data class DailyCase(
    val day: Long, val title: String, val situation: String, val question: String,
    val answer: String = "", val score: Int = -1, val verdict: String = "", val elite: String = "",
)

@Serializable data class St(
    val xp: Int = 0,
    val events: List<Ev> = emptyList(),
    val lessons: Set<String> = emptySet(),
    val cards: Map<String, CardS> = emptyMap(),
    val quests: Map<String, Ev> = emptyMap(),
    val prospects: List<Prospect> = emptyList(),
    val spars: List<SparRun> = emptyList(),
    val case: DailyCase? = null,
    val niche: String = "",
    val offer: String = "",
)

object Stages {
    val names = listOf("Target", "Contacted", "Call", "Proposal", "Won", "Lost")
    const val WON = 4
    const val LOST = 5
}

/** What you can log from the field, its XP, and the weekly target that keeps the machine fed. */
data class Action(val kind: String, val name: String, val xp: Int, val weekly: Int, val daily: Int = 0)

val ACTIONS = listOf(
    Action("outreach", "Outreach sent", 5, 25, daily = 5),
    Action("post", "Post published", 15, 3),
    Action("call", "Discovery call", 40, 2),
    Action("proposal", "Proposal sent", 60, 1),
    Action("referral", "Referral asked", 10, 2),
)

object Store {
    var st: St by mutableStateOf(St())
        private set
    private var file: File? = null
    private val io = Executors.newSingleThreadExecutor()
    val json = Json { ignoreUnknownKeys = true; encodeDefaults = false; prettyPrint = false }

    fun init(ctx: Context) {
        val f = File(ctx.filesDir, "state.json")
        file = f
        if (f.exists()) runCatching { st = json.decodeFromString(St.serializer(), f.readText()) }
        Keys.init(ctx)
    }

    fun edit(change: (St) -> St) {
        st = change(st)
        val snap = st
        val f = file ?: return
        io.execute {
            runCatching {
                val tmp = File(f.path + ".tmp")
                tmp.writeText(json.encodeToString(St.serializer(), snap))
                tmp.renameTo(f)
            }
        }
    }

    fun award(kind: String, label: String, xp: Int, proof: String = "") = edit {
        it.copy(xp = it.xp + xp, events = (listOf(Ev(now(), kind, label, xp, proof)) + it.events).take(800))
    }

    fun export(): String = json.encodeToString(St.serializer(), st)
    fun import(text: String) { val s = json.decodeFromString(St.serializer(), text); edit { s } }

    /** The screenshots on the build machine draw a made-up state. */
    fun setForScreens(s: St) { st = s }
}

object Keys {
    var groq: String by mutableStateOf("")
        private set
    private var prefs: SharedPreferences? = null
    fun init(ctx: Context) {
        prefs = ctx.getSharedPreferences("keys", Context.MODE_PRIVATE)
        groq = prefs?.getString("groq", "").orEmpty()
    }
    fun setGroq(v: String) { groq = v.trim(); prefs?.edit()?.putString("groq", groq)?.apply() }
}

fun now(): Long = System.currentTimeMillis()
fun today(): Long = LocalDate.now().toEpochDay()
fun dayOf(t: Long): Long = Instant.ofEpochMilli(t).atZone(ZoneId.systemDefault()).toLocalDate().toEpochDay()
fun weekStart(): Long = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toEpochDay()

fun St.countSince(kind: String, day: Long) = events.count { it.kind == kind && dayOf(it.t) >= day }
fun St.weekCount(kind: String) = countSince(kind, weekStart())
fun St.todayCount(kind: String) = countSince(kind, today())
fun St.total(kind: String) = events.count { it.kind == kind }
fun St.xpToday() = events.filter { dayOf(it.t) == today() }.sumOf { it.xp }

val St.openPipeline: Int get() = prospects.filter { it.stage < Stages.WON }.sumOf { it.monthly }
val St.won: Int get() = prospects.count { it.stage == Stages.WON }
val St.retainers: Int get() = prospects.filter { it.stage == Stages.WON }.sumOf { it.monthly }

/** Days in a row with at least one thing done; today still counts as alive until midnight. */
fun St.streak(): Int {
    val days = events.map { dayOf(it.t) }.toSet()
    var d = today()
    if (d !in days) d -= 1
    var n = 0
    while (d in days) { n++; d-- }
    return n
}

fun St.dueCards(): List<String> {
    val t = today()
    return Curriculum.allLessons.filter { it.id in lessons }.flatMap { l -> l.cards.indices.map { "${l.id}:$it" } }
        .filter { (cards[it]?.due ?: 0) <= t }
}

fun St.bestSpar(id: String): Int? = spars.filter { it.id == id }.maxOfOrNull { it.score }

/** SM-2, simplified: 0 again, 1 hard, 2 good, 3 easy. */
fun schedule(c: CardS, grade: Int, day: Long): CardS {
    if (grade == 0) return c.copy(interval = 0, reps = 0, ease = max(1.3, c.ease - 0.2), due = day)
    val ease = (c.ease + when (grade) { 1 -> -0.15; 3 -> 0.15; else -> 0.0 }).coerceIn(1.3, 3.0)
    val iv = when (c.reps) {
        0 -> if (grade == 3) 3 else 1
        1 -> when (grade) { 1 -> 3; 3 -> 7; else -> 4 }
        else -> max(c.interval + 1, (c.interval * ease * when (grade) { 1 -> 0.6; 3 -> 1.3; else -> 1.0 }).roundToInt())
    }
    return CardS(due = day + iv, interval = iv, ease = ease, reps = c.reps + 1)
}

/** Ranks: XP alone never makes you a CMO. The upper ranks also need something that happened outside the app. */
data class Rank(val title: String, val xp: Int, val gate: String?, val met: (St) -> Boolean)

val RANKS = listOf(
    Rank("Apprentice", 0, null) { true },
    Rank("Strategist", 400, null) { true },
    Rank("Operator", 1200, null) { true },
    Rank("Advisor", 2500, "a first paid project") { "paid1" in it.quests || it.won >= 1 },
    Rank("Fractional CMO", 5000, "a first retainer signed") { "ret1" in it.quests },
    Rank("Elite", 9000, "three retainers at once") { "ret3" in it.quests },
    Rank("Top 1%", 15000, "\$30k a month in retainers") { "mrr30" in it.quests },
)

fun St.rankIndex(): Int {
    var i = 0
    while (i + 1 < RANKS.size && xp >= RANKS[i + 1].xp && RANKS[i + 1].met(this)) i++
    return i
}

fun fmtMoney(v: Int): String = "$" + "%,d".format(v)
fun fmtNum(v: Int): String = "%,d".format(v)
