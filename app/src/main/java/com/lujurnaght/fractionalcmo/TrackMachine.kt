package com.lujurnaght.fractionalcmo

/** Track: Leading the machine. Team, agencies, agents, measurement, cadence, alignment. */
val MACHINE = Track("machine", "Leading the machine", "Team, hiring, agencies, measurement, dashboards, cadence, sales alignment.", listOf(

    Lesson("mac1", "Team, agencies and agents", 5, """
As a fractional you are the brain, not the hands. You design the system that executes, and you lead it.

Split the work four ways:
- Strategy and decisions: you.
- Owners: in-house marketers who own channels or programmes day to day.
- Specialists: freelancers and agencies for skills the company doesn't need full time (paid media, design, video, SEO).
- Agents: AI workflows for research, first drafts, reporting, routine operations.

Design around outcomes: each bet in the plan has one owner, and every recurring task maps to one of the four.

Hire for judgment early, outsource execution. A junior generalist with good judgment and good AI workflows can now outproduce what used to need a team of several.

Avoid the classic structures that fail: a big agency with nobody in-house to brief and judge it; a team of specialists with nobody owning the number; or a fractional doing the execution themselves (it doesn't scale and it isn't what they're paid for).
""".trim(),
        listOf(
            "Map every recurring task to owner, specialist or agent.",
            "One owner per bet.",
            "Never be the one executing day to day.",
        ),
        listOf(
            QA("The four-way split of marketing work?", "Strategy (you), owners, specialists, agents."),
            QA("Hire or outsource?", "Hire for judgment, outsource execution."),
            QA("Three failing structures?", "Agency with nobody in-house to judge it, specialists without an owner of the number, the fractional doing execution."),
        ),
        example = """
ShiftWell after the redesign: you (strategy, weekly growth meeting) · Sara, marketer (owns demand gen and website) · paid search freelancer (10 h/week) · designer on retainer · agents for competitor monitoring, call-note summaries, first drafts of comparison pages, and the weekly metrics digest. The old full-service agency was ended.
""".trim(),
        exercise = Exercise(
            "Design the marketing team for a company in your niche at its current stage: owners, specialists, agents, and what you'd stop paying for.",
            listOf("Right-sized for stage", "Clear ownership", "Smart use of agents", "Cost-conscious"),
        ),
        sources = listOf("Andy Grove — High Output Management"),
    ),

    Lesson("mac4", "Hiring the first marketers", 5, """
The first marketing hire often fails — not because the person is bad, but because nobody decided what they should own. Fix that first.

Decide the role from the plan: which bets need an owner, which skills those bets require, and what success looks like in six months. Write a scorecard: mission, three to five outcomes with numbers, and the competencies needed.

Generalist or specialist? Early, a strong generalist who can run the core channel and learn fast usually beats a specialist. Hire specialists when a channel is proven and worth scaling.

Assess with real work: a paid trial project or a case exercise based on the company's real situation beats interviews. Look for judgment (what would you do first and why?), clarity of writing, and evidence they've owned a number.

Seniority: a "Head of Marketing" title on someone junior creates problems later. Be honest about the level.

As a fractional, your best long-term value can be hiring and developing the person who eventually leads marketing — and then stepping back.
""".trim(),
        listOf(
            "Write a scorecard: mission, outcomes with numbers, competencies.",
            "Assess with a real work project, not just interviews.",
            "Hire a generalist first; specialists for proven channels.",
        ),
        listOf(
            QA("What's in a hiring scorecard?", "Mission, 3–5 measurable outcomes, competencies."),
            QA("Why do first marketing hires fail?", "Nobody decided what they should own."),
            QA("Best assessment method?", "A real work project based on the company's situation."),
        ),
        example = """
Scorecard — Demand Generation Marketer, ShiftWell.
Mission: produce qualified demos from multi-practitioner clinics efficiently.
Outcomes (6 months): qualified demos/month 12 → 30; cost per qualified demo ≤ $450; partner co-marketing live with 2 vendors.
Competencies: paid search, landing pages, analytics, clear writing, comfort with sales.
Trial project: "Here's last quarter's funnel data — what would you change first and why?"
""".trim(),
        exercise = Exercise(
            "Write a scorecard for the next marketing hire at a company in your niche, and the trial project you'd give candidates.",
            listOf("Outcomes are measurable", "Role fits the plan", "Trial reveals judgment", "Honest seniority"),
        ),
        sources = listOf("Geoff Smart & Randy Street — Who: The A Method for Hiring"),
    ),

    Lesson("mac5", "Briefing and managing agencies", 5, """
Agencies fail clients mostly because of bad briefs and no accountability — both your job.

A good brief: objective (business outcome), audience (ICP, in their words), message (from the hierarchy), constraints (brand, legal, budget), deliverables, success metric, deadline, and who approves.

Set expectations at the start: what results look like at 30, 60, 90 days, how often you'll review, and what happens if targets are missed.

Manage on outcomes, not activity. Agency reports full of impressions and clicks should be redirected to qualified pipeline and cost per opportunity.

Separate truth from excuses. When targets are missed, look at the evidence: did the agency change the team? Is the client's side slowing things (slow approvals, weak landing pages)? Fix your own side first — it gives you the standing to hold them accountable.

Give them what they need: access, fast feedback, customer insight. Good agencies get better with good clients.

If performance doesn't improve after a clear, fair plan, change agency. Keep the account ownership (ad accounts, data, assets) in the client's name from day one so switching is easy.
""".trim(),
        listOf(
            "Use a full brief: objective, audience, message, constraints, metric, deadline.",
            "Review agencies on pipeline, not activity.",
            "Keep ad accounts and data in the client's name.",
        ),
        listOf(
            QA("Parts of a good agency brief?", "Objective, audience, message, constraints, deliverables, success metric, deadline, approver."),
            QA("First step when an agency misses targets?", "Separate truth from excuse and fix your own side first."),
            QA("Why keep accounts in the client's name?", "So switching agencies is easy and data is never lost."),
        ),
        example = """
Two missed months from the paid agency. Evidence: two juniors rotated onto the account; landing pages load in 5.8 seconds (client side).
Your move: fix page speed within two weeks; ask for the original senior team back; agree a 60-day plan with cost per qualified demo ≤ $500 by day 60. If missed, you move the account.
""".trim(),
        exercise = Exercise(
            "Write a full brief for an agency working for a company in your niche, including 30/60/90-day expectations.",
            listOf("Complete brief", "Business outcome first", "Clear expectations", "Accountability built in"),
        ),
        template = "brief",
        sources = listOf("Andy Grove — High Output Management (task-relevant maturity)"),
    ),

    Lesson("mac2", "Honest measurement", 6, """
Perfect attribution doesn't exist. Pretending it does leads companies to cut the channels that create demand and over-fund the ones that only capture it.

Use a measurement stack:
- CRM source tracking: where each lead and opportunity came from, with clean definitions.
- Self-reported attribution: "How did you hear about us?" as an open field on forms and in sales calls. It catches word of mouth, podcasts, AI assistants and dark social.
- A simple multi-touch view to see which channels appear in journeys.
- Incrementality tests for big spend lines: switch spend off in a region or for a holdout group and compare.
- Marketing mix modelling only when spend and data are large enough.

Agree definitions with sales: what counts as a lead, a qualified lead, an opportunity, and sourced versus influenced pipeline. Most marketing–sales fights are definition fights.

Lead with leading indicators — meetings booked, pipeline created — because they let you steer. Revenue judges; it doesn't steer.

Be humble in reporting: show ranges and say what you don't know. Credibility comes from honesty, not false precision.
""".trim(),
        listOf(
            "Add self-reported attribution to every form and sales call.",
            "Run one incrementality test per quarter on the biggest spend line.",
            "Agree definitions with sales in writing.",
        ),
        listOf(
            QA("The measurement stack?", "CRM source, self-reported attribution, simple multi-touch, incrementality tests, (MMM at scale)."),
            QA("How to prove a channel's incremental impact?", "A holdout or on/off test against a control."),
            QA("Leading vs lagging?", "Leading (meetings, pipeline) steer; lagging (revenue) judge."),
        ),
        example = """
Northline paused paid social in two regions for four weeks. Revenue in those regions fell only 6% versus comparable regions — most "paid" sales would have happened anyway (returning customers).
Decision: cut prospecting spend 30%, exclude past buyers from paid audiences, move budget to retention flows.
""".trim(),
        exercise = Exercise(
            "Design the measurement approach for a company in your niche: definitions to agree with sales, the attribution stack, and one incrementality test.",
            listOf("Clear definitions", "Appropriate stack for size", "Well-designed test", "Honest about limits"),
        ),
        sources = listOf("Les Binet & Peter Field — The Long and the Short of It", "Ronny Kohavi et al. — Trustworthy Online Controlled Experiments"),
    ),

    Lesson("mac6", "One dashboard, ten numbers", 4, """
A dashboard is a decision tool, not a data dump. If nobody changes a decision because of it, it's decoration.

Ten numbers at most, in a funnel order the CEO can read in a minute:
1–2. Demand: qualified leads or demos by source; pipeline created.
3–4. Conversion: lead → opportunity rate; win rate.
5–6. Economics: CAC payback; cost per opportunity by channel.
7–8. Velocity: sales cycle length; pipeline coverage for next quarter.
9–10. Retention: logo churn and NRR (or repeat rate for DTC).

Each number shows actual, target and trend, with one owner.

Review it weekly in the growth meeting: what moved, why, what we'll do. Thirty minutes is enough if the dashboard is clean.

Build it where the data lives (the CRM or a simple BI tool), automate the refresh, and use agents to draft the weekly commentary — but you write the conclusions.
""".trim(),
        listOf(
            "Cap the dashboard at ten numbers in funnel order.",
            "Show actual, target, trend and owner for each.",
            "Review it weekly; write the conclusions yourself.",
        ),
        listOf(
            QA("Test of a useful dashboard?", "It changes decisions."),
            QA("Each number on the dashboard shows?", "Actual, target, trend and an owner."),
            QA("The five areas of the ten numbers?", "Demand, conversion, economics, velocity, retention."),
        ),
        example = """
ShiftWell weekly dashboard (one screen): qualified demos 27 (target 30, ↑) · pipeline created $118k (↑) · demo→opp 38% (↑) · win rate 22% (→) · payback 12 mo (↓ good) · cost/opp partners $310, search $690 · cycle 41 days (↓) · coverage next quarter 3.4× (target 4×, ⚠) · churn 1.4%/mo (↓) · NRR 108%.
""".trim(),
        exercise = Exercise(
            "Write the ten-number dashboard for a company in your niche with targets and an owner for each, and the one number you'd watch most closely right now.",
            listOf("Right ten numbers", "Targets and owners", "Funnel order", "Smart focus number"),
        ),
        sources = listOf("Andy Grove — High Output Management (indicators)"),
    ),

    Lesson("mac3", "Cadence", 4, """
Cadence is how a fractional CMO is present on the days they're absent.

Weekly (30–45 min): the dashboard, progress on each bet, blockers with owners and dates. Decisions recorded.

Monthly (60–90 min): results against plan, what to reallocate (money and people), experiments to start or stop.

Quarterly (half day): strategy review, the next quarter's bets, budget, and the board narrative.

Plus: a weekly CEO one-to-one, and short written updates on the days you're not there.

Keep a decision log in a shared document: what was decided, why, by whom, when to revisit. It prevents re-arguing old decisions and makes your reasoning visible.

Good cadence turns a part-time leader into a full-time influence. Without it, you're a consultant who visits.
""".trim(),
        listOf(
            "Install the weekly growth meeting in your first two weeks.",
            "Keep a shared decision log.",
            "Send a short written update on days you're not there.",
        ),
        listOf(
            QA("Weekly / monthly / quarterly rhythm?", "Dashboard and blockers / results vs plan and reallocation / strategy, bets, budget, board story."),
            QA("Why a decision log?", "It stops re-arguing old decisions and makes reasoning visible."),
            QA("Why does cadence matter so much for a fractional?", "It keeps execution moving on the days you're absent."),
        ),
        example = """
Monday growth meeting (40 min): dashboard (10) · bets: partners, search, homepage (15) · blockers (10) · decisions read back (5).
Decision log entry: "12 Feb — stop webinar series. Why: 2 deals in 4 months, ~1 day/week effort. Owner: Sara. Revisit: Q3 if partner co-webinars request it."
""".trim(),
        exercise = Exercise(
            "Design the weekly, monthly and quarterly cadence for a client in your niche, with agendas, attendees and one example decision-log entry.",
            listOf("Complete rhythm", "Focused agendas", "Right attendees", "Good decision-log entry"),
        ),
        sources = listOf("Patrick Lencioni — Death by Meeting"),
    ),

    Lesson("mac7", "Aligning marketing and sales", 5, """
Most growth problems sit at the boundary between marketing and sales: leads that sales ignores, opportunities marketing never hears about, and two teams blaming each other.

Fix it with agreements, not speeches:
- Shared definitions of each stage (lead, qualified lead, opportunity), written down.
- A service-level agreement (SLA): marketing commits to a volume of qualified leads; sales commits to follow-up speed (for example, within an hour for demo requests) and to a minimum number of attempts.
- A clean handoff: what information passes, how, and who owns the lead at each moment.
- A feedback loop: sales marks why leads are disqualified, and marketing reviews the reasons weekly.
- One shared revenue goal, with pipeline targets by source.

Speed to lead is often the cheapest win in a company. Prospects who request a demo cool quickly; a reply within minutes rather than days changes conversion dramatically.

Sit in on sales calls regularly. It's the fastest way to learn what customers actually say, and it builds trust with the sales team.
""".trim(),
        listOf(
            "Write shared stage definitions and an SLA with sales.",
            "Measure speed to lead and fix it first.",
            "Listen to sales calls every week.",
        ),
        listOf(
            QA("What goes in a marketing–sales SLA?", "Marketing's qualified-lead volume; sales' follow-up speed and attempts."),
            QA("Often the cheapest growth win?", "Speed to lead."),
            QA("Best way to learn what customers say?", "Sit in on sales calls."),
        ),
        example = """
ShiftWell SLA: marketing delivers 30 qualified demo requests/month (5+ practitioners). Sales calls each within 1 business hour, 6 attempts over 10 days, and records a disqualification reason. Weekly 15-minute review of disqualified leads.
Result after 6 weeks: median response time 2 days → 47 minutes; demo → opportunity 30% → 38%.
""".trim(),
        exercise = Exercise(
            "Write a marketing–sales agreement for a company in your niche: definitions, the SLA on both sides, the handoff, and the feedback loop.",
            listOf("Clear definitions", "Balanced SLA", "Practical handoff", "Real feedback loop"),
        ),
        sources = listOf("Jacco van der Kooij — Blueprints for a SaaS Sales Organization", "Aaron Ross — Predictable Revenue"),
    ),
))
