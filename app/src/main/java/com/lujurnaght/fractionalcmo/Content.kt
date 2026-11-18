package com.lujurnaght.fractionalcmo

data class QA(val q: String, val a: String)
data class Exercise(val prompt: String, val rubric: List<String>)
data class Lesson(
    val id: String, val title: String, val minutes: Int, val body: String, val moves: List<String>, val cards: List<QA>,
    val example: String = "", val exercise: Exercise? = null, val template: String? = null, val sources: List<String> = emptyList(),
)
data class Track(val id: String, val title: String, val blurb: String, val lessons: List<Lesson>)

object Curriculum {
    val tracks = listOf(
        Track("role", "The role", "What a fractional CMO is actually bought for.", listOf(
            Lesson("role1", "What you actually sell", 3, """
Companies hire a fractional CMO when they need senior marketing judgment but can't justify, or can't attract, a full-time executive costing a quarter of a million a year or more. They are not buying campaigns. They are buying three things: a strategy that holds, an engine that executes it (people, agencies, tools), and someone accountable for a number.

The typical buyer is a founder-led or PE-backed company past product-market fit, often between a few million and fifty million in revenue, where marketing is run by juniors or agencies without direction. Growth has stalled, spend is rising, or nobody can say which channel works.

Your competition is rarely another fractional. It's the alternatives in the buyer's head: hiring a full-time CMO, handing it to an agency, or the founder keeping marketing on their own plate. Every pitch you make is a comparison with those three.
""".trim(), listOf(
                "Describe your value as a business outcome, never as a task list.",
                "In every sales conversation, name the alternative they're comparing you to.",
                "Sell the number you'll be accountable for, then the plan.",
            ), listOf(
                QA("The three things a fractional CMO is really bought for?", "A strategy that holds, an engine that executes it, and accountability for a number."),
                QA("The buyer's three alternatives to hiring you?", "A full-time CMO, an agency, or the founder keeping marketing."),
                QA("Typical fractional CMO client profile?", "Post product-market fit, founder-led or PE-backed, marketing run by juniors or agencies without direction."),
            )),
            Lesson("role2", "The shapes of an engagement", 3, """
There are four shapes. A diagnostic: two to four weeks, fixed fee, ending in a written diagnosis and roadmap. A retainer: ongoing, a set number of days a month, you own the plan and lead the people. Interim: near full-time while the company hires or through a transition. Advisory: a few hours a month coaching an existing head of marketing.

Top operators lead with a paid diagnostic. It is easy to say yes to, it proves your thinking on their real problem, and it ends in a roadmap that the retainer then executes. The diagnostic sells the retainer.

Scope retainers by outcomes and cadence, not hours: "own the marketing plan, lead the agency and two marketers, weekly exec sync, monthly board metrics." Hours invite haggling over hours. Outcomes invite conversations about value.
""".trim(), listOf(
                "Package a fixed-fee diagnostic as your front door.",
                "Write every retainer scope as outcomes + cadence + what you need from them.",
            ), listOf(
                QA("The four engagement shapes?", "Diagnostic, retainer, interim, advisory."),
                QA("Why lead with a paid diagnostic?", "Easy to buy, proves your thinking on their real problem, and ends in a roadmap the retainer executes."),
                QA("How should a retainer be scoped?", "By outcomes and cadence, never by hours."),
            )),
            Lesson("role3", "The first 90 days", 4, """
Days 1–30: listen and diagnose. Interview the CEO, sales and five to ten customers. Audit the numbers: funnel conversion, CAC by channel, win/loss reasons, retention. Inventory the team, agencies and tools. Deliver a one-page diagnosis built on evidence.

Days 31–60: decide. Positioning, ideal customer, the two or three bets, budget and the metrics that will judge them. Ship one or two quick wins to earn trust: kill wasted spend, fix the leakiest step of the funnel, rewrite the homepage headline that confuses everyone.

Days 61–90: install the machine. Owners, cadence, a dashboard, a testing rhythm. The plan must run on the days you're not in the room.

The classic failure is launching campaigns in week two, before you understand why customers actually buy.
""".trim(), listOf(
                "Interview customers before you touch a campaign.",
                "Record the baseline numbers on day one; you can't prove improvement without them.",
                "Pick quick wins that save money or fix leaks, not ones that add work.",
            ), listOf(
                QA("What should exist at day 30?", "A one-page diagnosis built on customer, sales and data evidence."),
                QA("Best quick wins in month two?", "Cutting wasted spend and fixing the leakiest funnel step."),
                QA("The classic first-90-days failure?", "Launching campaigns before understanding why customers buy."),
            )),
        )),
        Track("position", "Positioning & strategy", "Where the company wins, and what it stops doing.", listOf(
            Lesson("pos1", "Positioning is context", 4, """
April Dunford's framework gives positioning five parts. Competitive alternatives: what customers would do if you didn't exist. Unique attributes: what you have that those alternatives don't. Value: what those attributes make possible, with proof. Best-fit customers: who cares most about that value. Market category: the frame that makes the value obvious at a glance.

Start from the alternatives, not from the product. Most companies position against the competitor they wish they had instead of what buyers actually compare them to, which is often a spreadsheet or doing nothing.

Positioning sits upstream of messaging. If every salesperson pitches differently, deals stall on "we'll think about it", and you keep losing to the status quo, the positioning is broken — no amount of copywriting will fix it.
""".trim(), listOf(
                "Ask recent customers what they'd have done without the product.",
                "Write value as attribute → benefit → proof.",
            ), listOf(
                QA("The five components of positioning (Dunford)?", "Competitive alternatives, unique attributes, value, best-fit customers, market category."),
                QA("Where does positioning work start?", "From the competitive alternatives, not the product."),
                QA("Symptoms of broken positioning?", "Reps pitch differently, long cycles, losing to 'do nothing', price pressure."),
            )),
            Lesson("pos2", "An ICP that actually filters", 3, """
An ideal customer profile is a filter, not a persona. It combines firmographics (size, industry, stage), situation triggers (just raised, new leader, failed launch, expansion) and the specific pain you solve better than the alternatives.

Build it from data. Rank current customers by retention, expansion, speed to close and margin, then look at what the top ones share. Famous logos are a vanity trap; the best customers are the ones who stay, grow and refer.

Write the anti-ICP too: who to stop selling to. Then score target accounts so sales and marketing chase the same list. A real ICP makes the company say no to revenue — that is how you know it works.
""".trim(), listOf(
                "Rank the client's customers by retention and expansion before defining the ICP.",
                "Write an anti-ICP alongside every ICP.",
            ), listOf(
                QA("How do you derive an ICP from data?", "Rank customers by retention, expansion, speed to close and margin; find what the best share."),
                QA("What are buying triggers?", "Events that make a company ready to buy now: funding, a new leader, expansion, a failed initiative."),
            )),
            Lesson("pos3", "Strategy is choosing", 3, """
Richard Rumelt's kernel of strategy has three parts: a diagnosis of what is really going on, a guiding policy for dealing with it, and coherent actions that reinforce each other. A marketing "strategy" that says yes to every channel, segment and idea is a wish list.

Make two or three bets. Say explicitly what the company will stop doing. Tie each bet to a metric, an owner and a budget.

Fit it on one page: Diagnosis → Bets → What we stop → Metrics → Budget. CEOs and boards trust a plan they can read in two minutes and argue with. They distrust forty slides.
""".trim(), listOf(
                "Always include a 'what we stop' list.",
                "Keep the strategy to one page.",
            ), listOf(
                QA("Rumelt's kernel of strategy?", "Diagnosis, guiding policy, coherent actions."),
                QA("The test of a real strategy?", "It says what you will not do."),
                QA("One-page strategy structure?", "Diagnosis, bets, what we stop, metrics, budget."),
            )),
        )),
        Track("numbers", "Growth economics", "The math every plan has to survive.", listOf(
            Lesson("num1", "Unit economics that matter", 4, """
CAC is total sales and marketing cost for a period, fully loaded with salaries and tools, divided by the new customers won in it. LTV is average revenue per account times gross margin, divided by the churn rate. An LTV:CAC of around 3:1 is the classic benchmark for health.

CAC payback is the number boards watch most: CAC divided by (monthly revenue per customer × gross margin). Under twelve months is strong for SMB-focused companies; enterprise businesses tolerate longer.

Blended CAC lies. A great referral channel can hide a paid channel that loses money on every customer. Always compute CAC and payback by channel, and by segment when you can.
""".trim(), listOf(
                "Compute CAC per channel in your first audit.",
                "Lead board conversations with payback, not impressions.",
            ), listOf(
                QA("CAC payback formula?", "CAC ÷ (monthly revenue per customer × gross margin)."),
                QA("Classic healthy LTV:CAC?", "Around 3:1."),
                QA("Why compute CAC per channel?", "Blended CAC hides channels that lose money."),
            )),
            Lesson("num2", "Reverse-planning the funnel", 4, """
Work backwards from the revenue goal. New revenue ÷ average deal size = deals needed. Deals ÷ win rate = opportunities. Opportunities ÷ lead-to-opportunity rate = qualified leads. And so on up to traffic or outreach touches.

Example: $1.2M of new annual revenue at $20k per deal needs 60 deals. At a 25% win rate that's 240 opportunities. If 30% of qualified leads become opportunities, you need 800 qualified leads. Now you know whether the plan is realistic before anyone spends a dollar.

Then find the weakest conversion. Doubling a 10% step is usually cheaper than doubling the traffic at the top. The bottleneck is where the money is.
""".trim(), listOf(
                "Put the reverse funnel in every plan you present.",
                "Fix the worst conversion step before buying more volume.",
            ), listOf(
                QA("Reverse-funnel order?", "Revenue goal → deals → opportunities → qualified leads → leads → traffic or touches."),
                QA("Where should you invest first?", "In the biggest conversion bottleneck, not the top of the funnel."),
            )),
            Lesson("num3", "Budgets and the board", 3, """
B2B companies commonly spend somewhere around 5–10% of revenue on marketing, with fast-growing companies spending more. The number matters less than its allocation: roughly 70% to proven channels, 20% to promising ones, 10% to experiments.

Report to the board in their language: pipeline created, revenue influenced, CAC payback, efficiency trend. Never impressions, followers or open rates.

Bring forecasts with the assumptions written down. Boards forgive misses they understood in advance. They don't forgive surprises.
""".trim(), listOf(
                "Use 70/20/10 to structure any budget.",
                "State assumptions next to every forecast.",
            ), listOf(
                QA("The 70/20/10 budget?", "70% proven channels, 20% promising, 10% experiments."),
                QA("What a board wants from marketing?", "Pipeline, revenue contribution, CAC payback and the trend, with assumptions stated."),
            )),
        )),
        Track("channels", "Channels & demand", "Where buyers come from, now and after AI.", listOf(
            Lesson("ch1", "Channel-market fit", 3, """
Brian Balfour's point: product, channel, market and pricing model have to fit each other. A $500-a-year product can't pay for field sales. A $200k contract won't close from a social ad. Deal size and the way the buyer buys decide which channels are even possible.

Most companies that grow well win with one or two core channels, not eight mediocre ones. Traction's Bullseye method: brainstorm every channel, test the three most promising cheaply, then focus on the one that works until it saturates.

Your job as CMO is often to stop the company doing too many things badly.
""".trim(), listOf(
                "Check ACV against channel cost before approving any channel.",
                "Run cheap tests on three channels; scale one.",
            ), listOf(
                QA("What decides which channels are viable?", "Deal size (ACV) and how the buyer buys."),
                QA("The Bullseye framework?", "Brainstorm all channels, test the top three cheaply, focus on the winner."),
            )),
            Lesson("ch2", "Creating demand vs capturing it", 3, """
Capturing demand harvests intent that already exists: search, review sites, retargeting, comparison pages. It's efficient but capped by how many buyers are in-market. The B2B Institute's widely cited 95:5 rule says only about 5% of B2B buyers are in-market at any moment.

Creating demand builds memory and preference among the other 95%: content, community, podcasts, events, brand, founder-led social. It pays later, and it's what makes capture cheaper.

Companies that only capture flatten out. Companies that only create run out of runway. Balance depends on stage and cash.
""".trim(), listOf(
                "Diagnose whether the client is capture-heavy or creation-heavy.",
                "Measure creation with self-reported attribution, not last click.",
            ), listOf(
                QA("The 95:5 rule?", "Only ~5% of B2B buyers are in-market at any time; 95% are future buyers."),
                QA("Capture vs creation?", "Capture harvests existing intent; creation builds future demand."),
            )),
            Lesson("ch3", "Search after AI", 3, """
More and more buyers ask an AI assistant instead of searching. Being recommended there — generative engine optimization — depends on being clearly and consistently described across the web: specific pages that answer real buyer questions, third-party mentions in reviews, comparisons, communities and press, and structured, consistent facts about what you do and for whom.

Measure it two ways: track whether AI assistants mention you for your category's key questions, and ask every new lead "how did you hear about us?" because analytics won't see the conversation that sent them.

A CMO who can explain and act on this is ahead of most of the market.
""".trim(), listOf(
                "Ask three AI assistants your client's category questions in week one.",
                "Add a 'how did you hear about us' field to every form.",
            ), listOf(
                QA("What drives visibility in AI answers?", "Answer-shaped pages, third-party mentions and reviews, consistent descriptions across the web."),
                QA("How do you measure demand AI creates?", "Self-reported attribution plus tracking AI answers for category questions."),
            )),
        )),
        Track("machine", "Leading the machine", "Team, agencies, agents, measurement, cadence.", listOf(
            Lesson("mac1", "Team, agencies and agents", 3, """
As a fractional you are the brain, not the hands. Split the work four ways: strategy (you), owners (in-house marketers), specialists (freelancers and agencies), and agents (AI workflows for research, drafts, reporting and operations).

Brief agencies with the objective, audience, message, constraints, budget, success metric and deadline — then judge output against the brief, not your taste of the day.

Hire for judgment early and outsource execution. A junior with judgment and good agents can now outproduce a team of five.
""".trim(), listOf(
                "Write a one-page brief template and use it for every vendor.",
                "Map every recurring task to owner, specialist or agent.",
            ), listOf(
                QA("Parts of a good agency brief?", "Objective, audience, message, constraints, budget, success metric, deadline."),
                QA("Your role in the team as a fractional?", "The brain, not the hands: strategy, direction and accountability."),
            )),
            Lesson("mac2", "Honest measurement", 3, """
Perfect attribution doesn't exist, and pretending it does leads to cutting the channels that create demand. Use a stack: CRM source, self-reported attribution, a simple multi-touch view, and incrementality tests — switch spend off in one region or for a holdout group and compare.

One dashboard, ten numbers at most, owned and reviewed weekly. Lead with leading indicators — meetings booked, pipeline created — because they let you steer. Revenue judges; it doesn't steer.
""".trim(), listOf(
                "Run one holdout test per quarter on the biggest spend line.",
                "Cap the dashboard at ten numbers.",
            ), listOf(
                QA("How do you prove a channel's incremental impact?", "A holdout or on/off test against a control."),
                QA("Leading vs lagging indicators?", "Leading ones (meetings, pipeline) steer; lagging ones (revenue) judge."),
            )),
            Lesson("mac3", "Cadence", 3, """
Weekly: thirty minutes on the numbers and blockers, each with an owner. Monthly: results against plan, and decisions to move money. Quarterly: strategy review, new bets, the board story.

Write decisions down where everyone can find them. A fractional who installs a cadence keeps the company moving on the days they aren't there — and that is exactly what makes them worth the retainer.
""".trim(), listOf(
                "Install the weekly meeting in your first two weeks.",
                "Keep a decision log.",
            ), listOf(
                QA("Why does cadence matter so much for a fractional?", "It keeps execution moving on the days you're absent."),
                QA("Weekly / monthly / quarterly rhythm?", "Numbers and blockers / results vs plan and budget moves / strategy, bets, board story."),
            )),
        )),
        PIPELINE,
        CLOSING,
        Track("delivery", "Delivery & retention", "Keeping clients, proving it, growing them.", listOf(
            Lesson("del1", "Managing the CEO", 3, """
Your real client is usually the CEO. Hold a weekly one-to-one. No surprises, ever. Disagree in private and commit in public. Bring options with a recommendation, not problems.

Translate marketing into revenue language: "This will add about $80k of pipeline a month at this cost," not "this will boost awareness". A CEO who trusts your judgment renews; one who has to check your work replaces you.
""".trim(), listOf(
                "Weekly CEO one-to-one, with a written agenda.",
                "Every recommendation comes with its revenue logic.",
            ), listOf(
                QA("Rules for the CEO relationship?", "No surprises, disagree privately and commit publicly, bring options with a recommendation."),
            )),
            Lesson("del2", "Proof and case studies", 3, """
Document the baseline on day one; without it you can't prove anything later. Send a one-page monthly report: what moved, why, what's next.

At milestones, write a case study: situation, what you did, the numbers, a quote. Ask for a testimonial and a referral at the moment of a win, when gratitude is highest — not at the end of the engagement.
""".trim(), listOf(
                "Baseline on day one.",
                "Ask for the testimonial at the win, not at the end.",
            ), listOf(
                QA("Structure of a case study?", "Situation, what you did, the numbers, a quote."),
                QA("When to ask for a testimonial?", "At the moment of a win."),
            )),
            Lesson("del3", "Expansion and a graceful exit", 3, """
Renew the plan every quarter with new goals; a retainer without fresh goals drifts toward cancellation. Expand scope where you've earned it: more days, sales alignment, hiring.

The best ending is hiring and onboarding your full-time replacement. It's the referral nobody forgets, and companies that grow out of you will hire you again at the next company their founders start.
""".trim(), listOf(
                "Re-set goals every quarter.",
                "Offer to hire your successor when the time comes.",
            ), listOf(
                QA("How do retainers stay alive?", "New goals every quarter."),
                QA("The best way to end an engagement?", "Hire and onboard your full-time replacement."),
            )),
        )),
        Track("ai", "Irreplaceable", "Your edge when execution is nearly free.", listOf(
            Lesson("ai1", "What AI takes, and what it can't", 3, """
AI is collapsing the cost of execution: drafts, research, analysis, ad variations, reporting. Anyone who sells production is being repriced.

What it doesn't own: accountability for a number, judgment under ambiguity with incomplete data, taste, the trust of a CEO, and influence inside an organisation. Your value moves from producing to deciding and directing — and you should say so in how you sell.
""".trim(), listOf(
                "Sell decisions and accountability, not output.",
                "List what in your offer AI could do tomorrow, and move away from it.",
            ), listOf(
                QA("What AI doesn't own in a CMO's job?", "Accountability, judgment under ambiguity, taste, CEO trust, organisational influence."),
                QA("Where does a CMO's value move as AI spreads?", "From producing to deciding and directing."),
            )),
            Lesson("ai2", "Run an agent stack", 3, """
Build reusable workflows: market and competitor research, ICP and account research, drafts written from your thinking, reporting summaries, personalised outbound. You own the inputs — strategy, voice, data — and you review the outputs.

One CMO with a good stack can now deliver what used to take a four-person team. That's your pricing leverage and your moat: the stack, the prompts and the judgment that sits on top of them.
""".trim(), listOf(
                "Document every workflow you build; it's an asset.",
                "Review AI output against the brief, like an agency's.",
            ), listOf(
                QA("Your role in an agent stack?", "Own the inputs (strategy, voice, data) and review the outputs."),
                QA("Why is the stack a moat?", "It lets one CMO deliver a team's work — pricing leverage."),
            )),
            Lesson("ai3", "Taste and judgment as practice", 3, """
Taste is trained by exposure and critique: study great campaigns, write teardowns, keep a swipe file. Judgment is trained by making predictions and scoring them later — a judgment journal.

The sparring and daily cases in this app are that training. Treat each one like a real client hour: decide, commit, and read the elite answer to see what you missed.
""".trim(), listOf(
                "Keep a judgment journal: prediction, date, outcome.",
                "One teardown a week.",
            ), listOf(
                QA("How is taste trained?", "Exposure and critique: teardowns, swipe files."),
                QA("How is judgment trained?", "Make predictions, write them down, score them later."),
            )),
        )),
    )

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
