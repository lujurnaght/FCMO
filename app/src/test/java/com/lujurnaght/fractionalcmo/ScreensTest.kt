package com.lujurnaght.fractionalcmo

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/** The screens drawn on the build machine (tall, so whole pages show), looked at before a release. */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [34], qualifiers = "w384dp-h1900dp-xhdpi")
class ScreensTest {
    @get:Rule val rule = createAndroidComposeRule<ComponentActivity>()

    @Before fun setUp() {
        val day = 86_400_000L
        val t = now()
        val ev = mutableListOf<Ev>()
        (0..8).forEach { d -> ev += Ev(t - d * day, "outreach", "Outreach sent", 5, "note to founder") }
        ev += Ev(t, "outreach", "Outreach sent", 5)
        ev += Ev(t - day, "post", "Post published", 15)
        ev += Ev(t - 2 * day, "call", "Discovery call", 40, "Maya, ShiftWell")
        ev += Ev(t, "lesson", "Unit economics that matter", 20)
        ev.sortByDescending { it.t }
        val lessons = setOf("role1", "role2", "role3", "pos1", "num1")
        Store.setForScreens(
            St(
                xp = 1340, events = ev, lessons = lessons,
                cards = Curriculum.allCards.filter { it.substringBefore(':') in lessons }.associateWith { CardS(due = if (it.startsWith("role")) today() else today() + 3, reps = 1) },
                quests = mapOf("niche" to Ev(t - 3 * day, "quest", "Write your niche", 50, "B2B SaaS, \$2–10M ARR, stuck after founder-led sales")),
                prospects = listOf(
                    Prospect(1, "Maya Okafor", "ShiftWell", 2, 9000, updated = t),
                    Prospect(2, "Karim Benali", "Ledgerly", 3, 7000, updated = t),
                    Prospect(3, "Daniel Reyes", "Northline", 1, 0, updated = t),
                ),
                spars = listOf(SparRun("disc", t - day, 64, "Good questions, but you never quantified the cost of flat growth.")),
                case = DailyCase(today(), "The clinic app that stopped growing", "ShiftWell sells scheduling software to outpatient clinics at \$450 a month. ARR is \$3.2M and flat for three quarters.", "What do you change first, and what does your first month look like?"),
                niche = "B2B SaaS, \$2–10M ARR, stuck after founder-led sales",
            ),
        )
    }

    private fun shot(name: String, tab: Int = 0, route: Route? = null) {
        rule.setContent { AppTheme { App(startTab = tab, startRoute = route) } }
        rule.waitForIdle()
        rule.onRoot().captureRoboImage("build/screens/$name.png")
    }

    @Test fun today() = shot("1_today", 0)
    @Test fun learn() = shot("2_learn", 1)
    @Test fun spar() = shot("3_spar", 2)
    @Test fun field() = shot("4_field", 3)
    @Test fun rank() = shot("5_rank", 4)
    @Test fun lesson() = shot("6_lesson", 1, Route.LessonR("num1"))
    @Test fun review() = shot("7_review", 1, Route.ReviewR)

    @Test fun score() {
        rule.setContent {
            AppTheme {
                Box(Modifier.fillMaxSize().background(P.paper).padding(22.dp)) {
                    ScoreView(Score(72, listOf(
                        Criterion("Pain uncovered", 4, "You got to the flat growth and the board pressure fast."),
                        Criterion("Impact quantified", 2, "You never put a number on three flat quarters."),
                        Criterion("Decision process", 3, "You learned the board matters, not who signs."),
                        Criterion("Quality of questions", 4, "Open, specific, well sequenced."),
                        Criterion("Next step secured", 5, "A diagnostic call booked for Thursday."),
                    ), "Senior discovery with one hole: the money. Without the cost of inaction you can't price.", "Asking what the board will ask in seven weeks.",
                        "Open with the board meeting, not the product. 'In seven weeks your board will ask why growth is flat. What will you tell them?' Then quantify: three flat quarters at \$3.2M is roughly \$1M of growth you planned and didn't get. Propose a three-week diagnostic that ends with the board narrative, priced against that number.")),
                    )
                }
            }
        }
        rule.waitForIdle()
        rule.onRoot().captureRoboImage("build/screens/8_score.png")
    }
}
