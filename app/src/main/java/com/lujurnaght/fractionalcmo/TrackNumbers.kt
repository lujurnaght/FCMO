package com.lujurnaght.fractionalcmo

/** Track: Growth economics. The math every plan has to survive. */
val NUMBERS = Track("numbers", "Growth economics", "Unit economics, funnels, retention, forecasting, efficiency and the board.", listOf(

    Lesson("num1", "Unit economics that matter", 6, """
CAC (customer acquisition cost) = total sales and marketing cost in a period, fully loaded with salaries, tools and agencies, ÷ new customers won in that period.

LTV (lifetime value) = average revenue per account × gross margin ÷ churn rate. With 2% monthly churn, the average customer lifetime is about 50 months.

LTV:CAC around 3:1 is the classic health benchmark. Much higher can mean you're under-investing in growth; below 1:1 means each customer destroys value.

CAC payback = CAC ÷ (monthly revenue per customer × gross margin). It's the number boards watch most because it's about cash: how many months until a customer has paid back what it cost to win. Under twelve months is strong for SMB-focused companies; enterprise businesses tolerate longer because customers are bigger and stickier.

Blended CAC lies. A strong referral channel can hide a paid channel that loses money on every customer. Always compute CAC and payback by channel, and by segment when possible — and separate "paid CAC" (only paid-acquired customers) from blended.

Careful with LTV for young companies: churn data is thin, so LTV is a guess. Payback is more honest.
""".trim(),
        listOf(
            "Compute CAC and payback per channel in your first audit.",
            "Lead board conversations with payback, not impressions.",
            "Distrust LTV when churn data is young; prefer payback.",
        ),
        listOf(
            QA("CAC payback formula?", "CAC ÷ (monthly revenue per customer × gross margin)."),
            QA("LTV formula?", "Average revenue per account × gross margin ÷ churn rate."),
            QA("Classic healthy LTV:CAC?", "About 3:1."),
            QA("Why compute CAC per channel?", "Blended CAC hides channels that lose money."),
        ),
        example = """
ShiftWell: S&M cost last quarter $240,000; 32 new clinics → CAC $7,500.
Average revenue $630/month, gross margin 80% → $504/month contribution.
Payback = 7,500 ÷ 504 ≈ 15 months.
By channel: partners CAC $3,100 (payback 6 months); Google Ads CAC $14,800 (payback 29 months). Blended looked "okay"; Google Ads was losing money for two years per customer.
""".trim(),
        exercise = Exercise(
            "Invent realistic numbers for a company in your niche (spend by two channels, customers from each, revenue per customer, gross margin). Compute blended CAC, CAC per channel and payback for each, and state your decision.",
            listOf("Correct arithmetic", "Realistic numbers", "Insight from channel split", "Clear decision"),
        ),
        sources = listOf("David Skok — For Entrepreneurs (SaaS metrics)", "Bessemer Venture Partners — State of the Cloud reports"),
    ),

    Lesson("num2", "Reverse-planning the funnel", 6, """
Work backwards from the revenue goal:
- New revenue ÷ average deal size = deals needed.
- Deals ÷ win rate = opportunities needed.
- Opportunities ÷ (lead → opportunity rate) = qualified leads needed.
- And on up to traffic, outreach touches or event attendees.

Then add time: the sales cycle tells you when leads must exist to close in the target quarter. If the cycle is 60 days, leads for Q3 revenue must be created in Q2.

This math tells you whether a plan is realistic before anyone spends a dollar, and it turns arguments ("we need more leads!") into specific questions ("our lead-to-opportunity rate is 18% — why?").

Find the weakest conversion. Doubling a 10% step is usually cheaper than doubling volume at the top. The bottleneck is where the money is.

Split by source: inbound, outbound, partners and referrals usually have very different conversion rates and cycle lengths. One blended funnel hides them.

Build it in a sheet with assumptions in one place so you can change a rate and see the effect on everything downstream. That sheet becomes the backbone of your plan and your board updates.
""".trim(),
        listOf(
            "Put the reverse funnel in every plan you present.",
            "Shift lead creation earlier by the length of the sales cycle.",
            "Fix the worst conversion step before buying more volume.",
        ),
        listOf(
            QA("Reverse-funnel order?", "Revenue → deals → opportunities → qualified leads → leads → traffic/touches."),
            QA("How does the sales cycle change the plan?", "Leads must be created one cycle before the revenue is needed."),
            QA("Where to invest first?", "In the biggest conversion bottleneck."),
        ),
        example = """
Goal: $1.2M new ARR this year at $7,560 ACV → 159 deals.
Win rate 22% → 723 opportunities. Lead → opp 30% → 2,410 qualified leads, ~200 a month.
Current: 120 qualified leads a month. Gap: 80/month.
Option A: +80 leads/month via ads at ~$350 each = $28k/month.
Option B: raise lead → opp from 30% to 40% by routing demos within 10 minutes → needs only ~150 leads/month. B is far cheaper — do it first.
""".trim(),
        exercise = Exercise(
            "Build a reverse funnel for a company in your niche from an annual new-revenue goal to monthly leads, then name the bottleneck you'd attack first and how.",
            listOf("Correct arithmetic", "Realistic rates", "Timing considered", "Smart bottleneck choice"),
        ),
        template = "plan90",
        sources = listOf("Aaron Ross — Predictable Revenue", "Jacco van der Kooij — Blueprints for a SaaS Sales Organization"),
    ),

    Lesson("num4", "Retention is marketing's business too", 6, """
Growth leaks out of the bottom faster than marketing can pour it in at the top. A CMO who ignores retention is filling a bucket with a hole.

Key measures:
- Logo churn: share of customers lost per month or year.
- Revenue churn: revenue lost, including downgrades.
- Net revenue retention (NRR): revenue this year from last year's customers ÷ their revenue last year. Above 100% means expansion outweighs churn; strong B2B SaaS companies often run well above that.
- Retention curves by cohort: do curves flatten (good — a loyal core) or keep falling (a product or fit problem)?

Why it's your business:
- Most churn starts at acquisition: the wrong customers, sold the wrong promise. Fixing the ICP fixes churn.
- Onboarding and activation messages are marketing.
- Expansion is a marketing motion: upgrade campaigns, new use cases, customer advocacy.
- Happy customers are your cheapest channel: referrals, reviews, case studies.

Look at churn reasons by segment. You'll often find that churned customers match the anti-ICP — proof that the targeting fix is worth more than any retention campaign.
""".trim(),
        listOf(
            "Look at cohort retention curves in every diagnostic.",
            "Check whether churned customers match the anti-ICP.",
            "Treat onboarding and expansion as marketing work.",
        ),
        listOf(
            QA("What is NRR?", "Revenue now from last year's customers ÷ their revenue last year; above 100% means expansion beats churn."),
            QA("What do flattening retention curves mean?", "A loyal core of customers — good fit."),
            QA("Where does most churn start?", "At acquisition: wrong customers sold the wrong promise."),
        ),
        example = """
ShiftWell churn: 2.5%/month overall. Under-5-practitioner clinics: 5.1%/month. 5–30 practitioners: 0.9%/month.
The fix isn't a retention campaign — it's stopping acquisition of small clinics. Moving the mix shifts blended churn toward ~1.3% within a year, roughly doubling average customer lifetime.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, describe how you'd analyse churn in the diagnostic, two likely findings, and the marketing actions you'd take on acquisition, onboarding and expansion.",
            listOf("Sound analysis method", "Plausible findings", "Acquisition fix included", "Concrete expansion actions"),
        ),
        sources = listOf("Lincoln Murphy — Customer Success (Sixteen Ventures)", "David Skok — For Entrepreneurs"),
    ),

    Lesson("num5", "Forecasting pipeline", 6, """
Boards and CEOs want to know what's coming, not just what happened. Forecasting is how a CMO earns trust.

Sales velocity is the simplest model: (opportunities × win rate × average deal size) ÷ sales cycle length (days) = revenue per day. It shows the four levers — more opportunities, higher win rate, bigger deals, shorter cycles — and lets you test which change matters most.

Pipeline coverage: compare open pipeline with the target for the period. If win rate is 25%, you need roughly 4× coverage. Low coverage two months before quarter-end is your early warning.

Stage-weighted forecasting: multiply each open opportunity by the historical close rate of its stage. It's more honest than salespeople's gut feel.

Marketing's own forecast: from planned spend and activity, predict leads → opportunities → pipeline → revenue, by source and month. Then report actuals against it.

Forecasts are always wrong; good ones are explained. Write the assumptions next to the numbers, update monthly, and explain variances. A CMO who says "we're 20% behind on pipeline because the partner launch slipped three weeks; here's the recovery plan" keeps credibility. One who surprises the board loses it.
""".trim(),
        listOf(
            "Use the sales velocity formula to compare levers.",
            "Watch pipeline coverage two months before quarter-end.",
            "Write assumptions next to every forecast and explain variances.",
        ),
        listOf(
            QA("Sales velocity formula?", "(Opportunities × win rate × deal size) ÷ cycle length."),
            QA("Pipeline coverage needed at a 25% win rate?", "About 4× the target."),
            QA("What makes a forecast trustworthy?", "Stated assumptions, monthly updates, explained variances."),
        ),
        example = """
ShiftWell: 60 opps/month × 22% × $7,560 ÷ 45 days ≈ $2,218/day (~$66k new ARR/month).
Lever tests: win rate to 28% → +27%. Cycle from 45 to 35 days → +29%. Deal size +10% via per-practitioner pricing → +10%. Opps +20% via ads → +20% at a high cost.
Cheapest big lever: shorten the cycle (faster demos, a clear trial plan).
""".trim(),
        exercise = Exercise(
            "Compute sales velocity for a company in your niche with invented but realistic numbers, then test a 20% improvement in each lever and pick the one you'd pursue, with why.",
            listOf("Correct formula and arithmetic", "Realistic inputs", "All four levers compared", "Good judgment on cost of each lever"),
        ),
        sources = listOf("Jacco van der Kooij — Blueprints for a SaaS Sales Organization"),
    ),

    Lesson("num6", "Efficiency: the numbers investors use", 6, """
Investors judge growth by its efficiency. Speak their metrics.

- CAC payback (months): the cash view of acquisition.
- Magic number: net new ARR in a quarter ÷ sales and marketing spend in the previous quarter. Around 0.75 or above is often considered efficient; well below 0.5 suggests spend isn't converting.
- Burn multiple (David Sacks): net cash burn ÷ net new ARR. Under 1 is excellent, 1–1.5 good, above 2 worrying.
- Rule of 40: revenue growth rate + profit (or free cash flow) margin ≥ 40%. A shorthand for balancing growth and profitability.
- Marketing share of pipeline and cost per opportunity by source.

How to use them: in a diagnostic, compute them to show where the company stands; in the plan, show how your bets move them; in board updates, report the trend.

Context matters. Efficiency metrics move with the market — benchmarks tighten when capital is expensive — and they lag: new channels look inefficient before they mature. Always explain where a metric sits in its cycle.

A CMO fluent in these numbers is treated as an executive. One who reports only leads and traffic is treated as a cost.
""".trim(),
        listOf(
            "Compute magic number and burn multiple in every diagnostic of a funded company.",
            "Show how each bet moves an efficiency metric.",
            "Explain lagging metrics before the board asks.",
        ),
        listOf(
            QA("Magic number?", "Net new ARR in a quarter ÷ prior quarter's S&M spend; ~0.75+ is efficient."),
            QA("Burn multiple?", "Net burn ÷ net new ARR; under 1 excellent, above 2 worrying."),
            QA("Rule of 40?", "Growth rate + profit margin ≥ 40%."),
        ),
        example = """
ShiftWell Q2: net new ARR $190k; Q1 S&M spend $240k → magic number ≈ 0.79: spend is converting acceptably.
Net burn $300k; net new ARR $190k → burn multiple 1.6 — "good-ish, not great".
Plan: cutting losing Google Ads spend (−$45k/q) while partner pipeline grows should bring the burn multiple near 1.2 by Q4.
""".trim(),
        exercise = Exercise(
            "For a funded company in your niche, invent realistic quarterly numbers and compute magic number, burn multiple and CAC payback. Then write two sentences you'd say to the board about them.",
            listOf("Correct calculations", "Realistic inputs", "Board-ready interpretation", "Honest about context and lag"),
        ),
        sources = listOf("David Sacks — 'The Burn Multiple' (Craft Ventures)", "Bessemer Venture Partners — State of the Cloud"),
    ),

    Lesson("num3", "Budgets and the board", 6, """
B2B companies commonly spend somewhere around 5–10% of revenue on marketing, with fast-growing and venture-backed companies often spending more. The total matters less than how it's allocated and how fast it can move.

A practical allocation: about 70% to proven channels, 20% to promising ones, 10% to experiments. Review monthly; move money from losers to winners quickly. Remember fixed costs (people, tools) versus flexible spend (media, agencies, events).

Build the budget bottom-up from the reverse funnel: what each bet needs to produce its share of pipeline, at what cost per opportunity. Then check top-down against the percentage of revenue.

Reporting to the board, in their language:
- Pipeline created and revenue influenced, by source, against plan.
- CAC payback and efficiency trend.
- What worked, what didn't, and what you changed.
- Next quarter's bets and the budget they need.

One page, with assumptions next to the numbers. Boards forgive misses they understood in advance; they don't forgive surprises.

Prepare the CEO before the meeting. A board meeting should never be the first time the CEO hears your numbers.
""".trim(),
        listOf(
            "Allocate 70/20/10 and review monthly.",
            "Build the budget bottom-up from the reverse funnel.",
            "Brief the CEO before every board meeting.",
        ),
        listOf(
            QA("The 70/20/10 budget?", "70% proven channels, 20% promising, 10% experiments."),
            QA("What boards want from marketing?", "Pipeline and revenue by source vs plan, efficiency trend, what changed, next bets."),
            QA("Rule before board meetings?", "The CEO hears your numbers first."),
        ),
        example = """
Board page — Q3 marketing.
Pipeline: $1.42M vs plan $1.30M (+9%). Partners 41%, inbound 37%, outbound 22%.
CAC payback: 15 → 12 months.
Worked: ICP qualification (win rate 14% → 22%). Didn't: webinars (stopped).
Q4 bets: partner program scale-up (+$15k), pricing page test. Budget flat; $45k moved from Google Ads.
""".trim(),
        exercise = Exercise(
            "Write a one-page quarterly board update on marketing for a company in your niche, with invented but realistic numbers.",
            listOf("Board language, not marketing jargon", "Results against plan", "Honest about what failed", "Clear next bets and budget"),
        ),
        template = "board",
        sources = listOf("Brad Feld & Mahendra Ramsinghani — Startup Boards"),
    ),

    Lesson("num8", "Reading the business behind the marketing", 5, """
A CMO who can read the company's economics makes better marketing decisions than one who only reads marketing dashboards.

Know the basics:
- Gross margin: revenue minus the direct cost of delivering it. It sets how much you can afford to pay for a customer.
- Contribution margin: revenue minus all variable costs, including marketing per order (especially for e-commerce). If it's negative on the first order, you need repeat purchases to profit.
- Cash: the company's runway. Marketing plans must fit it — a plan with a 30-month payback is reckless at 12 months of runway.

For e-commerce and DTC: watch first-order contribution, repeat-purchase rate, and the share of revenue from returning customers. Paid social that only re-acquires existing customers inflates ROAS while profit falls.

For services and B2B: watch utilisation and capacity. Selling more than the delivery team can handle creates churn.

Ask for the P&L in the diagnostic. Founders sometimes hesitate; explain that you can't recommend spend without knowing margin and runway. The ones who refuse are telling you something.
""".trim(),
        listOf(
            "Ask for the P&L and runway in every diagnostic.",
            "Fit the payback of your plan inside the runway.",
            "For DTC, check first-order contribution and repeat rate.",
        ),
        listOf(
            QA("Why does gross margin matter to a CMO?", "It sets how much you can afford to pay for a customer."),
            QA("What's contribution margin?", "Revenue minus all variable costs, including marketing per order."),
            QA("Plan vs runway rule?", "A plan's payback must fit inside the company's runway."),
        ),
        example = """
Northline (DTC apparel): AOV $96, gross margin 58% → $55.70. Paid CAC $62 → first order loses $6.30.
Repeat rate within 12 months: 31%, second order margin $55.70 → expected 12-month contribution per customer ≈ $11.
ROAS of 2.2 looked fine; the business barely profits per customer. Fix: retention flows and bundles that lift AOV before scaling spend.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, list the five financial numbers you'd ask for in a diagnostic and explain how each would change a marketing decision.",
            listOf("Right numbers chosen", "Clear link to decisions", "Understands margin and runway", "Practical"),
        ),
        sources = listOf("Common Thread Collective — writing on DTC contribution margin"),
    ),
))
