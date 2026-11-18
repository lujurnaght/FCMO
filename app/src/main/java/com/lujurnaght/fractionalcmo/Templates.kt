package com.lujurnaght.fractionalcmo

/** A working document you fill in for real clients — the toolkit. */
data class Slot(val title: String, val hint: String, val lines: Int = 3)
data class Template(val id: String, val title: String, val why: String, val fields: List<Slot>)

object Toolkit {
    val all = listOf(
        Template("offer", "Offer one-pager", "The page you send when someone asks 'what do you do?'. Forwardable to a co-founder.", listOf(
            Slot("Who it's for", "Industry × stage × problem, in their words.", 2),
            Slot("The problem", "What they feel, and what it's costing them.", 3),
            Slot("The outcome", "What's different after working with you, in numbers where possible.", 3),
            Slot("Front door: the diagnostic", "Name, duration, what you do, what they get, price.", 5),
            Slot("The retainer", "Responsibilities, cadence, measures, price.", 4),
            Slot("Proof", "A result with numbers, a client quote, or a relevant past role.", 3),
            Slot("Risk reversal", "What makes saying yes safe.", 2),
            Slot("How to start", "One simple next step.", 2),
        )),
        Template("outreach", "Outreach sequence", "Four touches over 14 days for one Tier 1 founder, plus your referral ask.", listOf(
            Slot("Research note", "Company, stage signals, decision-maker, trigger, your observation.", 4),
            Slot("Touch 1 · day 0", "Observation → hypothesis → proof → small ask.", 5),
            Slot("Touch 2 · day 3", "Add value: a teardown point, a number, a resource.", 4),
            Slot("Touch 3 · day 7", "A new angle or a short question.", 3),
            Slot("Touch 4 · day 14", "The graceful close.", 3),
            Slot("Referral ask", "The exact words you'd use with a happy client or partner.", 3),
        )),
        Template("discovery", "Discovery call guide", "Your script and notes for a first call. Fill the left half before, the right half during.", listOf(
            Slot("Research before the call", "What you know; your hypothesis about their problem.", 3),
            Slot("Upfront contract", "Time, purpose, agenda, outcomes — including permission to say no.", 3),
            Slot("Problem questions", "Where pipeline comes from; what isn't working.", 4),
            Slot("Implication & cost", "What it's causing; what happens if it's not fixed in 6 months; the number.", 4),
            Slot("Decision & budget", "Who decides, who influences, timing, budget.", 3),
            Slot("Their exact words", "Phrases you'll reuse in the recap and proposal.", 4),
            Slot("Next step", "What, who, which date.", 2),
            Slot("Recap email", "Sent the same day, in their words.", 6),
        )),
        Template("proposal", "Proposal with three options", "Confirms what you agreed and lets them choose how — not whether.", listOf(
            Slot("Situation", "Their problem in their own words.", 4),
            Slot("Objectives", "What success looks like.", 3),
            Slot("Measures", "How you'll both know — numbers and dates.", 3),
            Slot("Value", "What achieving it is worth to them, as they said it.", 2),
            Slot("Option 1", "Smallest step — usually the diagnostic. Scope and price.", 3),
            Slot("Option 2 (recommended)", "The best value. Scope, cadence and price.", 4),
            Slot("Option 3", "The premium. Scope and price.", 3),
            Slot("What we need from you", "Access, a sponsor, budgets, people's time.", 3),
            Slot("Timing and terms", "Start date, payment, notice, what happens at the end.", 3),
        )),
        Template("post", "Post that pulls", "One post for your niche, built from a spar, a case or a client insight.", listOf(
            Slot("Hook options", "Five first lines: a number, a tension, a counterintuitive claim, a scene.", 5),
            Slot("The claim", "The one idea, stated plainly.", 2),
            Slot("Proof", "The number or story that makes it believable.", 4),
            Slot("The lesson", "What the reader should do or think differently.", 3),
            Slot("Soft call to action", "A question or a low-key resource offer.", 2),
        )),
        Template("diagnosis", "One-page diagnosis", "The heart of the diagnostic: what's happening, why, what it costs, what to do.", listOf(
            Slot("Company and situation", "Who they are, stage, the headline numbers.", 3),
            Slot("What's happening", "The problem, with numbers.", 3),
            Slot("Why", "Root causes, with evidence from interviews and data.", 5),
            Slot("What it costs", "In revenue, cash, or time — a number.", 2),
            Slot("Bet 1", "The action, owner, budget, metric.", 3),
            Slot("Bet 2", "The action, owner, budget, metric.", 3),
            Slot("Bet 3", "The action, owner, budget, metric.", 3),
            Slot("What we stop", "Activities that don't serve the bets.", 2),
        )),
        Template("plan90", "90-day plan", "What you'll do, who owns it, and how everyone will know it worked.", listOf(
            Slot("Baseline", "The numbers on day one.", 3),
            Slot("Goal for day 90", "Two or three measurable outcomes.", 2),
            Slot("Days 1–30", "Diagnose: interviews, data, quick wins.", 4),
            Slot("Days 31–60", "Decide and win: positioning, bets, early results.", 4),
            Slot("Days 61–90", "Install the machine: owners, cadence, dashboard.", 4),
            Slot("Owners and cadence", "Who owns each bet; weekly and monthly rhythm.", 3),
            Slot("Risks", "What could derail it, and the mitigation.", 3),
        )),
        Template("positioning", "Positioning canvas", "Dunford's five components plus ICP and anti-ICP, on one page.", listOf(
            Slot("Competitive alternatives", "What customers would do without this product.", 3),
            Slot("Unique attributes", "What it has that alternatives don't.", 3),
            Slot("Value and proof", "What the attributes enable — with evidence.", 4),
            Slot("Best-fit customers (ICP)", "Firmographics, situation, pain.", 3),
            Slot("Anti-ICP", "Who to stop selling to, and why.", 2),
            Slot("Market category and style", "The frame, and head-to-head / big fish / new game.", 2),
            Slot("Positioning statement", "For… who… is a… that… Unlike… we…", 3),
        )),
        Template("strategy", "One-page strategy", "Rumelt's kernel, made concrete. The page a CEO can argue with in two minutes.", listOf(
            Slot("Diagnosis", "The challenge, simplified, with evidence.", 3),
            Slot("Guiding policy", "The approach in one or two sentences.", 2),
            Slot("Bets", "Two or three coherent actions — owner, budget, metric each.", 6),
            Slot("What we stop", "And why.", 3),
            Slot("Measures and checkpoints", "How and when we'll know.", 3),
        )),
        Template("board", "Board marketing update", "One page, in the board's language, with assumptions next to the numbers.", listOf(
            Slot("Headline", "One sentence: where marketing stands against plan.", 2),
            Slot("Pipeline and revenue by source", "Actuals vs plan.", 4),
            Slot("Efficiency", "CAC payback, cost per opportunity, trend.", 3),
            Slot("What worked / what didn't", "And what you changed.", 4),
            Slot("Next quarter's bets and budget", "With the assumptions.", 4),
            Slot("Asks of the board", "Decisions or help you need.", 2),
        )),
    )
    fun get(id: String) = all.first { it.id == id }
}
