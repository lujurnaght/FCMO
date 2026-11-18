package com.lujurnaght.fractionalcmo

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

sealed interface Route {
    data class LessonR(val id: String) : Route
    data object ReviewR : Route
    data class SparR(val id: String) : Route
    data object CaseR : Route
    data class ExerciseR(val id: String) : Route
    data class TemplateR(val id: String) : Route
}

class Nav(val go: (Route) -> Unit, val back: () -> Unit, val replace: (Route) -> Unit, val tab: (Int) -> Unit)

val TABS = listOf("Today", "Learn", "Spar", "Field", "Rank")

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun App(startTab: Int = 0, startRoute: Route? = null) {
    var tab by rememberSaveable { mutableIntStateOf(startTab) }
    var stack by remember { mutableStateOf(listOfNotNull(startRoute)) }
    val nav = remember {
        Nav(
            go = { stack = stack + it },
            back = { stack = stack.dropLast(1) },
            replace = { stack = stack.dropLast(1) + it },
            tab = { tab = it; stack = emptyList() },
        )
    }
    BackHandler(enabled = stack.isNotEmpty()) { nav.back() }

    Column(Modifier.fillMaxSize().background(P.paper).windowInsetsPadding(WindowInsets.safeDrawing)) {
        Box(Modifier.weight(1f).fillMaxWidth()) {
            when (val r = stack.lastOrNull()) {
                null -> when (tab) {
                    0 -> TodayScreen(nav)
                    1 -> LearnScreen(nav)
                    2 -> SparTab(nav)
                    3 -> FieldScreen(nav)
                    else -> RankScreen(nav)
                }
                is Route.LessonR -> LessonScreen(r.id, nav)
                Route.ReviewR -> ReviewScreen(nav)
                is Route.SparR -> SparScreen(r.id, nav)
                Route.CaseR -> CaseScreen(nav)
                is Route.ExerciseR -> ExerciseScreen(r.id, nav)
                is Route.TemplateR -> TemplateScreen(r.id, nav)
            }
        }
        if (stack.isEmpty() && !WindowInsets.isImeVisible) BottomBar(tab) { tab = it }
    }
}

@Composable
private fun BottomBar(selected: Int, onSelect: (Int) -> Unit) {
    Column(Modifier.fillMaxWidth().background(P.paper)) {
        Rule()
        Row(Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
            TABS.forEachIndexed { i, name ->
                val on = i == selected
                Column(
                    Modifier.weight(1f).tap { onSelect(i) }.padding(bottom = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(Modifier.width(28.dp).height(3.dp).background(if (on) P.ink else Color.Transparent))
                    Spacer(Modifier.height(11.dp))
                    Text(name, style = T.small.copy(color = if (on) P.ink else P.faint, fontWeight = FontWeight(if (on) 700 else 500), fontSize = 13.sp))
                }
            }
        }
    }
}

@Composable
fun Page(content: @Composable ColumnScope.() -> Unit) {
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 22.dp).padding(bottom = 48.dp),
        content = content,
    )
}

private val dateFmt = DateTimeFormatter.ofPattern("EEE d MMM", Locale.ENGLISH)

@Composable
fun Masthead(title: String, sub: String? = null) {
    Row(Modifier.fillMaxWidth().padding(top = 14.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(9.dp).background(P.ink))
        Spacer(Modifier.width(8.dp))
        Label("Fractional CMO", color = P.ink)
        Spacer(Modifier.weight(1f))
        Label(LocalDate.now().format(dateFmt))
    }
    Spacer(Modifier.height(22.dp))
    Text(title, style = T.hero)
    if (sub != null) { Spacer(Modifier.height(6.dp)); Text(sub, style = T.small) }
}

/** The black slab: used sparingly, for the one thing on a page that matters most. */
@Composable
fun InkPanel(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier.fillMaxWidth().background(P.ink, Sharp).padding(20.dp), content = content)
}

@Composable
fun PaperButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier.background(P.onInk, Sharp).tap(onClick).padding(horizontal = 18.dp, vertical = 13.dp),
        contentAlignment = Alignment.Center,
    ) { Text(text, style = T.button.copy(color = P.ink)) }
}

@Composable
fun ScoreView(s: Score) {
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(s.score.toString(), style = T.hero.copy(fontSize = 64.sp, lineHeight = 64.sp))
            Spacer(Modifier.width(6.dp))
            Text("/ 100", style = T.h2.copy(color = P.faint), modifier = Modifier.padding(bottom = 8.dp))
        }
        Spacer(Modifier.height(8.dp))
        Text(s.verdict, style = T.strong)
        Spacer(Modifier.height(18.dp))
        s.criteria.forEach { c ->
            Row(Modifier.fillMaxWidth().padding(vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(c.name, style = T.strong.copy(fontSize = 14.sp), modifier = Modifier.weight(1f))
                Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                    (1..5).forEach { k -> Box(Modifier.size(width = 14.dp, height = 8.dp).background(if (k <= c.score) P.ink else P.rule)) }
                }
            }
            if (c.note.isNotBlank()) Text(c.note, style = T.small)
            Spacer(Modifier.height(4.dp))
            Rule()
        }
        if (s.best.isNotBlank()) {
            Spacer(Modifier.height(18.dp))
            Label("Your best move")
            Spacer(Modifier.height(6.dp))
            Text(s.best, style = T.body)
        }
        if (s.elite.isNotBlank()) {
            Spacer(Modifier.height(20.dp))
            InkPanel {
                Label("How a top-1% CMO would play it", color = P.onInkDim)
                Spacer(Modifier.height(10.dp))
                Text(s.elite, style = T.body.copy(color = P.onInk))
            }
        }
    }
}

@Composable
fun Gap(h: Int) = Spacer(Modifier.height(h.dp))
