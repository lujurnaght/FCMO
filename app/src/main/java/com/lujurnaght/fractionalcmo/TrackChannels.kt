package com.lujurnaght.fractionalcmo

/** Track: Channels & demand. Where buyers come from — now and after AI. */
val CHANNELS = Track("channels", "Channels & demand", "Channel fit, demand creation, paid, content, outbound, partners, AI search, experiments.", listOf(

    Lesson("ch1", "Channel-market fit", 5, """
Brian Balfour's four fits: product–market, product–channel, channel–model and model–market. A channel works only if it fits how the product is bought and what the business can afford to pay per customer.

Deal size decides most of it. A $500-a-year product can't pay for field sales or events. A $200k contract won't close from a social ad — it needs relationships, account-based work and a sales team. Between those extremes, inbound, outbound, partners and product-led motions each fit a band.

Channels also fit buyers' behaviour: do they search for a solution (search, review sites), ask peers (communities, referrals), follow experts (content, podcasts), or buy through someone they already use (partners, marketplaces)?

Most companies that grow well win with one or two core channels, not eight mediocre ones. Traction's Bullseye method (Weinberg & Mares): brainstorm across all channels, test the three most promising cheaply, then focus on the one that works until it saturates.

Channels decay. Costs rise as competitors arrive; formats fatigue. Always keep a small experiment running on the next channel before the current one saturates.

Your job is often to stop the company doing too many things badly.
""".trim(),
        listOf(
            "Check deal size against channel cost before approving any channel.",
            "Ask how buyers in the ICP actually find solutions.",
            "Test three, scale one, keep one experiment running.",
        ),
        listOf(
            QA("Balfour's four fits?", "Product–market, product–channel, channel–model, model–market."),
            QA("What decides viable channels most?", "Deal size and how the buyer buys."),
            QA("The Bullseye method?", "Brainstorm all channels, test the top three cheaply, focus on the winner."),
        ),
        example = """
ShiftWell ($7,560 ACV, clinics with an office manager):
Field sales — too expensive. Paid social — clinic managers aren't browsing for software there.
Search — yes, but only high-intent terms ("room scheduling for clinics").
Partners — practice-management vendors already sell to the ICP and lack scheduling: strongest fit.
Decision: partners as the core channel, high-intent search as support, everything else stopped.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, evaluate five channels against deal size and buyer behaviour, pick the core channel and one support channel, and say what you'd stop.",
            listOf("Uses deal-size logic", "Grounded in buyer behaviour", "Clear focus", "Credible stop list"),
        ),
        sources = listOf("Brian Balfour — 'Four Fits' essays (Reforge)", "Gabriel Weinberg & Justin Mares — Traction"),
    ),

    Lesson("ch2", "Creating demand vs capturing it", 5, """
Capturing demand harvests intent that already exists: search, review sites, comparison pages, retargeting. It's efficient but capped by how many buyers are in-market. The B2B Institute's widely cited 95:5 rule says only around 5% of B2B buyers are in-market at any moment.

Creating demand builds memory and preference among the other 95%: content, community, podcasts, events, brand campaigns, founder-led social. It pays later — and it's what makes capture cheaper, because buyers already know you when they start searching.

Companies that only capture flatten out when they've harvested the available intent. Companies that only create run out of cash before it pays back. The balance depends on stage and runway: early and cash-tight, lean on capture and direct outreach; with more runway, invest steadily in creation.

Measure them differently. Capture shows in last-click attribution. Creation mostly doesn't — measure it with self-reported attribution ("how did you hear about us?"), branded search growth, direct traffic, share of voice, and how often prospects mention your content.

The common mistake is cutting creation because "it doesn't show in attribution" — then wondering why capture costs rise six months later.
""".trim(),
        listOf(
            "Diagnose whether the client is capture-heavy or creation-heavy.",
            "Measure creation with self-reported attribution and branded search.",
            "Never cut creation only because last-click can't see it.",
        ),
        listOf(
            QA("The 95:5 rule?", "Only ~5% of B2B buyers are in-market at a time; 95% are future buyers."),
            QA("How to measure demand creation?", "Self-reported attribution, branded search, direct traffic, share of voice, prospect mentions."),
            QA("Risk of only capturing?", "Growth flattens once available intent is harvested and capture costs rise."),
        ),
        example = """
A client's dashboard says LinkedIn content "generates 2% of leads". The demo form's "how did you hear about us?" field says 31% mention the founder's posts. Branded search is up 60% since the posts started.
Decision: keep the content, add self-reported attribution to every form, and report both views to the board.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, propose a creation/capture split with reasons, and three ways you'd measure the creation side.",
            listOf("Split fits stage and runway", "Clear reasoning", "Good creation metrics", "Board-ready explanation"),
        ),
        sources = listOf("The B2B Institute (LinkedIn) — 95:5 rule research", "Les Binet & Peter Field — The Long and the Short of It"),
    ),

    Lesson("ch4", "Paid acquisition without burning cash", 6, """
Paid channels are the fastest way to buy growth — and the fastest way to burn money. Run them like an investor.

Start from economics: the most you can pay per customer comes from gross margin and payback targets, not from the platform's suggested bids.

Test properly: a clear hypothesis, one variable at a time where possible, enough budget to reach meaningful numbers, and kill criteria set in advance ("if cost per qualified demo is above $400 after $3,000, we stop").

On modern platforms, creative is the targeting. Algorithms find audiences; your job is to feed them many distinct creative angles grounded in customer research — pains, outcomes, objections — and to refresh before fatigue.

Measure honestly. Platform-reported conversions over-count. Track to qualified pipeline and revenue in the CRM, and run incrementality tests (geo holdouts, on/off periods) for big budgets.

For e-commerce, watch contribution margin, not ROAS alone: a ROAS of 3 can lose money if margins are thin or most buyers were existing customers.

Scale gradually; most platforms punish sudden big jumps in budget. And keep paid as one part of the mix — a company entirely dependent on one ad platform is one policy change from a crisis.
""".trim(),
        listOf(
            "Set the maximum CAC from margin and payback before bidding.",
            "Write kill criteria before every test.",
            "Track paid to CRM pipeline, not platform conversions.",
        ),
        listOf(
            QA("Where does your maximum CAC come from?", "Gross margin and payback targets."),
            QA("Why is creative 'the targeting' now?", "Algorithms find audiences; distinct creative angles tell them whom to find."),
            QA("Why can a ROAS of 3 lose money?", "Thin margins or mostly existing customers re-acquired."),
        ),
        example = """
ShiftWell max CAC for 12-month payback: $504 × 12 = $6,048.
Test: high-intent search, $4,000 budget, 3 angles (double bookings / room utilisation / insurance rejections).
Kill criteria: cost per qualified demo > $600 after $3,000.
Result: "double bookings" angle at $410 per qualified demo; others above $900 — killed. Scale the winner by ~20% a week.
""".trim(),
        exercise = Exercise(
            "Design a paid test for a company in your niche: max CAC (show the math), hypothesis, three creative angles from customer pains, budget and kill criteria.",
            listOf("Correct economics", "Clear hypothesis", "Angles from real pains", "Firm kill criteria"),
        ),
        sources = listOf("Gabriel Weinberg & Justin Mares — Traction", "Common Thread Collective — paid social and contribution margin writing"),
    ),

    Lesson("ch5", "Content and SEO that compounds", 6, """
Content compounds when it's built around what buyers actually search for and ask — and when it serves sales, not just traffic.

Prioritise by intent, bottom of the funnel first:
1. Comparison and alternative pages ("X vs Y", "alternatives to X").
2. Use-case and problem pages ("scheduling for clinics with shared rooms").
3. Pricing, integration and "how it works" pages.
4. Only then broad educational content.

Bottom-funnel pages have small volumes and high conversion; they pay back first.

Make content genuinely better: original data, real examples, expert opinions, clear answers. Thin content written for keywords increasingly loses — to better content and to AI answers that summarise it.

Every piece should have a job in the sales process: answering an objection, supporting a demo follow-up, giving salespeople something to send.

Distribution matters as much as creation: repurpose into posts, emails, sales enablement and partner materials.

Measure what matters: conversions and pipeline from organic, rankings for high-intent terms, and how often your content is cited in AI answers — not raw traffic.
""".trim(),
        listOf(
            "Start with comparison, use-case and pricing pages.",
            "Give every piece a job in the sales process.",
            "Measure organic pipeline and AI citations, not traffic.",
        ),
        listOf(
            QA("Content priority order?", "Comparison/alternatives → use-case/problem → pricing/integration → broad education."),
            QA("Why bottom-funnel first?", "Small volumes, high conversion, fastest payback."),
            QA("Right content metrics?", "Organic pipeline, rankings on high-intent terms, AI citations."),
        ),
        example = """
ShiftWell content plan, first 90 days:
"ShiftWell vs BigScheduler", "BigScheduler alternatives for multi-practitioner clinics", "How to stop double-booking treatment rooms", "Scheduling with insurance-aware booking", a pricing explainer.
Each page ends with a demo CTA and is linked in sales follow-up emails. Result tracked as demos and pipeline from organic.
""".trim(),
        exercise = Exercise(
            "Write a first-90-days content plan for a company in your niche: five pages by intent, the job each does in sales, and how you'll measure them.",
            listOf("Prioritised by intent", "Clear sales job per piece", "Specific to niche", "Right metrics"),
        ),
        sources = listOf("Ross Simmonds — Create Once, Distribute Forever"),
    ),

    Lesson("ch6", "Outbound and account-based for clients", 6, """
For higher-value deals, waiting for inbound is too slow. Outbound and account-based marketing (ABM) go to the best accounts directly.

Outbound done well is research-led and targeted: a tight account list from the ICP, triggers, personalised first lines, multi-touch sequences across channels, and a clear handoff to sales. AI makes research and personalisation cheap — which means generic volume has become worthless and relevance is the only edge.

ABM concentrates marketing and sales on a defined list of accounts:
- One-to-one: a handful of very high-value accounts with fully tailored programmes.
- One-to-few: clusters of similar accounts (same industry or problem) with tailored messaging.
- One-to-many: hundreds of accounts with light personalisation and targeted ads.

Make it a joint motion: marketing warms accounts (ads, content, events), sales and SDRs reach out, and both track account engagement — not just leads.

Measure accounts: coverage (contacts reached per account), engagement, meetings, pipeline and win rate on target accounts versus the rest.

Protect deliverability and reputation: authenticated domains, sensible daily volumes, and clean lists. One spam-flagged domain can damage the company's email for months.
""".trim(),
        listOf(
            "Build outbound on a tight list, triggers and research.",
            "Choose 1:1, 1:few or 1:many ABM by deal size.",
            "Measure target accounts, not leads.",
        ),
        listOf(
            QA("Three ABM tiers?", "One-to-one, one-to-few, one-to-many."),
            QA("What AI changes in outbound?", "Personalisation is cheap, so relevance is the only edge."),
            QA("How to measure ABM?", "Account coverage, engagement, meetings, pipeline and win rate on target accounts."),
        ),
        example = """
One-to-few cluster: 40 physiotherapy groups with 3+ locations.
Marketing: a benchmark report on room utilisation across multi-site physio groups, LinkedIn ads to their operations leads.
Sales: personalised outreach referencing the report and each group's growth (new locations).
Target: meetings with 12 of 40 accounts this quarter.
""".trim(),
        exercise = Exercise(
            "Design a one-to-few ABM play for a company in your niche: the account cluster, the marketing asset, the outreach angle, and the targets.",
            listOf("Tight, sensible cluster", "Valuable asset", "Relevant outreach angle", "Measurable targets"),
        ),
        sources = listOf("Aaron Ross — Predictable Revenue", "Sangram Vajre — Account-Based Marketing for Dummies"),
    ),

    Lesson("ch7", "Partners, communities and events", 5, """
Some of the best channels borrow trust that already exists.

Partners: companies that serve the same customers with a complementary product or service — software vendors, agencies, consultants, marketplaces. Types: referral partners (send leads), integration partners (your products work together), resellers. Good partnerships have a clear value for the partner (revenue share, a better product for their customers, retention), simple enablement, and one owner on each side.

Communities: where your buyers already gather — professional associations, Slack groups, forums, LinkedIn groups. Contribute before promoting. Building your own community works only with a strong reason to gather and someone who'll run it for years.

Events: expensive and slow to measure, but powerful for high-value deals. Small, curated dinners or roundtables for 10–15 target buyers often beat big trade-show booths. Go to industry events with a meeting plan, not a booth plan.

All three create relationships that attribution struggles to see. Track sourced and influenced pipeline, and ask new customers where they first heard of you.
""".trim(),
        listOf(
            "Find partners who serve the ICP with a complementary offer.",
            "Contribute to communities before promoting in them.",
            "Prefer curated dinners and meeting plans over booths.",
        ),
        listOf(
            QA("Three partner types?", "Referral, integration, reseller."),
            QA("What makes a partnership work?", "Clear value for the partner, simple enablement, one owner on each side."),
            QA("Better than a trade-show booth for high-value deals?", "Small curated dinners or roundtables for target buyers."),
        ),
        example = """
ShiftWell partner deal with a practice-management software vendor: an integration (appointments sync), a 20% referral fee on first-year revenue, co-written guide for multi-practitioner clinics, and joint webinar for the vendor's customers. One partner manager owns it on each side. Target: 25% of new pipeline from the partner within two quarters.
""".trim(),
        exercise = Exercise(
            "Name the best partner type for a company in your niche, design the deal (value for them, enablement, owners), and set a target.",
            listOf("Right partner choice", "Real value for partner", "Practical enablement", "Measurable target"),
        ),
        sources = listOf("Jay McBain — partnership ecosystem research", "Gabriel Weinberg & Justin Mares — Traction"),
    ),

    Lesson("ch3", "Search after AI", 6, """
More and more buyers ask an AI assistant instead of searching, and AI summaries appear above search results. Being recommended there — sometimes called generative engine optimization (GEO) or AI search optimization — depends on how clearly and consistently the company is described across the web.

What helps:
- Answer-shaped pages: specific, factual pages answering real buyer questions — who it's for, how it compares, pricing, use cases.
- Third-party mentions: reviews, comparison sites, communities, press, partner pages, and analysts. Models lean heavily on what others say about you.
- Consistent facts: the same category, audience and differentiators described the same way everywhere.
- Being part of the conversation: original data and research that others cite.

How to measure: regularly ask several AI assistants the category's key questions ("best scheduling software for clinics with shared rooms") and track whether and how you're mentioned; ask every new lead "how did you hear about us?" — analytics won't see the conversation that sent them.

Expect some traffic to fall as answers are given directly, while the visitors who do arrive are better informed and convert better. Shift reporting from traffic to pipeline.

This changes fast. Treat specifics as hypotheses to test, not rules — and keep checking what the assistants actually say.
""".trim(),
        listOf(
            "Ask three AI assistants the category's key questions in week one.",
            "Fix inconsistent descriptions of the company across the web.",
            "Add 'how did you hear about us?' to every form.",
        ),
        listOf(
            QA("What drives visibility in AI answers?", "Answer-shaped pages, third-party mentions, consistent facts, citable original data."),
            QA("How to measure AI-search visibility?", "Track mentions in AI answers to category questions, plus self-reported attribution."),
            QA("What happens to traffic?", "Some falls, but visitors who arrive are better informed — report pipeline, not traffic."),
        ),
        example = """
Week-one check for ShiftWell: three assistants asked "best scheduling software for physiotherapy clinics with shared rooms". Mentioned by one of three, described as "general scheduling tool".
Actions: comparison and use-case pages; push for reviews on two software review sites; consistent "scheduling for multi-practitioner clinics" description on partner pages and profiles; publish a room-utilisation benchmark others can cite.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, write the five questions buyers would ask an AI assistant, and a 30-day plan to be recommended in the answers.",
            listOf("Realistic buyer questions", "Covers pages, mentions and consistency", "Measurable", "Practical in 30 days"),
        ),
        sources = listOf("Princeton/Georgia Tech et al. — 'GEO: Generative Engine Optimization' paper (2023)"),
    ),

    Lesson("ch8", "Experiments that teach", 5, """
A testing culture is how a fractional CMO learns fast without wasting budget. Most "tests" teach nothing because they aren't designed.

Every experiment needs:
- A hypothesis: "If we [change], then [metric] will [move], because [reason from research]."
- One primary metric, decided in advance, as close to revenue as you can measure.
- A minimum size or duration: enough traffic or conversions to tell signal from noise. Small B2B volumes often mean testing bigger changes rather than small tweaks.
- Kill and scale criteria, set before launch.
- An owner and a review date.

Prioritise with a simple score — impact, confidence, ease (ICE) — and keep a backlog.

Run few tests at once if volume is low; they interfere with each other.

Write down results, including failures, in a shared log: what you tested, what happened, what you learned, what you'll do. A company's learning compounds only if it's recorded.

Beware vanity wins: a higher click-through rate that brings worse leads is a loss.
""".trim(),
        listOf(
            "Write hypothesis, metric, size, and kill criteria before launching.",
            "Prioritise the backlog with ICE.",
            "Log every result, including failures.",
        ),
        listOf(
            QA("Hypothesis format?", "If we [change], then [metric] will [move], because [reason]."),
            QA("What's ICE?", "Impact, confidence, ease — a prioritisation score."),
            QA("Low B2B volume means?", "Test bigger changes, and fewer at once."),
        ),
        example = """
Hypothesis: if the demo form asks for number of practitioners and routes 5+ to sales within 10 minutes, qualified demo-to-opportunity rate will rise from 30% to 40%, because interviews show speed matters to office managers.
Metric: demo → opportunity rate. Duration: 6 weeks (~300 demos). Kill: below 33% at week 6. Owner: Sara. Review: 15 March.
""".trim(),
        exercise = Exercise(
            "Write a complete experiment for a company in your niche: hypothesis, metric, size/duration, kill and scale criteria, owner, review date.",
            listOf("Hypothesis grounded in research", "Metric near revenue", "Realistic size", "Clear decision rules"),
        ),
        sources = listOf("Sean Ellis & Morgan Brown — Hacking Growth", "Ronny Kohavi et al. — Trustworthy Online Controlled Experiments"),
    ),
))
