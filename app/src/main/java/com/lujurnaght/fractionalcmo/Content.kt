package com.lujurnaght.fractionalcmo

data class QA(val q: String, val a: String)
data class Exercise(val prompt: String, val rubric: List<String>)
data class Lesson(
    val id: String, val title: String, val minutes: Int, val body: String, val moves: List<String>, val cards: List<QA>,
    val example: String = "", val exercise: Exercise? = null, val template: String? = null, val sources: List<String> = emptyList(),
)
data class Track(val id: String, val title: String, val blurb: String, val lessons: List<Lesson>)

object Curriculum {
    val tracks = listOf(ROLE, POSITION, NUMBERS, CHANNELS, MACHINE, PIPELINE, CLOSING, DELIVERY, AI_TRACK)

    val allLessons: List<Lesson> = tracks.flatMap { it.lessons }
    fun lesson(id: String) = allLessons.first { it.id == id }
    fun trackOf(id: String) = tracks.first { t -> t.lessons.any { it.id == id } }
    fun card(id: String): QA { val (l, i) = id.split(":"); return lesson(l).cards[i.toInt()] }
    val allCards: List<String> = allLessons.flatMap { l -> l.cards.indices.map { "${l.id}:$it" } }
}

data class Scenario(
    val id: String, val title: String, val role: String, val setup: String,
    val persona: String, val opener: String, val rubric: List<String>,
)

object Scenarios {
    val all = listOf(
        Scenario("disc", "The stuck founder", "Discovery call",
            "Maya, CEO of a B2B scheduling app for clinics. Growth has been flat for three quarters. Run discovery and earn a next step.",
            "You are Maya Okafor, CEO and founder of ShiftWell, B2B scheduling software for outpatient clinics. Facts (reveal only when asked well): \$3.2M ARR, flat for three quarters; marketing is one junior marketer plus an agency running Google Ads at \$18k/month; nobody knows CAC; monthly churn about 2.5%; the sales team of 3 says leads are bad; board meeting in 7 weeks and the board is asking hard questions; you tried a consultant last year who delivered a deck and nothing changed, so you're skeptical. You are busy and slightly defensive, but honest when someone asks sharp questions. You would pay for help if you felt understood and saw a clear first step.",
            "Hi — I've got about twenty minutes. Honestly I'm not sure a fractional CMO is what we need, we tried a consultant last year. What did you want to cover?",
            listOf("Pain uncovered", "Impact quantified", "Decision process", "Quality of questions", "Next step secured")),
        Scenario("agency", "Why not just an agency?", "Objection",
            "Daniel, COO of an \$8M e-commerce brand, thinks an agency would be cheaper. Win the argument without arguing.",
            "You are Daniel Reyes, COO of Northline, a direct-to-consumer outdoor apparel brand doing \$8M revenue a year. Paid social is 70% of acquisition and CPMs keep rising; ROAS fell from 3.1 to 2.2 in a year. You've talked to an agency that would charge \$12k/month all-in. You think a fractional CMO is overhead. You respect people who are concrete and don't get defensive. You push back with realistic objections: cost, 'agencies have whole teams', 'we just need better ads'.",
            "Look, I'll be straight with you. An agency quoted us twelve grand a month and they come with a whole team. Why would I pay you on top of that, or instead of that?",
            listOf("Reframe", "Specificity", "Composure", "Proof and logic", "Moves toward a decision")),
        Scenario("board", "Defend the budget", "Board meeting",
            "Elena, a VC on the board, wants to cut marketing 30% because CAC rose 40%. Make your case.",
            "You are Elena Varga, a partner at a Series A fund, on the board of a B2B SaaS company (\$6M ARR). Marketing spend is \$1.1M a year. Blended CAC rose 40% over two quarters. You want to cut marketing 30% to extend runway. Facts you'll confirm only if asked or if the CMO raises them: most of the CAC increase came from one paid channel; pipeline from content and partners grew; win rates dipped because sales headcount changed. You are sharp, numbers-first, impatient with vague answers, but persuadable by a clear diagnosis and a credible plan with milestones.",
            "Let's not dance around it. CAC is up forty percent in two quarters. I'm proposing we cut marketing by thirty percent and extend runway. Convince me otherwise — with numbers.",
            listOf("Command of the numbers", "Diagnosis", "Credible plan", "Composure under pressure", "Gives the board a decision")),
        Scenario("nego", "They want half price", "Negotiation",
            "Karim likes you but offers \$4k a month against your \$9k. Protect your value without losing the deal.",
            "You are Karim Benali, founder of a bootstrapped B2B fintech tool (\$2.5M ARR, profitable). You like this CMO and want to work with them, but you offer \$4,000/month against their \$9,000 proposal. You have about \$7,000 of real budget and could go higher if results are tied to pay or scope is adjusted. You test whether they cave quickly. You respect people who trade rather than discount.",
            "I'll be honest, I really liked your proposal. But nine thousand a month is a lot for us. Could you do four? That's what we budgeted.",
            listOf("Holds value", "Trades, doesn't cave", "Creative structure", "Keeps the relationship warm", "Reaches a clear agreement")),
        Scenario("cac", "CAC tripled", "Diagnosis",
            "Priya, head of growth, says CAC tripled in four months and nobody knows why. Find the root cause.",
            "You are Priya Nair, head of growth at a project-management SaaS (self-serve plus sales, \$40/user/month). CAC tripled over four months. Data you reveal only when asked specifically: in month one the company changed the free trial from 14 days to 7 days; trial-to-paid conversion dropped from 9% to 4%; paid search CPCs rose about 15%; a competitor launched a free tier; signup volume is roughly stable; sales response time to demo requests went from 2 hours to 2 days after a sales rep left. You are smart, a bit stressed, and appreciate structured thinking.",
            "Thanks for jumping on. So — CAC is basically three times what it was four months ago. Everyone has a theory, nobody has an answer. Where would you even start?",
            listOf("Structured hypotheses", "Asks for the right data", "Finds the root cause", "Prioritised fix", "Clarity")),
        Scenario("ceo", "The CEO who wants everything", "Influence",
            "Your CEO wants TikTok, a podcast, a rebrand and three events — this quarter, on the same budget.",
            "You are Lucas Moreau, the energetic founder-CEO of a B2B HR platform (\$5M ARR). You've been inspired by competitors and want TikTok, a podcast, a full rebrand and three events this quarter, without increasing the \$60k quarterly budget. You get excited easily and dislike hearing 'no' bluntly, but you respond well to clear trade-offs, data and being given a choice. Your real goal: hit the \$1.5M pipeline target the board set.",
            "Okay, I've been thinking. We need to be everywhere this quarter — TikTok, a podcast, the rebrand we talked about, and I want us at three events. Same budget though. Can we make that work?",
            listOf("Focus", "Influence without confrontation", "Ties back to the goal", "Offers real trade-offs", "Keeps the CEO's trust")),
        Scenario("vendor", "The agency missing targets", "Leadership",
            "Tom, the agency account lead, has missed lead targets two months running and has excuses. Fix it.",
            "You are Tom Becker, account director at the performance agency a client uses (\$25k/month retainer). Lead targets were missed by 35% and 40% in the last two months. Your excuses: the market is soft, the client's landing pages are slow, creative approvals take too long. Some of this is true (pages are slow), some isn't (your team rotated two juniors onto the account). You become cooperative if expectations are clear and fair, and defensive if attacked.",
            "Hey, thanks for setting this up. I know the numbers haven't been where we wanted. Honestly the market's been really soft, and the landing pages aren't helping us.",
            listOf("Clear expectations", "Separates truth from excuse", "Accountability", "Fairness", "Agreed plan with dates")),
    )
    fun get(id: String) = all.first { it.id == id }
}

data class Quest(val id: String, val title: String, val detail: String, val xp: Int)
data class Chapter(val title: String, val quests: List<Quest>)

object Quests {
    val chapters = listOf(
        Chapter("Foundation", listOf(
            Quest("niche", "Write your niche", "One line: industry × stage × problem. Put it in Positioning above.", 50),
            Quest("offer", "Write your offer", "A fixed-fee diagnostic and a monthly retainer, with prices.", 80),
            Quest("profile", "Rebuild your LinkedIn for your niche", "Headline and About written for one buyer, with your offer.", 60),
            Quest("list50", "List 50 target companies", "Companies that fit your niche, with the founder's name.", 80),
        )),
        Chapter("First proof", listOf(
            Quest("posts10", "Publish 10 posts for your niche", "One idea, one claim, one proof each.", 120),
            Quest("research5", "Hold 5 research conversations", "Talk to founders in your niche about their marketing pain. Don't sell.", 120),
            Quest("paid1", "Land your first paid project", "A diagnostic, pilot or project — anything paid, at any price.", 300),
            Quest("case1", "Publish your first case study", "Situation, what you did, the numbers, a quote.", 200),
        )),
        Chapter("Pipeline", listOf(
            Quest("out100", "Send 100 personalised outreach notes", "Observation, hypothesis, proof, small ask.", 200),
            Quest("calls10", "Hold 10 discovery calls", "Recap each one in the prospect's words.", 250),
            Quest("props5", "Send 5 proposals", "Three options each, walked through live.", 250),
            Quest("refs3", "Get 3 referrals", "Ask specifically for the kind of company you want.", 200),
        )),
        Chapter("Retainers", listOf(
            Quest("ret1", "Sign your first monthly retainer", "Signed, invoiced, paid.", 500),
            Quest("plan90", "Deliver a 90-day plan", "Diagnosis at day 30, bets and budget by day 60.", 200),
            Quest("testi3", "Collect 3 testimonials", "Asked at the moment of a win.", 200),
            Quest("mrr10", "Reach \$10k a month in retainers", "Recurring, signed.", 600),
        )),
        Chapter("Top 1%", listOf(
            Quest("ret3", "Hold 3 retainers at once", "Three clients paying monthly at the same time.", 800),
            Quest("raise", "Raise your price for new clients", "And have someone sign at the new price.", 300),
            Quest("stage", "Speak on a podcast or a stage", "In front of your niche.", 300),
            Quest("stack", "Build and document your agent stack", "The workflows that let you deliver like a team.", 300),
            Quest("mrr30", "Reach \$30k a month in retainers", "The top-1% line for a solo fractional.", 1000),
        )),
    )
    val all = chapters.flatMap { it.quests }
}
