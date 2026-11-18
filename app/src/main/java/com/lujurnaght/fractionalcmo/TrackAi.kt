package com.lujurnaght.fractionalcmo

/** Track: Irreplaceable. The edge when execution is nearly free. */
val AI_TRACK = Track("ai", "Irreplaceable", "What AI takes, what it can't, your agent stack, your moat, and judgment as practice.", listOf(

    Lesson("ai1", "What AI takes, and what it can't", 5, """
AI is collapsing the cost of execution: first drafts, research, analysis, ad variations, reporting, translation, design options. Anyone who sells production by the hour is being repriced.

What it doesn't own:
- Accountability: someone has to be responsible for the number and answer to the board.
- Judgment under ambiguity: choosing what to do with incomplete, conflicting data and real stakes.
- Taste: knowing what's good, what's on-brand, what will land with this audience.
- Trust: the CEO's confidence, built over months.
- Organisational influence: getting people to change how they work.
- Access: relationships with buyers, partners and investors.

Your value moves from producing to deciding, directing and being accountable. Say so in how you sell: you're not cheaper because AI does the work — you're more valuable because you deliver a team's output with a CMO's judgment.

Audit your own offer: list everything you do, mark what AI could do well tomorrow, and move your time and your positioning away from it.
""".trim(),
        listOf(
            "Sell decisions and accountability, not output.",
            "Audit your offer for what AI could do tomorrow.",
            "Position AI as leverage, not as a discount.",
        ),
        listOf(
            QA("Six things AI doesn't own in a CMO's job?", "Accountability, judgment under ambiguity, taste, trust, organisational influence, access."),
            QA("Where does a CMO's value move?", "From producing to deciding, directing and being accountable."),
        ),
        example = """
Your old offer line: "Strategy, content, campaigns and reporting."
New line: "I own your pipeline number. I make the calls on positioning, channels and budget, lead your team and agents to execute, and answer for the results to you and your board."
""".trim(),
        exercise = Exercise(
            "List everything in your offer. Mark what AI could do well within a year, and rewrite your offer line around what it can't.",
            listOf("Honest audit", "Clear AI-proof elements", "Sharper offer line", "Still sellable"),
        ),
        sources = listOf("Ajay Agrawal, Joshua Gans & Avi Goldfarb — Prediction Machines"),
    ),

    Lesson("ai2", "Run an agent stack", 6, """
Build reusable workflows so you can deliver like a team. The stack is your leverage and part of your moat.

Core workflows for a fractional CMO:
- Research: company, market and competitor briefs; ICP account research with triggers.
- Customer insight: summarising interview and call transcripts into pains, quotes and objections.
- Content operations: drafts from your outlines and voice, repurposing one asset into many.
- Reporting: pulling numbers, drafting weekly commentary for your review.
- Outreach: personalised first lines from research, for you to edit.
- QA: checking pages and ads against the messaging hierarchy.

Principles:
- You own the inputs: strategy, voice, data, and the brief. Garbage in, polished garbage out.
- Review everything against the brief, like an agency's work. Verify every fact.
- Document each workflow — prompt, inputs, review checklist — so it's repeatable and teachable to the client's team.
- Respect confidentiality: know what client data can go into which tools, and get agreement.

Measure the gain: hours saved and quality maintained. That's what lets you serve three clients at a high standard.
""".trim(),
        listOf(
            "Build and document one workflow a week.",
            "Own inputs, review outputs, verify facts.",
            "Agree with each client what data can go into which tools.",
        ),
        listOf(
            QA("Your role in an agent stack?", "Own the inputs (strategy, voice, data, brief) and review the outputs."),
            QA("Why document workflows?", "Repeatable, teachable to the client, and part of your moat."),
            QA("Confidentiality rule?", "Agree with each client what data can go into which tools."),
        ),
        example = """
Workflow: "Call → insights". Input: sales call transcript + the messaging hierarchy. Output: pains (with exact quotes), objections, competitors mentioned, messaging gaps. Review checklist: quotes verbatim? anything misattributed? Weekly: 15 calls processed in 20 minutes instead of 5 hours — and the quotes feed the homepage and ads.
""".trim(),
        exercise = Exercise(
            "Design one agent workflow you'd use with clients in your niche: inputs, steps, output, review checklist, and the time it saves.",
            listOf("Valuable use case", "Clear inputs and outputs", "Real review step", "Realistic time saving"),
        ),
        sources = listOf("Ethan Mollick — Co-Intelligence"),
    ),

    Lesson("ai4", "AI in the client's marketing", 5, """
Clients will ask you what to do about AI. A top CMO has a clear, practical answer — neither hype nor dismissal.

Where it creates value now:
- Research and insight at speed (markets, competitors, customer conversations).
- Content operations: more variants, faster, with human editing for quality and voice.
- Personalisation at scale in outbound, email and landing pages.
- Analysis and reporting: faster answers from data, drafted commentary.
- Customer-facing assistants for support and qualification, where accuracy can be controlled.

Where it creates risk:
- Generic content that sounds like everyone else and erodes the brand.
- Errors and invented facts published under the company's name.
- Data and privacy problems from careless use of customer data.
- Over-automation that removes the human touch buyers value.

Your approach: pick two or three use cases tied to the plan's bets, set quality standards and review rules, train the team, and measure output and outcomes. Plus the strategic layer — how buyers in this market use AI to research and choose, and what that means for positioning and channels (see "Search after AI").
""".trim(),
        listOf(
            "Pick two or three AI use cases tied to the plan.",
            "Set quality and review rules before scaling.",
            "Address how buyers use AI to choose, not just how the team uses it.",
        ),
        listOf(
            QA("Where AI creates marketing value now?", "Research, content ops, personalisation, analysis, controlled assistants."),
            QA("Four AI risks in marketing?", "Generic content, published errors, data/privacy issues, over-automation."),
        ),
        example = """
ShiftWell AI plan: (1) call-transcript insights feeding messaging; (2) comparison and use-case page drafts, edited by Sara and checked against facts; (3) personalised first lines for partner-sourced accounts. Rules: no customer data in public tools; every published fact verified; the brand voice guide attached to every prompt.
""".trim(),
        exercise = Exercise(
            "Write a one-page AI plan for a client in your niche: three use cases tied to their goals, the rules, and how you'll measure value.",
            listOf("Use cases tied to goals", "Real governance rules", "Measurable", "Balanced, not hype"),
        ),
        sources = listOf("Ethan Mollick — Co-Intelligence", "Ajay Agrawal, Joshua Gans & Avi Goldfarb — Power and Prediction"),
    ),

    Lesson("ai5", "Building your moat", 5, """
When execution is cheap, your moat is what others can't easily copy.

Five sources of a durable edge:
1. A named method: your diagnostic and 90-day approach, with a name and a simple visual. Methods are teachable, sellable and memorable.
2. Proprietary data: benchmarks from every engagement in your niche (conversion rates, CAC by channel, cycle lengths), anonymised. After ten clients, you know what "normal" looks like better than anyone.
3. Proof: case studies in one niche that make you the obvious choice.
4. Relationships: founders, investors, partners and other fractionals who know and refer you.
5. Reputation: a body of public thinking — posts, talks, a newsletter — tied to your niche.

All five compound. Each engagement should add to them: a refined method, new benchmarks, a case study, new relationships, new content.

Review your moat every quarter: what did each client add? If the answer is "only revenue", you're renting your time instead of building a business.
""".trim(),
        listOf(
            "Name your method and draw it simply.",
            "Collect anonymised benchmarks from every engagement.",
            "Review what each client added to your moat every quarter.",
        ),
        listOf(
            QA("Five sources of a fractional's moat?", "Named method, proprietary data, proof, relationships, reputation."),
            QA("Why benchmarks matter?", "After many clients you know what 'normal' looks like better than anyone."),
        ),
        example = """
Method: "The Pipeline Reset — Diagnose (3 weeks) · Focus (30 days) · Install (60 days)".
Benchmarks after 8 SaaS clients: median demo → opportunity 31%; partner-sourced deals close 1.7× faster; speed-to-lead under 1 hour lifts demo → opp by a median 9 points.
That benchmark sheet becomes posts, a talk, and a slide in every proposal.
""".trim(),
        exercise = Exercise(
            "Name your method with its phases, list five benchmarks you'll collect from every client, and describe how each engagement will add to your moat.",
            listOf("Memorable, coherent method", "Useful benchmarks", "Compounding plan", "Niche-specific"),
        ),
        sources = listOf("David C. Baker — The Business of Expertise", "Blair Enns — The Win Without Pitching Manifesto"),
    ),

    Lesson("ai3", "Taste and judgment as practice", 5, """
Taste and judgment are skills, and skills are trained.

Taste is trained by exposure and critique: study great campaigns, positioning and pages in and beyond your niche; write short teardowns (what works, what doesn't, what you'd change); keep a swipe file of the best examples.

Judgment is trained by prediction and feedback. Annie Duke's idea: treat decisions as bets. Before a decision, write what you expect and how confident you are. Later, score it. Over time you learn where your intuition is reliable and where it isn't — and you separate the quality of a decision from the luck of its outcome.

Deliberate practice beats experience alone: specific exercises, immediate feedback, and pushing at the edge of your ability. That's what the sparring, daily cases and graded exercises in this app are for. Treat each one like a real client hour: decide, commit, then read the elite answer and note what you missed.

Keep a judgment journal: the decision, your reasoning, your prediction and confidence, the outcome, the lesson. Review it monthly. It's the most honest coach you'll ever have.
""".trim(),
        listOf(
            "One teardown a week.",
            "Keep a judgment journal with predictions and confidence.",
            "Treat each spar and case like a real client hour.",
        ),
        listOf(
            QA("How is taste trained?", "Exposure and critique: teardowns and a swipe file."),
            QA("How is judgment trained?", "Predictions with confidence, scored later (decisions as bets)."),
            QA("What separates decision quality from outcome?", "Luck — judge the decision by the information and reasoning at the time."),
        ),
        example = """
Journal entry: "12 Feb — Predict: moving 40% of search budget to partners raises pipeline within 60 days. Confidence 70%. Reasoning: partner-sourced deals close 1.7× faster in my benchmarks."
Review 12 April: pipeline +14%, partner share 33%. Correct direction, slower than expected — partner onboarding took longer. Lesson: add 3–4 weeks for partner ramp in future forecasts.
""".trim(),
        exercise = Exercise(
            "Write a teardown of one company's homepage in your niche (what works, what doesn't, what you'd change) and one judgment-journal prediction about it.",
            listOf("Sharp observations", "Actionable changes", "Clear prediction with confidence", "Taste evident"),
        ),
        sources = listOf("Annie Duke — Thinking in Bets", "Anders Ericsson & Robert Pool — Peak"),
    ),
))
