package com.lujurnaght.fractionalcmo

/** Track: Positioning & strategy. Where the company wins, and what it stops doing. */
val POSITION = Track("position", "Positioning & strategy", "Customer truth, positioning, messaging, pricing, and real choices.", listOf(

    Lesson("pos4", "Customer research that finds the truth", 7, """
Every positioning and strategy decision rests on one thing: why customers actually buy. Companies usually don't know — they know why they think customers buy.

Rob Fitzpatrick's The Mom Test sets the rules for interviews: talk about their life, not your product; ask about specific past events, not opinions about the future; and talk less. "Would you use a feature that…?" produces polite lies. "Tell me about the last time you had to schedule a new practitioner — what happened?" produces truth.

Bob Moesta's switch interview (Jobs to Be Done) reconstructs the moment a customer switched to you. Map the four forces of progress:
- Push: what was going wrong with the old way.
- Pull: what attracted them to the new solution.
- Anxiety: what worried them about switching.
- Habit: what kept them attached to the old way.
Positioning amplifies push and pull; onboarding and proof reduce anxiety and habit.

Who to interview: recent wins (last 90 days, while they remember), losses (why someone else or nothing won), and churned customers (what promise wasn't kept). Six to ten interviews usually reveal the main patterns.

Record the exact words. "We were drowning in double bookings" is a homepage headline; "operational efficiency" is not. Customer language beats marketing language every time.
""".trim(),
        listOf(
            "Ask about specific past events, never hypothetical futures.",
            "Map push, pull, anxiety and habit for every switch.",
            "Collect customers' exact words for messaging.",
        ),
        listOf(
            QA("The Mom Test's three rules?", "Talk about their life not your idea, ask about specific past events, talk less."),
            QA("The four forces of progress (JTBD)?", "Push of the situation, pull of the new, anxiety of the new, habit of the present."),
            QA("Who to interview?", "Recent wins, losses, and churned customers."),
        ),
        example = """
Bad question: "Would you pay more for automated reminders?"
Good question: "Walk me through the week you decided to look for new scheduling software."
Answer: "Two practitioners were booked into the same room twice in one week. A patient walked out. My office manager said she was quitting if we didn't fix it."
Push: double bookings and staff burnout. That's the message — not "smart scheduling".
""".trim(),
        exercise = Exercise(
            "Write a 6-question switch-interview guide for a recent customer of a company in your niche, with at least one question per force of progress.",
            listOf("Past-event questions, no hypotheticals", "Covers all four forces", "Natural and open", "Would surface usable language"),
        ),
        sources = listOf("Rob Fitzpatrick — The Mom Test", "Bob Moesta — Demand-Side Sales 101", "Clayton Christensen — Competing Against Luck"),
    ),

    Lesson("pos1", "Positioning is context", 7, """
April Dunford defines positioning as the context that makes a product's value obvious to the right customers. Her five components:

1. Competitive alternatives — what customers would do if you didn't exist (often a spreadsheet, an agency, or nothing).
2. Unique attributes — capabilities you have that the alternatives don't.
3. Value — what those attributes enable for customers, with proof.
4. Best-fit customers — who cares most about that value, and why.
5. Market category — the frame that makes the value obvious at a glance.

Work in that order. Start from the real alternatives (from your interviews), not from your feature list.

Dunford describes three positioning styles:
- Head to head: win in an existing category, as leader or challenger — only viable if you can genuinely win there.
- Big fish, small pond: dominate a subsegment of an existing category ("scheduling for multi-practitioner clinics").
- Create a new game: define a new category — powerful but slow and expensive; rarely right for a company at your clients' stage.

Most fractional clients should go "big fish, small pond". It focuses spend and makes sales easier quickly.

Symptoms of broken positioning: each salesperson pitches differently, long cycles, losing to "do nothing", constant price pressure, and a homepage that could belong to any competitor.
""".trim(),
        listOf(
            "Build positioning from the real alternatives customers name.",
            "Default to big fish, small pond for growth-stage clients.",
            "Check whether the homepage could belong to a competitor.",
        ),
        listOf(
            QA("Dunford's five components of positioning?", "Competitive alternatives, unique attributes, value, best-fit customers, market category."),
            QA("Dunford's three positioning styles?", "Head to head, big fish small pond, create a new game."),
            QA("Symptoms of broken positioning?", "Inconsistent pitches, long cycles, losing to 'do nothing', price pressure, generic homepage."),
        ),
        example = """
ShiftWell, before: "Smart scheduling software for healthcare." (Head to head with giants.)
After (big fish, small pond):
Alternatives: shared Google Calendar + receptionist; generic scheduling tools.
Unique: room-and-practitioner matching; insurance-aware booking.
Value: no double bookings; 6 hours a week of admin saved per front desk (customer data).
Best fit: clinics with 5–30 practitioners sharing rooms.
Category: "scheduling for multi-practitioner clinics".
""".trim(),
        exercise = Exercise(
            "Write Dunford's five components for a company in your niche (real or typical), and state which of the three styles it should use and why.",
            listOf("Real alternatives, not competitors only", "Attributes tied to value with proof", "Sharp best-fit customer", "Style choice justified"),
        ),
        template = "positioning",
        sources = listOf("April Dunford — Obviously Awesome", "April Dunford — Sales Pitch"),
    ),

    Lesson("pos2", "An ICP that actually filters", 5, """
An ideal customer profile is a filter that makes the company say no to revenue. If it doesn't exclude anyone, it's a persona, not an ICP.

Combine three layers:
- Firmographics: size, industry, geography, tech stack, stage.
- Situation: triggers and conditions that make them ready (growth, a new leader, a failed tool, regulation).
- Pain: the specific problem you solve better than the alternatives.

Build it from data. Rank current customers by retention, expansion, sales-cycle speed and margin. Look at what the top 20% share — and what the bottom 20% share. The best customers are the ones who stay, grow and refer, not the famous logos.

Write the anti-ICP: who to stop selling to and why. It's often the most valuable part: it frees sales time and makes forecasts honest.

Then operationalise: a scored target account list, qualifying questions on forms and in calls, and messaging written for the ICP only. Review it every two quarters as the product and market change.
""".trim(),
        listOf(
            "Rank customers by retention, expansion, speed and margin before defining the ICP.",
            "Write an anti-ICP alongside every ICP.",
            "Put the ICP into forms, scoring and messaging.",
        ),
        listOf(
            QA("Three layers of an ICP?", "Firmographics, situation (triggers), pain."),
            QA("How to derive an ICP from data?", "Compare what the top and bottom customers share on retention, expansion, speed, margin."),
            QA("Why write an anti-ICP?", "It frees sales time and makes forecasts honest."),
        ),
        example = """
ShiftWell top 20% of customers: 8–25 practitioners, physiotherapy or multi-discipline, an office manager who owns scheduling, previously on shared calendars. Average expansion 140% in year two.
Bottom 20%: solo or 2-person practices, price-shopping, churn within 9 months.
ICP: multi-discipline clinics with 5–30 practitioners and an office manager. Anti-ICP: practices under 5 practitioners.
""".trim(),
        exercise = Exercise(
            "Write the ICP and anti-ICP for a company in your niche, with the three layers, and two qualifying questions to put on its demo form.",
            listOf("All three layers specific", "Anti-ICP that frees real time", "Data-driven reasoning", "Practical form questions"),
        ),
        template = "positioning",
        sources = listOf("April Dunford — Obviously Awesome (best-fit customers)", "Geoffrey Moore — Crossing the Chasm (beachhead segment)"),
    ),

    Lesson("pos5", "From positioning to messaging", 6, """
Positioning is the strategy; messaging is how it's said. Most companies skip straight to clever copy and wonder why nothing lands.

Build a messaging hierarchy:
1. The core value proposition — one sentence: for whom, what outcome, unlike what alternative.
2. Three pillars — the main reasons to believe, each tied to a unique attribute.
3. Proof for each pillar — numbers, customer quotes, logos, demos.
4. Objection handling — the anxieties from your customer research, answered.

Geoffrey Moore's positioning statement is a useful scaffold: "For [target customer] who [need], [product] is a [category] that [key benefit]. Unlike [alternative], we [key differentiator]." It's an internal tool, not copy.

Then translate into the homepage in this order: headline (the outcome in the customer's words), subheadline (for whom and how), proof right away, the three pillars, objections, a clear call to action.

Test messages before scaling them: run the headline variants as ads to the ICP, use them in outbound subject lines, or show them to five customers and ask what they think the company does. If they can't say it back to you, rewrite.

Every channel should then use the same hierarchy. Consistency is what turns messages into memory.
""".trim(),
        listOf(
            "Write the hierarchy: value proposition, three pillars, proof, objections.",
            "Use customers' words for the headline.",
            "Test messages cheaply before scaling them.",
        ),
        listOf(
            QA("The messaging hierarchy?", "Value proposition, three pillars, proof, objection handling."),
            QA("Moore's positioning statement?", "For [target] who [need], [product] is a [category] that [benefit]. Unlike [alternative], we [differentiator]."),
            QA("Quick test of a message?", "Show it to five customers and ask them to say what the company does."),
        ),
        example = """
Value proposition: "No more double bookings for clinics with shared rooms."
Pillars: (1) Room-and-practitioner matching → zero double bookings. (2) Insurance-aware booking → fewer claim rejections. (3) 1-day setup → live before next Monday.
Proof: "We went from 9 double bookings a month to none." — Office manager, 14-practitioner physio clinic.
Homepage headline: "Stop double-booking your treatment rooms."
""".trim(),
        exercise = Exercise(
            "Write a messaging hierarchy for a company in your niche: value proposition, three pillars with proof, one objection answered, and the homepage headline.",
            listOf("Value proposition is specific and outcome-led", "Pillars tied to real differentiators", "Credible proof", "Headline in customer language"),
        ),
        sources = listOf("April Dunford — Sales Pitch", "Geoffrey Moore — Crossing the Chasm", "Donald Miller — Building a StoryBrand"),
    ),

    Lesson("pos6", "Pricing and packaging are marketing", 6, """
Pricing is the most powerful growth lever most companies barely touch. A small price improvement drops straight to profit, and packaging shapes who buys and how they grow.

Principles worth knowing:
- Value metric: charge on the unit that grows with customer value (per practitioner, per transaction, per seat) so revenue expands as customers succeed.
- Good-better-best: three tiers, each for a distinct segment. The middle should be the obvious choice; the top anchors it.
- Fences: features that separate tiers by segment need (integrations, permissions, support) rather than crippling the product.
- Willingness to pay: ask customers in research ("At what price would this be too expensive to consider? So cheap you'd doubt the quality?") — Van Westendorp's price sensitivity questions — or test with real offers.

Madhavan Ramanujam's Monetizing Innovation argues for designing the product around the price: understand willingness to pay before building, not after.

As a fractional CMO you often won't own pricing, but you should raise it. When positioning moves upmarket, pricing usually lags behind — and the mismatch quietly kills conversion or margin.

Change pricing carefully: grandfather existing customers or give long notice, test with new customers first, and train sales on the "why" before launch.
""".trim(),
        listOf(
            "Find the value metric that grows with customer success.",
            "Design three tiers for three segments, middle as the obvious pick.",
            "Test pricing on new customers first; grandfather existing ones.",
        ),
        listOf(
            QA("What's a value metric?", "The pricing unit that grows with customer value, so revenue expands as they succeed."),
            QA("Good-better-best design rule?", "Each tier serves a distinct segment; the middle is the obvious choice."),
            QA("Van Westendorp asks about?", "Prices that feel too expensive, too cheap, expensive but acceptable, and a bargain."),
        ),
        example = """
ShiftWell before: one plan, $450/month flat.
After: per-practitioner pricing — Essentials $29/practitioner (scheduling), Clinic $45 (rooms + insurance-aware booking, most popular), Group $65 (multi-location, permissions, priority support).
A 14-practitioner clinic on Clinic: $630/month — more revenue from the best-fit customers, cheaper entry for small ones, and automatic expansion as clinics hire.
""".trim(),
        exercise = Exercise(
            "For a company in your niche, propose a value metric and three tiers (names, prices, who each is for, the fences), and how you'd test it.",
            listOf("Value metric grows with customer value", "Tiers map to segments", "Sensible fences", "Careful test plan"),
        ),
        sources = listOf("Madhavan Ramanujam & Georg Tacke — Monetizing Innovation", "Patrick Campbell / ProfitWell — pricing research"),
    ),

    Lesson("pos7", "Competing without a feature war", 5, """
Competitors aren't the enemy you think. Most deals are lost to indecision or the status quo, and feature wars just make everyone look the same.

Know the competitive landscape in three layers: direct competitors (same category), indirect alternatives (other ways to solve the job), and the status quo (doing nothing or doing it manually).

Compete on your chosen ground. If your positioning is "big fish, small pond", reframe every comparison around the segment's specific needs, where you win. Don't follow a competitor's roadmap or messaging.

Build battlecards for sales: for each main competitor — when we win, when we lose, their claims and our honest answers, landmines (questions that expose their weakness), and proof. Keep them updated from win/loss interviews.

Win/loss analysis is the competitive intelligence that matters most. Interview buyers after decisions (won or lost), ideally through a neutral person, and look for patterns: where we're losing, to whom, and why.

And never trash competitors publicly. It lowers trust. Be precise and fair; let the comparison do the work.
""".trim(),
        listOf(
            "Map direct competitors, indirect alternatives and the status quo.",
            "Build battlecards from win/loss interviews.",
            "Reframe comparisons around your segment's needs.",
        ),
        listOf(
            QA("Three layers of the competitive landscape?", "Direct competitors, indirect alternatives, the status quo."),
            QA("What's in a good battlecard?", "When we win/lose, their claims and our answers, landmines, proof."),
            QA("The most valuable competitive intelligence?", "Win/loss interviews with recent buyers."),
        ),
        example = """
Battlecard — ShiftWell vs BigScheduler.
We win: clinics with shared rooms and 5–30 practitioners.
We lose: single-practitioner practices (they're cheaper) and hospital groups (they integrate with the EHR).
Their claim: "All-in-one platform." Our answer: "For clinics with shared rooms, the scheduling engine is the product — ask them how they prevent room double bookings."
Landmine: "Can you show me how two practitioners sharing one room are scheduled?"
""".trim(),
        exercise = Exercise(
            "Write a battlecard for a company in your niche against its main competitor: when we win, when we lose, their main claim and our answer, one landmine question.",
            listOf("Honest win/lose conditions", "Sharp answer to their claim", "Effective landmine", "Fair, not trash talk"),
        ),
        sources = listOf("April Dunford — Obviously Awesome", "Matthew Dixon & Ted McKenna — The JOLT Effect (status quo)"),
    ),

    Lesson("pos3", "Strategy is choosing", 6, """
Richard Rumelt's kernel of good strategy has three parts:
1. A diagnosis that defines the challenge and simplifies the complexity.
2. A guiding policy — the overall approach for dealing with it.
3. Coherent actions that reinforce each other.

Bad strategy, in Rumelt's terms, is fluff (buzzwords), failure to face the challenge, mistaking goals for strategy ("grow 50%"), and bad objectives (a long list of everything).

A marketing strategy that says yes to every channel, segment and idea is a wish list. Real strategy concentrates resources where they create an advantage — and says out loud what the company will stop doing.

Fit it on one page:
- Diagnosis: the challenge, with evidence.
- Guiding policy: the approach, in one or two sentences.
- Bets: two or three coherent actions, each with an owner, budget and metric.
- What we stop: the activities that don't serve the policy.
- Measures and checkpoints: how and when you'll know.

CEOs and boards trust a plan they can read in two minutes and argue with. They distrust forty slides. Your value is the courage to choose — and the clarity to explain why.
""".trim(),
        listOf(
            "Write diagnosis, guiding policy and coherent actions — in that order.",
            "Always include a 'what we stop' list.",
            "Keep the strategy to one page.",
        ),
        listOf(
            QA("Rumelt's kernel of strategy?", "Diagnosis, guiding policy, coherent actions."),
            QA("Four marks of bad strategy (Rumelt)?", "Fluff, not facing the challenge, goals mistaken for strategy, bad objectives."),
            QA("The test of a real strategy?", "It says what you will not do."),
        ),
        example = """
Diagnosis: growth is flat because demand comes from clinics too small to afford us, and our message doesn't speak to the clinics that do.
Guiding policy: become the obvious choice for multi-practitioner clinics with shared rooms.
Bets: ICP-qualified demand gen (owner: Sara, $20k/q); homepage and sales narrative rebuilt around double bookings (owner: CMO); partner channel with practice-management vendors (owner: CEO, $10k/q).
Stop: generic Google Ads to "clinic software", the webinar series, the TikTok experiment.
""".trim(),
        exercise = Exercise(
            "Write a one-page strategy for a company in your niche: diagnosis, guiding policy, three bets (owner, budget, metric), what you stop, and checkpoints.",
            listOf("Diagnosis faces the real challenge", "Policy is a clear choice", "Bets are coherent", "Credible 'stop' list"),
        ),
        template = "strategy",
        sources = listOf("Richard Rumelt — Good Strategy Bad Strategy", "A.G. Lafley & Roger Martin — Playing to Win"),
    ),
))
