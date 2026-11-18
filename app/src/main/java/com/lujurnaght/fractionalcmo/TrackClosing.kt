package com.lujurnaght.fractionalcmo

/** Track: Selling & closing. From first call to signed retainer. */
val CLOSING = Track("closing", "Selling & closing", "Qualify, diagnose, propose, negotiate, sign.", listOf(

    Lesson("clo4", "Qualify fast, disqualify faster", 5, """
Your scarcest resource is selling time. The best closers spend it only on deals that can close, and they say no early and kindly to the rest.

Mahan Khalsa's principle: "no" is a fine answer — "maybe" is the expensive one. A quick no frees you; a long maybe eats weeks.

Qualify on four things, in your first conversation:
- Pain: is there a real, felt problem — not just curiosity? Ask what happens if nothing changes.
- Fit: are they inside your niche and at a stage where a fractional makes sense? Pre-product-market-fit companies usually need a founder doing sales, not a CMO.
- Power: who decides, who influences, who signs? At this stage it's usually the CEO; with PE-backed companies, the operating partner matters.
- Means: can they pay? Ask directly: "Have you set aside budget for this, or would this be new money?" Founders respect the question.

Red flags: they want strategy and execution for the price of a junior; they've churned through several marketers in a year; they won't give you access to data or customers; the founder "wants marketing" but can't say what success looks like.

Disqualifying isn't rude. "Honestly, I don't think I'm the right fit yet — at your stage I'd spend the money on a strong SDR first" builds enormous trust, and those founders come back later — or refer you.
""".trim(),
        listOf(
            "Qualify every lead on pain, fit, power and means in call one.",
            "Ask about budget directly and early.",
            "Disqualify generously — with advice — when it's not a fit.",
        ),
        listOf(
            QA("Khalsa's principle on answers?", "'No' is a fine answer; 'maybe' is the expensive one."),
            QA("Four things to qualify?", "Pain, fit, power, means."),
            QA("Three red flags in a prospect?", "Strategy + execution for a junior's price, churn of several marketers, no access to data or customers."),
        ),
        example = """
Founder: "We're pre-revenue but we raised a seed. I want a CMO to build the brand."
Strong response: "Thanks for being open. At pre-revenue, I'd be selling you a plan with no data to test it against, and you'd be paying CMO rates for experiments a founder should run. My honest advice: get your first ten customers yourself, then call me — that's when a pipeline machine pays for itself."
""".trim(),
        exercise = Exercise(
            "Write the four questions you'd ask to qualify a lead in your niche (one per area), and one sentence you'd use to disqualify a poor fit gracefully.",
            listOf("Questions are sharp and natural", "Covers pain, fit, power, means", "Budget asked directly", "Disqualification builds trust"),
        ),
        sources = listOf("Mahan Khalsa — Let's Get Real or Let's Not Play", "David Sandler — the Sandler selling system (pain, budget, decision)"),
    ),

    Lesson("clo5", "Run the first call like a pro", 5, """
The first two minutes decide who leads the call. If you don't set the frame, the founder will — usually as "so, tell me about yourself", which turns you into a vendor pitching.

Open with an upfront contract (from the Sandler system): agree time, purpose, agenda, and the possible outcomes.

"We've got 30 minutes — still good? I'd like to understand what's going on with growth, share how I'd think about it, and at the end we can decide together whether a next step makes sense. If it doesn't, it's completely fine to say so. Sound fair?"

That last line matters: giving them permission to say no lowers their guard and makes a real yes more likely.

Then ask, don't pitch. Your credibility comes from the quality of your questions, not from your slides. A good split: they talk 70%, you talk 30%.

Take notes in their exact words — you'll reuse them in the recap and proposal.

Close the call with a clear next step and a date, even if the step is small: "I'll send a recap today; let's book 45 minutes on Thursday with your head of sales to look at the funnel."

Avoid: presenting a deck, listing services, giving away your full diagnosis on the call (show you can see the problem; save the plan for the paid work).
""".trim(),
        listOf(
            "Open every call with an upfront contract: time, purpose, agenda, outcomes.",
            "Talk 30%, listen 70%, write down their exact words.",
            "End with a dated next step.",
        ),
        listOf(
            QA("Parts of an upfront contract?", "Time, purpose, agenda, and the possible outcomes (including no)."),
            QA("Why give permission to say no?", "It lowers their guard and makes a real yes more likely."),
            QA("What not to give away on a first call?", "The full diagnosis and plan — show you see the problem, save the solution for paid work."),
        ),
        example = """
Maya (CEO, ShiftWell): "So — what do you do exactly?"
Weak: "I'm a fractional CMO with fifteen years of experience in..."
Strong: "Happy to cover that — but you'll get more out of this if I understand your situation first. You mentioned growth's been flat. When did you first notice it, and what did the board plan for this year?"
""".trim(),
        exercise = Exercise(
            "Write your exact opening (upfront contract) for a first call with a founder in your niche, plus your first three questions.",
            listOf("Upfront contract complete and natural", "Permission to say no", "Questions lead to real pain", "You stay in control without pushing"),
        ),
        template = "discovery",
        sources = listOf("David Sandler — the Sandler selling system (upfront contract)", "Chris Voss — Never Split the Difference"),
    ),

    Lesson("clo1", "Discovery that finds the money", 7, """
Discovery is diagnosis. The goal is to understand the problem better than the founder does — and to put a number on it.

Work through layers, like Rackham's SPIN: Situation (facts), Problem (what's not working), Implication (what it causes), Need-payoff (what fixing it is worth).

Situation questions are cheap; ask few. Use your research instead. Problem questions find the pain: "Where does pipeline come from today? What happens when you stop selling personally?" Implication questions make it big: "What does three flat quarters mean for the raise next year?" Need-payoff questions let them say the value out loud: "If marketing produced half the pipeline, what would that change for you?"

The most useful question in fractional sales: "What happens if this isn't fixed in six months?" It turns a marketing complaint into a business cost, and the business cost sets your price.

Chris Voss's tools help when founders are guarded:
- Labels: "It sounds like you've been burned by consultants before."
- Calibrated questions: "How would you know this worked?" "What's making this urgent now?"
- Mirrors: repeat their last few words as a question to get them to expand.

Also map the decision: "Besides you, who'll weigh in? What would they need to see?" And the timeline: "When would you want someone starting?"

Write the recap the same day in their words. A recap that says exactly what they told you is already half a proposal.
""".trim(),
        listOf(
            "Spend your questions on problem, implication and need-payoff.",
            "Put the pain in money before talking price.",
            "Map who decides and by when, then recap in their words.",
        ),
        listOf(
            QA("SPIN stands for?", "Situation, Problem, Implication, Need-payoff."),
            QA("The key fractional discovery question?", "\"What happens if this isn't fixed in six months?\""),
            QA("Voss's three tools for guarded founders?", "Labels, calibrated how/what questions, mirrors."),
            QA("What must the recap use?", "Their exact words."),
        ),
        example = """
Maya: "Leads are bad, honestly."
You (mirror): "Leads are bad?"
Maya: "Sales says half the demo requests are clinics too small to afford us."
You (implication): "So your three salespeople spend half their week on deals that can't close?"
Maya: "...Yes. Probably."
You (need-payoff): "If that half went to real prospects, what would that do to this quarter?"
Maya: "We'd hit plan."
— You've just found a measurable, fixable problem worth a lot of money, in her words.
""".trim(),
        exercise = Exercise(
            "For a founder in your niche, write one question for each SPIN layer, plus one label and one calibrated question you'd use if they're guarded.",
            listOf("Questions dig toward money", "Natural, conversational wording", "Good use of labels/calibrated questions", "Implication questions enlarge the pain"),
        ),
        template = "discovery",
        sources = listOf("Neil Rackham — SPIN Selling", "Chris Voss — Never Split the Difference", "Mahan Khalsa — Let's Get Real or Let's Not Play"),
    ),

    Lesson("clo6", "Diagnose live, without giving it away", 5, """
Founders buy from the person who sees their problem most clearly. On the call, you need to show that clarity — without handing over the full solution for free.

The technique: reflect a sharp diagnosis, reveal the shape of the answer, and hold back the plan.

Use the Challenger Sale idea of a commercial insight: a reframe that changes how the founder sees their own problem. "You don't have a lead problem; you have a routing problem — half your demos go to clinics that can't afford you." Reframes like this are what make founders lean in.

Back it with a number from their own data or a benchmark from your experience. "In the funnels I've audited at your stage, the biggest leak is almost never the top."

Then show the shape of the answer, not the steps: "There are three things I'd look at first: who's actually buying, where your best customers came from, and what happens in the first 48 hours after a demo request." That proves competence and creates the itch for the diagnostic.

Blair Enns calls the mistake "free consulting": giving the full prescription before being paid devalues it, and the founder often tries to execute it badly alone.

If they push for answers: "I could guess, but you'd be paying for my guess. The diagnostic is three weeks precisely so we're not guessing."
""".trim(),
        listOf(
            "Offer one reframe of their problem on every call.",
            "Show the shape of the answer, never the full plan.",
            "Turn 'tell me what to do' into the case for the diagnostic.",
        ),
        listOf(
            QA("What's a commercial insight?", "A reframe that changes how the buyer sees their own problem."),
            QA("Enns's name for giving the prescription away?", "Free consulting."),
            QA("How to answer 'just tell me what to do'?", "I could guess, but you'd pay for a guess — the diagnostic replaces guessing."),
        ),
        example = """
Daniel (COO, Northline): "So what would you do about our ads?"
You: "Honestly, I don't think ads are the problem. ROAS fell from 3.1 to 2.2 while your repeat-purchase rate stayed flat — that usually means you're paying to re-acquire your own customers. I'd look at three things: how much paid spend hits existing customers, what your email and SMS do for retention, and which products bring first buyers back. The diagnostic would tell us exactly how much of that $12k agency spend is buying customers you already had."
""".trim(),
        exercise = Exercise(
            "Take a common problem in your niche. Write the reframe you'd offer on a call, the number or benchmark backing it, and the three areas you'd examine — without the plan.",
            listOf("Reframe genuinely changes perspective", "Backed by a number", "Shape of answer without giving it away", "Creates desire for the diagnostic"),
        ),
        sources = listOf("Matthew Dixon & Brent Adamson — The Challenger Sale", "Blair Enns — The Win Without Pitching Manifesto"),
    ),

    Lesson("clo7", "Selling the diagnostic", 4, """
The diagnostic is easier to sell than a retainer because it's a small, safe decision. Your job on the call is to make it the obvious next step.

Position it as risk reduction for them, not a sales tactic for you: "Before either of us commits to months of work, let's make sure we're solving the right problem."

Make it concrete: duration, what you'll do (interviews, data, audit), what they'll get (diagnosis, 90-day plan, board narrative), what you need from them, and the price.

Tie it to their deadline. Maya has a board meeting in seven weeks: "Three weeks of diagnostic means you walk into that board meeting with a diagnosis and a plan instead of a question mark."

Ask for the decision directly: "Would you like to start on the 2nd?" — then stop talking.

If they want the retainer straight away, still recommend the diagnostic as phase one inside it. Skipping diagnosis is how engagements fail in month three.

Credit the fee: many fractionals credit part of the diagnostic fee against the first retainer month if they continue. It removes the "paying twice" objection without discounting.
""".trim(),
        listOf(
            "Frame the diagnostic as risk reduction for them.",
            "Tie it to a real deadline they have.",
            "Ask for a start date, then stay silent.",
        ),
        listOf(
            QA("How to frame the diagnostic?", "As risk reduction: make sure we solve the right problem before committing."),
            QA("Handling 'let's skip to the retainer'?", "Make the diagnostic phase one of the retainer."),
            QA("Removing the 'paying twice' objection?", "Credit part of the diagnostic fee against the first retainer month."),
        ),
        example = """
"Here's what I'd suggest. A three-week Pipeline Diagnostic: I interview you, your sales team and six customers, audit the funnel and spend, and give you a diagnosis, a 90-day plan, and the slide for your board meeting on the 14th. It's $6,000, and if you continue with me afterwards, half of it comes off the first month. Would starting Monday the 2nd work?"
""".trim(),
        exercise = Exercise(
            "Write the exact words you'd use to propose your diagnostic to a founder, including a deadline tie-in and the closing question.",
            listOf("Framed as their risk reduction", "Concrete deliverables and price", "Real deadline tie-in", "Clear, confident close"),
        ),
        sources = listOf("Blair Enns — The Win Without Pitching Manifesto (diagnose before prescribing)", "Alan Weiss — Million Dollar Consulting"),
    ),

    Lesson("clo2", "Proposals that close", 6, """
A proposal shouldn't persuade. If the call went well, it should confirm what you already agreed — in their words — and let them choose an option.

Alan Weiss's structure, adapted:
1. Situation: their problem, in their words from discovery.
2. Objectives: what success looks like.
3. Measures: how you'll both know — numbers.
4. Value: what achieving it is worth to them (they said it on the call).
5. Approach and options: three ways to work together.
6. What you need from them: access, a sponsor, budget for tools or ads.
7. Timing and terms: start date, payment, notice.

Keep it short: two to four pages. Long proposals are read as padding.

Three options do three jobs: the top one anchors the middle; the bottom one catches price-sensitive buyers; and the choice moves the question from "whether" to "which". Make the middle the obvious best value.

Send within 24–48 hours while momentum is high — and never just email it. Book a 20-minute call to walk through it. Unexplained proposals die in inboxes; walked-through proposals get decided.

On that call, ask: "Which option feels closest to what you need?" — then adjust, don't defend.
""".trim(),
        listOf(
            "Write the proposal from their words: situation, objectives, measures, value.",
            "Always three options, with the middle as the clear best value.",
            "Walk through every proposal live within 48 hours.",
        ),
        listOf(
            QA("Weiss's proposal structure?", "Situation, objectives, measures, value, options, what you need, timing and terms."),
            QA("Three jobs of three options?", "Anchor the middle, catch price-sensitive buyers, turn 'whether' into 'which'."),
            QA("How to deliver a proposal?", "Within 48 hours, walked through live on a call."),
        ),
        example = """
Situation (Maya's words): "Growth has been flat for three quarters, sales says half the leads are clinics too small to afford us, and the board wants answers in seven weeks."
Objective: marketing-sourced pipeline that fits the ICP.
Measures: qualified demos per month from 12 to 30; pipeline from marketing ≥ 50% by Q3.
Value (her words): "If that half went to real prospects, we'd hit plan."
Options: Diagnostic $6k · Diagnostic + 6-month Growth Lead $9k/mo · Growth Lead + sales alignment $13k/mo.
""".trim(),
        exercise = Exercise(
            "Write a proposal outline for a prospect in your niche: situation (their words), objective, two measures, value, three options with prices, and what you need from them.",
            listOf("Uses the client's language", "Measurable objectives", "Three well-designed options", "Inputs from client stated"),
        ),
        template = "proposal",
        sources = listOf("Alan Weiss — Million Dollar Consulting Proposals", "Blair Enns — Pricing Creativity"),
    ),

    Lesson("clo9", "The price conversation", 5, """
How you say the price matters as much as the number.

Say it plainly, once, and stop. "The retainer is nine thousand a month." No apologies, no justifications, no "but we can adjust". Silence after the number is normal; let them fill it.

Anchor before you price. Remind them of the value and the alternative first: "You said hitting plan this year is worth about a million in revenue, and a full-time CMO would take six months to hire. The retainer is nine thousand a month."

Use options to control the frame. With three prices on the table, the conversation is about which, not whether.

Expect the reaction and don't flinch. "That's more than we expected" is information, not a no. Ask: "Expected compared to what?" Often it's compared with a freelancer or an agency — and you can reframe.

Blair Enns's rule: never let price discussions become a negotiation of your value. If budget is genuinely limited, change the scope, not the price per scope. "We can do it for less — here's what we'd take out."

Practise saying your numbers out loud until they sound boring to you. Hesitation is heard as doubt.
""".trim(),
        listOf(
            "Restate value and the alternative before saying the price.",
            "Say the number once, then stay silent.",
            "Change scope, never the price for the same scope.",
        ),
        listOf(
            QA("What to do right after saying the price?", "Stop talking and let them respond."),
            QA("Answer to 'more than we expected'?", "\"Expected compared to what?\""),
            QA("Enns's rule when budget is limited?", "Reduce scope, never the price for the same scope."),
        ),
        example = """
Karim: "Nine thousand is a lot."
You: "It's a real number. Compared to what you were expecting?"
Karim: "We were thinking more like a freelancer."
You: "That makes sense — a freelancer would execute campaigns. What you described is deciding which channel the next million comes from and making your new hire effective. If that's not what you need, a freelancer is the right call and I'll happily recommend one."
""".trim(),
        exercise = Exercise(
            "Write how you'd say your retainer price to a founder (with value and alternative anchored first), and your answer to \"that's more than we expected\".",
            listOf("Value and alternative anchored first", "Price said plainly", "Calm, curious handling of the reaction", "No discounting"),
        ),
        sources = listOf("Blair Enns — Pricing Creativity", "Jonathan Stark — Hourly Billing Is Nuts"),
    ),

    Lesson("clo3", "Objections are questions", 6, """
An objection is a question in disguise, usually about risk. Answer the question underneath, not the words on top.

Prepare for the five you'll hear most:
- "Too expensive." Underneath: is it worth it? Compare with the full-time hire and the cost of the problem; offer the diagnostic as a smaller first step.
- "Why not an agency?" Underneath: what's the difference? Agencies execute; you decide what's worth executing, and you hold agencies accountable. Many clients have both.
- "We'll think about it." Underneath: something's unresolved. Ask: "Of course. What would you need to see to feel confident either way?"
- "Bad timing." Underneath: not a priority, or a real constraint. Ask what changes when timing is right, and tie back to their deadline.
- "We tried a consultant; it didn't work." Underneath: will you just deliver a deck? Explain how you work differently: you lead people and own numbers, not slides.

Chris Voss's accusation audit defuses objections before they're raised: "You might be thinking this sounds like another consultant who'll leave you with a deck." Naming it first takes its power away.

Then close clearly. Ask for the decision and a start date out loud. Give a real reason for timing — a board meeting, a launch, your capacity — never fake urgency.
""".trim(),
        listOf(
            "Answer the risk underneath the objection.",
            "Use an accusation audit to name objections before they do.",
            "Always ask for the decision and a start date out loud.",
        ),
        listOf(
            QA("What's underneath most objections?", "A question about risk."),
            QA("Voss's accusation audit?", "Naming the other side's likely negative thoughts before they raise them."),
            QA("Reframe for 'why not an agency?'", "Agencies execute; you decide what's worth executing and hold them accountable."),
            QA("Response to 'we'll think about it'?", "\"What would you need to see to feel confident either way?\""),
        ),
        example = """
Maya: "We tried a consultant last year — we got a deck and nothing changed."
You: "That's exactly the right worry. Here's the difference: the diagnostic ends with a plan, but if you continue, I'm the one running it — leading your marketer and agency, in your weekly meeting, accountable for the pipeline number. If at the end of three weeks the plan isn't something you'd act on, you don't pay the second half."
""".trim(),
        exercise = Exercise(
            "Write your answers to two objections you expect most in your niche, and an accusation audit you'd open a proposal call with.",
            listOf("Answers the underlying risk", "Specific, not generic", "Accusation audit is honest and disarming", "Moves toward a decision"),
        ),
        sources = listOf("Chris Voss — Never Split the Difference", "Mahan Khalsa — Let's Get Real or Let's Not Play"),
    ),

    Lesson("clo10", "Negotiate by trading", 5, """
When a founder asks for a lower price, the worst response is a discount for the same scope. It teaches them your price was padded and sets the tone for the whole engagement.

Trade instead. Every concession gets something in return or a change in scope:
- Lower price → fewer days, narrower scope, or a longer commitment.
- Monthly → quarterly prepayment in exchange for a modest reduction.
- Lower fee → a case study, testimonial and referrals (early in your career).
- Lower base → a performance component tied to agreed pipeline or revenue.

Use calibrated questions to find the real constraint: "What budget were you working with?" "How did you arrive at that number?" Often the budget is flexible when the scope is right.

Voss's other tools: say "no" without saying no ("How am I supposed to do that and still deliver what you need?"), and let silence work.

Know your walk-away point before the conversation. Clients signed far below your price tend to be the hardest, least respectful, and first to churn.

End every negotiation by restating the agreement clearly — price, scope, dates — and sending it in writing the same day.
""".trim(),
        listOf(
            "Never give a discount for the same scope — trade something.",
            "Find the real constraint with calibrated questions.",
            "Decide your walk-away point before the call.",
        ),
        listOf(
            QA("The core negotiation rule for fractionals?", "Trade concessions; never discount the same scope."),
            QA("Four things to trade for a lower price?", "Narrower scope, longer commitment, prepayment, case study/referrals or performance pay."),
            QA("Voss's way to say no without 'no'?", "\"How am I supposed to do that?\""),
        ),
        example = """
Karim: "Could you do four thousand?"
You: "How did you land on four?"
Karim: "That's what we budgeted, honestly. Maybe seven at a stretch."
You: "Seven I can work with if we narrow it: one day a week, I own strategy and lead your new hire, and you prepay the quarter. Or nine with the full scope we discussed. Which fits better?"
""".trim(),
        exercise = Exercise(
            "A founder offers half your retainer price. Write your response: a calibrated question, then two trade options with clear scope changes.",
            listOf("Doesn't cave", "Finds the real constraint", "Trades are coherent", "Relationship stays warm"),
        ),
        sources = listOf("Chris Voss — Never Split the Difference", "Blair Enns — Pricing Creativity"),
    ),

    Lesson("clo11", "Stalled deals", 5, """
Most lost fractional deals aren't lost to a competitor. They're lost to indecision — the founder stays with the status quo.

Matthew Dixon and Ted McKenna's research behind The JOLT Effect found that indecision, not preference for a competitor, kills a large share of deals — driven by fear of making the wrong choice. Their JOLT method:
- Judge the indecision: is it a value problem (not convinced) or a fear problem (convinced but scared)?
- Offer your recommendation: don't add more options; tell them what you'd do.
- Limit the exploration: stop sending more information; it increases doubt.
- Take risk off the table: a smaller first step, a clear exit, a guarantee.

Signs of a stall: meetings get pushed, replies get shorter, "let me loop in…" without dates.

Revive with a "no-oriented" question (Voss): "Have you given up on fixing pipeline this quarter?" It's easy to answer and usually gets a real reply.

Or offer a graceful close: "It sounds like this isn't a priority right now, which is completely fine — should I close the file for now?" People reply to avoid losing options.

Never chase with "just checking in". Every follow-up should carry something new: a relevant insight, a change in their market, a smaller first step.
""".trim(),
        listOf(
            "Diagnose stalls as value or fear, then act accordingly.",
            "Give a recommendation, not more options or information.",
            "Revive with a no-oriented question or a graceful close.",
        ),
        listOf(
            QA("What kills most stalled deals?", "Indecision — fear of choosing wrong — not competitors."),
            QA("JOLT stands for?", "Judge the indecision, Offer a recommendation, Limit exploration, Take risk off the table."),
            QA("A no-oriented revival question?", "\"Have you given up on fixing pipeline this quarter?\""),
        ),
        example = """
Two weeks after the proposal, Maya has gone quiet.
"Hi Maya — have you given up on fixing the lead quality before the board meeting? If so, no problem at all. If not, I'd suggest we start with just the first week — the customer interviews — and you decide on the rest after you've seen what they say."
""".trim(),
        exercise = Exercise(
            "A founder has gone quiet for two weeks after your proposal. Write your message using JOLT and a no-oriented question.",
            listOf("Diagnoses value vs fear", "Clear recommendation", "Risk removed", "Easy to answer"),
        ),
        sources = listOf("Matthew Dixon & Ted McKenna — The JOLT Effect", "Chris Voss — Never Split the Difference"),
    ),

    Lesson("clo12", "From yes to kickoff", 4, """
A yes isn't a client until it's signed, paid and started. The gap between them is where deals die and first impressions are made.

Within 24 hours of the yes, send: the agreement (scope, price, term, notice, confidentiality), the first invoice, and a kickoff plan with dates.

Keep the contract simple: scope and responsibilities, fees and payment terms (monthly in advance is standard for retainers), term and notice period (often 30 days after an initial period), confidentiality, IP, and what happens at the end.

Collect what you need before day one: access to analytics, CRM, ad accounts, past reports, a list of people to interview, and a named internal sponsor.

The kickoff meeting sets the tone. Agree the goals and measures, the weekly cadence, how decisions get made, and what the first two weeks look like. Then deliver something tangible in the first week — an early observation, a quick fix, a killed waste — to prove the decision was right.

Record the baseline numbers now. Everything you'll claim later depends on them.

Finally, send a short "what to expect" note to the team you'll lead. A fractional who arrives without the team knowing why creates resistance from day one.
""".trim(),
        listOf(
            "Agreement, invoice and kickoff plan within 24 hours of the yes.",
            "Collect access and record the baseline before day one.",
            "Deliver something tangible in week one.",
        ),
        listOf(
            QA("What to send within 24 hours of a yes?", "Agreement, first invoice, kickoff plan with dates."),
            QA("Standard retainer payment terms?", "Monthly in advance, with a notice period."),
            QA("Why record the baseline at kickoff?", "Every result you claim later depends on it."),
        ),
        example = """
Kickoff agenda (60 min): goals and measures (10) · baseline numbers (10) · the team and who decides what (10) · interview list and access (10) · weekly rhythm (5) · first two weeks (10) · questions (5).
Week-one win: you find that 31% of demo requests are below the price threshold and propose a qualifying field on the form — live by Friday.
""".trim(),
        exercise = Exercise(
            "Write your kickoff checklist for a new client in your niche: documents, access needed, baseline numbers to record, and your planned week-one win.",
            listOf("Complete and practical", "Right baseline metrics", "Credible week-one win", "Clear cadence and ownership"),
        ),
        sources = listOf("Alan Weiss — Million Dollar Consulting"),
    ),
))
