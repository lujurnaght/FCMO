package com.lujurnaght.fractionalcmo

/** Track: Delivery & retention. Keeping clients, proving it, growing them. */
val DELIVERY = Track("delivery", "Delivery & retention", "The CEO, the team, proof, reporting, bad news, renewal and exit.", listOf(

    Lesson("del1", "Managing the CEO", 5, """
Your real client is usually the CEO. The relationship decides renewals more than results do.

Rules that work:
- A weekly one-to-one with a short written agenda: progress, decisions needed, risks.
- No surprises, ever. Bad news travels early and comes with a plan.
- Disagree in private, commit in public. Never undermine the CEO in front of the team.
- Bring options with a recommendation, not problems.
- Speak revenue: "this adds about $80k of pipeline a month at this cost", not "this boosts awareness".

Understand their style. Some CEOs want detail, some want a one-line answer. Some decide fast, some need to think. Adapt the format; keep the substance.

Founders are often attached to past marketing decisions they made themselves. Change them with evidence and respect: "That worked brilliantly to get you here; the next stage needs something different."

A CEO who trusts your judgment renews and refers. One who has to check your work replaces you.
""".trim(),
        listOf(
            "Weekly CEO one-to-one with a written agenda.",
            "Deliver bad news early, with a plan.",
            "Bring options with a recommendation.",
        ),
        listOf(
            QA("The core rules for the CEO relationship?", "Weekly 1:1, no surprises, disagree privately/commit publicly, options with a recommendation, revenue language."),
            QA("How to change a founder's past decision?", "With evidence and respect for why it worked before."),
        ),
        example = """
Weekly 1:1 agenda (sent the day before): (1) Pipeline vs plan: +9%. (2) Decision needed: partner revenue share 15% or 20%? I recommend 20% — reasons attached. (3) Risk: homepage launch slips a week (designer ill); no effect on Q3 target.
""".trim(),
        exercise = Exercise(
            "Write next week's one-to-one agenda for a CEO client in your niche, including one decision with your recommendation and one risk.",
            listOf("Concise and prioritised", "Clear recommendation", "Risk with mitigation", "Revenue language"),
        ),
        sources = listOf("Michael Watkins — The First 90 Days (managing up)"),
    ),

    Lesson("del4", "Leading a team that isn't yours", 5, """
You'll lead people who don't report to you full time, who were there before you, and who may feel threatened. Influence comes from clarity, respect and making their work matter.

In the first weeks: meet everyone one-to-one, ask what's working, what's frustrating, and what they'd change. Take their answers seriously — they know things you don't.

Give clear ownership: each person owns a bet or a channel, with a target they helped set. People commit to goals they shaped.

Make them look good. Credit them publicly for wins, especially in front of the CEO. Take responsibility for misses yourself.

Remove obstacles: approvals, tools, unclear priorities. Often the fastest performance gain is unblocking.

Develop people: give feedback that's specific and timely, share how you think, and teach the frameworks you use. The team you leave behind is part of your legacy — and of your references.

Handle resistance directly and kindly: ask what's behind it. Usually it's fear of losing status or a disagreement worth hearing.
""".trim(),
        listOf(
            "Meet every team member one-to-one in week one.",
            "Let people help set the targets they own.",
            "Credit the team publicly; own misses yourself.",
        ),
        listOf(
            QA("First move with an inherited team?", "One-to-ones: what's working, what's frustrating, what they'd change."),
            QA("Why let people help set targets?", "People commit to goals they shaped."),
            QA("Fastest performance gain often?", "Removing obstacles."),
        ),
        example = """
Sara, the marketer, is guarded — she'd hoped to become Head of Marketing.
You: "My job is partly to make the case for exactly that. Let's make the demand-gen bet yours, with a target you set with me, and you present the results to the CEO each month." Three months later she's presenting to the board.
""".trim(),
        exercise = Exercise(
            "A client's marketer resents your arrival. Write what you'd say in your first one-to-one and how you'd structure their ownership.",
            listOf("Empathetic and direct", "Clear ownership offered", "Builds their visibility", "Professional boundaries"),
        ),
        sources = listOf("Kim Scott — Radical Candor", "Andy Grove — High Output Management"),
    ),

    Lesson("del2", "Proof and case studies", 5, """
Proof is the currency of your practice. Without it, every sale starts from zero.

Record the baseline on day one: the key numbers before you started. Without a baseline, you can't prove anything later.

At milestones, write the case study:
- Situation: the company (anonymised if needed) and the problem, in numbers.
- What you did: the diagnosis and the few key decisions — not a list of activities.
- Results: before and after, with time frame.
- Quote: the CEO in their words.

Ask for permission early: put a case-study clause in your contract (anonymised by default, named with approval).

Ask for testimonials and referrals at the moment of a win — a record month, a great board meeting — when gratitude is highest. Make it easy: offer to draft the quote for their approval.

Turn each case into several assets: a one-page PDF, a LinkedIn post, a talk section, a slide in your proposals.
""".trim(),
        listOf(
            "Baseline on day one.",
            "Put a case-study clause in every contract.",
            "Ask for the testimonial at the win, and offer to draft it.",
        ),
        listOf(
            QA("Structure of a case study?", "Situation, what you did (key decisions), results with time frame, a quote."),
            QA("When to ask for a testimonial?", "At the moment of a win."),
            QA("How to make testimonials easy?", "Offer to draft the quote for their approval."),
        ),
        example = """
"B2B SaaS for clinics, $3.2M ARR, flat for three quarters. Diagnosis: half of demand came from clinics too small to buy. Decisions: narrowed ICP, rebuilt message around double bookings, launched a partner channel. In two quarters: qualified demos 12 → 27/month, win rate 14% → 22%, CAC payback 15 → 12 months. 'For the first time, I'm not the only person bringing in deals.' — Maya O., CEO."
""".trim(),
        exercise = Exercise(
            "Write a case study (real or realistic) for your niche in under 150 words: situation, key decisions, results, quote.",
            listOf("Numbers before/after", "Decisions, not activities", "Credible quote", "Concise"),
        ),
        template = "case",
        sources = listOf("Alan Weiss — Million Dollar Consulting"),
    ),

    Lesson("del5", "When things go wrong", 5, """
Every engagement hits a bad month: a missed target, a failed launch, a channel collapsing, a key person leaving. How you handle it decides whether you're renewed.

Tell first. The CEO should hear bad news from you, early, before they see it in a dashboard or hear it from sales.

Use a simple structure: what happened (facts, numbers), why (your honest diagnosis — including your own part), what you're doing about it (the plan, with dates), and what you need from them.

Own your part without self-flagellation. "I underestimated how long partner onboarding takes" is credible. Blaming the team, the market or the agency isn't — even when they contributed.

Separate noise from trend. One bad month may be variance; three is a pattern. Show which it is with data.

Reset expectations if the plan was wrong. It's better to revise a target with a clear reason than to miss it silently every month.

Handled well, a crisis builds more trust than a smooth quarter.
""".trim(),
        listOf(
            "Bring bad news first, early, with a plan.",
            "Use facts → why → plan → what you need.",
            "Own your part; never blame the team in public.",
        ),
        listOf(
            QA("Structure for delivering bad news?", "What happened, why (including your part), the plan, what you need."),
            QA("One bad month vs three?", "One may be variance; three is a pattern."),
            QA("Better than missing a target silently?", "Revising it early with a clear reason."),
        ),
        example = """
"Maya — before you see the dashboard: pipeline was $210k below plan in October. Why: the partner launch slipped three weeks, and I didn't build that risk into the forecast — my miss. Plan: two co-webinars with the partner in November, plus $8k moved from brand to high-intent search for six weeks. I expect to recover about two-thirds of the gap by mid-December. I need you to call their CEO this week to lock the webinar dates."
""".trim(),
        exercise = Exercise(
            "You missed the quarterly pipeline target by 25% for a client in your niche. Write the message to the CEO using the four-part structure.",
            listOf("Facts first", "Honest ownership", "Credible plan with dates", "Clear ask"),
        ),
        sources = listOf("Kim Scott — Radical Candor"),
    ),

    Lesson("del3", "Renewal, expansion and a graceful exit", 5, """
Retainers end for three reasons: the goals were reached and nothing new was set, the relationship weakened, or the value stopped being visible. You can prevent all three.

Renew the plan every quarter with fresh goals. A retainer without new goals drifts toward cancellation.

Make value visible: monthly one-page reports against the baseline, and a quarterly review with the CEO.

Expand where you've earned it: more days, sales alignment, pricing work, hiring the team, a new market. Propose expansion at quarterly reviews, tied to the next goal.

Plan the end from the start. The best ending is hiring and onboarding your full-time replacement — the CMO or head of marketing who'll carry the plan forward. It's the most valuable thing you can leave, the referral nobody forgets, and companies (and founders) often hire you again later.

When you leave: a handover document (strategy, decisions, dashboards, access, open risks), a final review against the baseline, and a request for a case study and referrals.
""".trim(),
        listOf(
            "Set new goals every quarter.",
            "Propose expansion at quarterly reviews, tied to a goal.",
            "Leave with a handover, a final review, and referrals.",
        ),
        listOf(
            QA("Three reasons retainers end?", "Goals reached with nothing new, weakened relationship, invisible value."),
            QA("The best way to end an engagement?", "Hire and onboard your full-time replacement."),
            QA("What to leave behind at exit?", "Handover document, final review vs baseline, case study and referral requests."),
        ),
        example = """
Month 9 at ShiftWell: pipeline goal reached. Quarterly review proposes: (1) next goal — 30% of new ARR from partners; (2) expansion — lead the hiring of a Head of Marketing (+1 day/month for 3 months); (3) then step down to advisory at $3k/month. Maya accepts all three.
""".trim(),
        exercise = Exercise(
            "Your client hit the goals you set. Write the quarterly review proposal: the next goal, an expansion offer, and the exit path.",
            listOf("Fresh, ambitious goal", "Expansion tied to value", "Graceful exit plan", "Commercially sound"),
        ),
        sources = listOf("Alan Weiss — Million Dollar Consulting"),
    ),
))
