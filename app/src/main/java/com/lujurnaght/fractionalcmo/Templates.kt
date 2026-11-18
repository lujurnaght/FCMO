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
    )
    fun get(id: String) = all.first { it.id == id }
}
