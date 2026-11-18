package com.lujurnaght.fractionalcmo

/** Track: The role. What a fractional CMO is bought for, and how one operates. */
val ROLE = Track("role", "The role", "What a fractional CMO is bought for, and how the best ones operate.", listOf(

    Lesson("role1", "What you actually sell", 5, """
Companies hire a fractional CMO when they need senior marketing judgment but can't justify — or can't yet attract — a full-time executive. They are not buying campaigns. They're buying three things:

1. A strategy that holds: who to sell to, why they choose you, where demand comes from, and what to spend.
2. An engine that executes it: people, agencies, tools and agents, briefed and led.
3. Accountability for a number: someone senior who owns pipeline or revenue contribution and reports on it.

Junior marketers and agencies sell output. You sell decisions and the responsibility that comes with them. That's why you can charge more than an agency while doing less "work" — and why you must never describe yourself by activities ("I do content, SEO and paid").

Your competition is rarely another fractional. It's the alternatives in the buyer's head: hiring a full-time CMO (expensive, slow, risky), handing it to an agency (execution without direction), promoting a junior (cheap, unready), or the founder keeping marketing (free, but the founder's time is the most expensive resource in the company). Every conversation you have is a comparison with those.

The best description of the job: you make the company's growth predictable. Everything else — positioning, channels, team — is a means to that.
""".trim(),
        listOf(
            "Describe your value as decisions and a number you own, never activities.",
            "Name the buyer's alternative in every sales conversation.",
            "Frame the job as making growth predictable.",
        ),
        listOf(
            QA("The three things a fractional CMO is bought for?", "A strategy that holds, an engine that executes it, accountability for a number."),
            QA("The buyer's four alternatives?", "A full-time CMO, an agency, promoting a junior, the founder keeping marketing."),
            QA("The job in one line?", "Making the company's growth predictable."),
        ),
        example = """
Founder: "So you'd run our social and ads?"
Weak: "Yes, and content, SEO, email…"
Strong: "Your marketer and agency can run those. I'd decide which of them deserve your money, make sure every channel is aimed at the customers who actually close, and own the pipeline number with you every week. Think of it as a CMO's judgment at a fraction of the cost and with none of the hiring risk."
""".trim(),
        exercise = Exercise(
            "A founder asks: \"What's the difference between you and an agency?\" Write your answer in under 80 words, for your niche.",
            listOf("Sells decisions and accountability, not activity", "Names the alternative fairly", "Specific to the niche", "Concise and confident"),
        ),
        sources = listOf("David C. Baker — The Business of Expertise", "Alan Weiss — Million Dollar Consulting"),
    ),

    Lesson("role4", "Who buys, and when", 6, """
Not every company needs a fractional CMO, and selling to the wrong ones wastes months. Learn the buyers and the moments.

The four main buyer types:
- Founder-led companies past product-market fit. Growth came from the founder's network and selling; it's plateauing. The CEO is the buyer.
- VC-backed companies between rounds. They need to show efficient growth before the next raise. The CEO buys, the board influences — and investors often recommend fractionals.
- PE-backed companies. The operating partner wants a value-creation plan executed fast, with clear metrics. Buyer: CEO plus operating partner; they buy for outcomes and speed.
- Profitable bootstrapped companies. Careful with money, loyal when they trust you, and often the best long-term clients.

The moments (triggers) when they buy:
- Growth stalls after founder-led sales.
- A funding round with a growth target attached.
- A CMO or head of marketing leaves.
- A first marketing hire who's struggling without direction.
- A new product, market, or price change.
- A board asking questions nobody can answer about marketing efficiency.

Who doesn't buy well: pre-revenue startups (they need customer discovery, not a CMO), companies wanting cheap execution, and organisations where nobody can give you data or authority.

Your niche should sit where one buyer type meets one or two triggers. That combination tells you exactly whom to target and when.
""".trim(),
        listOf(
            "Pick one buyer type and two triggers as your focus.",
            "Track triggers on your target list.",
            "Avoid pre-revenue and execution-only buyers.",
        ),
        listOf(
            QA("Four main fractional CMO buyer types?", "Founder-led post-PMF, VC-backed between rounds, PE-backed, profitable bootstrapped."),
            QA("Six buying triggers?", "Stall after founder-led sales, funding with growth target, marketing leader leaves, struggling first hire, launch or price change, board questions."),
            QA("Who buys a fractional CMO poorly?", "Pre-revenue startups, execution-only buyers, companies that won't give data or authority."),
        ),
        example = """
Focus: VC-backed B2B SaaS between Seed+ and Series A, with two triggers — "first marketing hire struggling" and "board asking about CAC".
Where to find them: VC portfolio pages, job boards (a junior marketing role open for 3+ months), founders posting about growth plateaus.
Opening line that fits the moment: "Teams at your stage often hire their first marketer before deciding what that person should own."
""".trim(),
        exercise = Exercise(
            "Choose the buyer type and two triggers you'll focus on. For each trigger, say where you'd spot it publicly and the first line you'd send.",
            listOf("Coherent buyer focus", "Triggers are observable", "Smart places to spot them", "Opening lines fit the moment"),
        ),
        sources = listOf("David C. Baker — The Business of Expertise"),
    ),

    Lesson("role2", "The shapes of an engagement", 5, """
Four shapes, each with its own economics:

- Diagnostic: two to four weeks, fixed fee, ends in a written diagnosis, a 90-day plan and a board narrative. Your front door.
- Retainer: ongoing, a set rhythm (often one to three days a week), you own the plan and lead the people, measured on outcomes. Your core business.
- Interim: near full-time for a few months, usually while the company hires a permanent leader or through a crisis. Higher fee, fewer clients at once.
- Advisory: a few hours a month coaching an existing head of marketing. Low effort, lower fee, often long-lived.

Top operators lead with the diagnostic. It's easy to buy, proves your thinking on their real problem, and the roadmap it produces is what the retainer executes. The diagnostic sells the retainer.

Scope retainers by responsibilities and cadence, not hours: "own the marketing plan, lead the agency and two marketers, weekly exec sync, monthly board metrics." Hours invite haggling over hours; responsibilities invite conversations about value.

Watch for scope creep. When a client asks for something outside the scope, say yes to the outcome and talk about the trade-off: "Happy to take on the website — that would push the pricing work to next month, or we add a day." Never silently absorb it.

Mix shapes deliberately. A healthy fractional business often looks like two or three retainers, one diagnostic in progress, and one or two advisory clients.
""".trim(),
        listOf(
            "Package a fixed-fee diagnostic as your front door.",
            "Scope retainers by responsibilities and cadence.",
            "Handle scope creep as a trade-off, out loud.",
        ),
        listOf(
            QA("The four engagement shapes?", "Diagnostic, retainer, interim, advisory."),
            QA("Why lead with the diagnostic?", "Easy to buy, proves your thinking, produces the roadmap the retainer executes."),
            QA("How to handle scope creep?", "Say yes to the outcome and name the trade-off: time, priority or fee."),
        ),
        example = """
Retainer scope, written well:
"I own the marketing plan and budget; lead Sara (marketer) and the paid agency; run a weekly 45-minute growth meeting; deliver the monthly board metrics page; and join quarterly planning. Target: marketing-sourced pipeline from $300k to $900k a quarter by Q4. Two days a week, $9,000/month, 30 days' notice after the first three months."
""".trim(),
        exercise = Exercise(
            "Write a retainer scope for a client in your niche: responsibilities, cadence, the people you lead, the target, rhythm, fee and notice.",
            listOf("Responsibilities, not hours", "Measurable target", "Clear cadence", "Realistic terms"),
        ),
        sources = listOf("Alan Weiss — Million Dollar Consulting", "Blair Enns — Pricing Creativity"),
    ),

    Lesson("role5", "Operating a fractional practice", 5, """
You're running a small business, not just doing marketing. The best fractionals treat their practice with the same discipline they bring to clients.

Capacity: most fractional CMOs can serve three or four retainer clients well at once. More than that and quality drops — and quality is your only marketing. Price so that three clients reach your income target.

Calendar: give each client fixed days or half-days. Protect one block a week for your own pipeline and one for thinking. Batch meetings so you have deep-work time.

Boundaries: agree response times ("same business day"), channels (Slack, not WhatsApp at midnight), and what counts as urgent. Clients respect clear boundaries; they resent inconsistency.

Tools: a CRM for your own pipeline (this app's Field to start), a shared document per client for decisions and plans, a dashboard per client, and your agent stack.

Admin and legal: a company or legal entity, a standard contract (scope, fees, term, notice, confidentiality, IP, liability), professional insurance where relevant, invoicing monthly in advance, and a buffer of savings for gaps between clients.

Keep a weekly CEO review of your own business: pipeline, cash, client health (green/amber/red), and one improvement to your method.
""".trim(),
        listOf(
            "Cap retainers at three or four and price for that.",
            "Fix client days and protect a weekly prospecting block.",
            "Review your own pipeline, cash and client health weekly.",
        ),
        listOf(
            QA("How many retainers can a fractional serve well?", "Usually three or four at once."),
            QA("What to agree as boundaries?", "Response times, channels, and what counts as urgent."),
            QA("Your weekly business review covers?", "Pipeline, cash, client health, one method improvement."),
        ),
        example = """
A week at three clients: Monday — Client A (full day). Tuesday — Client B (morning), own pipeline (afternoon). Wednesday — Client C (full day). Thursday — Client A (morning), Client B (afternoon). Friday — thinking, writing posts, diagnostic work, weekly review.
""".trim(),
        exercise = Exercise(
            "Design your ideal week with three clients, your boundaries (response time, channels, urgent), and your monthly income target with the price per client it requires.",
            listOf("Realistic capacity", "Protected prospecting and thinking time", "Clear boundaries", "Arithmetic consistent"),
        ),
        sources = listOf("Alan Weiss — Million Dollar Consulting", "David C. Baker — The Business of Expertise"),
    ),

    Lesson("role6", "Running the diagnostic", 7, """
The diagnostic is where clients decide whether you're the real thing. Run it like a method, not a chat.

Week 1 — evidence.
- Interviews: the CEO, sales (individually, not as a group), customer success, the marketer, and five to eight customers — recent wins, a loss or two, and a churned customer if possible.
- Data: CRM pipeline by source and stage, win rates, deal sizes and cycle length; marketing spend by channel; web and conversion analytics; retention and expansion.
- Assets: homepage, pricing page, sales deck, recent campaigns, the agency's reports.

Week 2 — diagnosis. Find the few things that explain most of the problem. Typical findings: the ICP is too wide (sales chases deals that can't close); positioning describes features instead of value; one channel is quietly losing money; demo requests wait too long; nobody owns the number.

Write the diagnosis on one page: what's happening, why (with evidence), what it costs, and the three bets that fix it.

Week 3 — plan. The 90-day plan: bets, owners, budget, metrics, milestones; what stops. Plus the narrative for the board: where we are, why, what we'll do, how we'll know.

Present it live, to the CEO first, then to the team. The test of a good diagnostic: the CEO says "that's exactly it" and asks what it would take for you to run it.
""".trim(),
        listOf(
            "Interview customers individually — wins, losses and churned.",
            "Write the diagnosis on one page: what, why, cost, three bets.",
            "Present to the CEO first, then the team.",
        ),
        listOf(
            QA("Who to interview in a diagnostic?", "CEO, sales individually, customer success, the marketer, 5–8 customers including losses and churned."),
            QA("The one-page diagnosis contains?", "What's happening, why (evidence), what it costs, three bets."),
            QA("The test of a good diagnostic?", "The CEO says 'that's exactly it' and asks what it takes for you to run it."),
        ),
        example = """
ShiftWell — one-page diagnosis.
What: flat ARR for three quarters; 48% of demos from clinics under 5 practitioners, which close at 4%.
Why: homepage and ads target "all clinics"; no qualification on the form; sales spends half its time on deals that can't afford the product.
Cost: ~$1M of planned growth missed; sales capacity wasted.
Bets: (1) ICP = 5–30 practitioner clinics; qualify on the form. (2) Rewrite homepage around multi-practitioner scheduling pain. (3) Move 40% of Google Ads budget to partner channel with practice-management software vendors.
""".trim(),
        exercise = Exercise(
            "For a typical company in your niche, write a one-page diagnosis: what's happening (with numbers), why (with evidence), the cost, and three bets.",
            listOf("Evidence-based, not generic", "Root causes, not symptoms", "Cost quantified", "Bets are focused and coherent"),
        ),
        template = "diagnosis",
        sources = listOf("Richard Rumelt — Good Strategy Bad Strategy (diagnosis)", "Rob Fitzpatrick — The Mom Test (customer interviews)"),
    ),

    Lesson("role3", "The first 90 days", 6, """
Days 1–30: listen and diagnose. If you ran a diagnostic, you're ahead; if not, do its work now. Record the baseline numbers on day one — you can't prove improvement without them.

Days 31–60: decide and win early. Confirm positioning, ICP, the two or three bets, budget and metrics. Ship one or two quick wins that earn trust: kill wasted spend, fix the leakiest funnel step, add qualification to the demo form, rewrite the confusing headline. Quick wins should save money or fix leaks — not add work.

Days 61–90: install the machine. Owners for every bet, a weekly growth meeting, one dashboard, a testing rhythm, and a decision log. By day 90, the plan must run on the days you're not in the room.

Throughout: manage the CEO relationship deliberately — a weekly one-to-one, no surprises, and visible progress against the baseline.

The classic failures: launching campaigns in week two before understanding why customers buy; trying to fix everything at once; and being invisible to the team (they should know what you're doing and why).

At day 90, present a short review: baseline vs now, what worked, what didn't, and the next quarter's bets. That review is what renews retainers.
""".trim(),
        listOf(
            "Record the baseline on day one.",
            "Pick quick wins that save money or fix leaks.",
            "Present a day-90 review against the baseline.",
        ),
        listOf(
            QA("The three phases of the first 90 days?", "Listen and diagnose; decide and win early; install the machine."),
            QA("What makes a good quick win?", "It saves money or fixes a leak, rather than adding work."),
            QA("What renews retainers at day 90?", "A review of baseline vs now, what worked, and next quarter's bets."),
        ),
        example = """
Day-90 review for ShiftWell: qualified demos/month 12 → 27; demos from under-5-practitioner clinics 48% → 11%; win rate 14% → 22%; Google Ads spend −35% with more pipeline. What didn't work: the webinar series (2 deals, high effort) — stopped. Next quarter: partner channel scale-up and pricing page test.
""".trim(),
        exercise = Exercise(
            "Write a 90-day plan for a client in your niche: baseline metrics, three bets with owners, two quick wins, the cadence, and what the day-90 review will measure.",
            listOf("Baseline defined", "Focused bets with owners", "Smart quick wins", "Measurable day-90 review"),
        ),
        template = "plan90",
        sources = listOf("Michael Watkins — The First 90 Days"),
    ),

    Lesson("role7", "Thinking like an owner of the number", 5, """
The difference between a marketing director and a CMO is ownership. A director delivers campaigns; a CMO owns a commercial outcome and the trade-offs needed to reach it.

Speak revenue, not marketing. Founders and boards think in pipeline, revenue, margin and cash. Translate everything: not "brand awareness grew" but "we're now in 40% of shortlists in our category, up from 15%, and win rate rose with it."

Make decisions with incomplete data. You'll rarely have perfect attribution. State your assumptions, make the call, set a checkpoint, and change course when the data says so. Indecision costs more than most wrong decisions.

Be commercially honest. If marketing isn't the problem — if it's the product, the price, or sales follow-up — say so, with evidence. Fractionals who tell the CEO uncomfortable truths are the ones who get renewed and referred.

Hold the line on focus. The CEO will bring new ideas every week. Your job is to evaluate them against the plan, say yes to very few, and explain why.

Executive presence comes from preparation: knowing the numbers better than anyone in the room, having a point of view, and being calm when things go wrong.
""".trim(),
        listOf(
            "Translate every marketing result into revenue language.",
            "Decide with stated assumptions and a checkpoint.",
            "Tell the CEO uncomfortable truths, with evidence.",
        ),
        listOf(
            QA("Director vs CMO?", "A director delivers campaigns; a CMO owns a commercial outcome and its trade-offs."),
            QA("How to decide without perfect data?", "State assumptions, decide, set a checkpoint, adjust."),
            QA("Where does executive presence come from?", "Preparation: knowing the numbers, having a view, staying calm."),
        ),
        example = """
CEO: "Our competitor just launched a podcast. Should we?"
Owner answer: "Our plan is betting on partner channels because that's where 60% of our best customers came from. A podcast would take about a day a week of Sara's time for probably a year before it moves pipeline. I'd say not now — let's revisit at the Q3 review if partner pipeline is on track."
""".trim(),
        exercise = Exercise(
            "Your client's CEO says marketing is the problem, but your data shows sales takes two days to follow up on demo requests. Write what you'd say to the CEO.",
            listOf("Commercially honest", "Evidence-based", "Revenue language", "Keeps the relationship constructive"),
        ),
        sources = listOf("Richard Rumelt — Good Strategy Bad Strategy", "Annie Duke — Thinking in Bets"),
    ),
))
