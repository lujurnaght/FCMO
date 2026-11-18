package com.lujurnaght.fractionalcmo

/** Track: Your own pipeline. Being chosen before you pitch. */
val PIPELINE = Track("pipeline", "Your own pipeline", "Niche, offer, price, and a machine that brings founders to you.", listOf(

    Lesson("pip1", "Niche or die", 6, """
A generalist fractional CMO is a commodity, and commodities compete on price. The single biggest lever on your income isn't skill — it's how specifically you can be described in one sentence by someone who isn't you.

A niche has three dimensions: industry (who), stage (when), and problem (what's broken). "Marketing leader for growing companies" has none. "B2B SaaS between $2M and $10M ARR, stuck after founder-led sales" has all three. Each dimension you add shrinks the market on paper and grows it in practice, because the people inside it can finally recognise you.

What a niche buys you:
- Referrals become easy. People can only refer what they can describe.
- Content gets sharp. You write for one reader with one problem, so every post lands.
- Proof transfers. Your last case looks like their company, so it counts as evidence, not anecdote.
- Price rises. Specialists are compared with the cost of the problem; generalists are compared with each other.

David C. Baker's test for expertise positioning: can you name the competitors you'd lose to, and are there few of them? If you'd lose to "every marketer on LinkedIn", you have no position.

How to pick: look for the intersection of unfair insight (an industry you've worked in, a problem you've solved before), access (you can reach 200 of these companies), and ability to pay (they're past product-market fit and have budget). Choose a niche you can dominate in a year rather than one that sounds big.

The fear is always "I'll miss opportunities." You won't — you'll still take the occasional good client outside it. A niche controls what you're known for, not what you're allowed to accept. And you can widen it once you own it.
""".trim(),
        listOf(
            "Write your niche as industry × stage × problem, in one sentence.",
            "Test it on a friend: can they name two companies who fit?",
            "Name the 3–5 competitors you'd lose to. If you can't, narrow further.",
        ),
        listOf(
            QA("The three dimensions of a niche?", "Industry (who), stage (when), problem (what's broken)."),
            QA("Four things a niche buys you?", "Easy referrals, sharp content, transferable proof, higher prices."),
            QA("Baker's test for real positioning?", "You can name the few competitors you'd lose to."),
            QA("Where to look for your niche?", "Where unfair insight, access, and ability to pay overlap."),
        ),
        example = """
Too wide: "I help B2B companies grow with strategic marketing."
Better: "I help B2B SaaS companies grow pipeline."
Owned: "I help B2B SaaS companies between $2M and $10M ARR build a repeatable pipeline after founder-led sales stops scaling."

Why the last one works: a VC partner reading it instantly thinks of three portfolio companies whose founders are still closing every deal themselves. A founder reading it recognises the exact moment they're in. And your competitors shrink from "every marketer" to a handful of specialists — whom you can study and out-position.
""".trim(),
        exercise = Exercise(
            "Write your niche in one sentence (industry × stage × problem). Then list three real companies that fit it, and the competitors you'd most likely lose to.",
            listOf("Specificity of industry, stage and problem", "Real companies named that truly fit", "Credible competitor awareness", "Commercial viability (they can pay)"),
        ),
        sources = listOf("David C. Baker — The Business of Expertise", "April Dunford — Obviously Awesome (best-fit customers)", "Blair Enns — The Win Without Pitching Manifesto (specialisation)"),
    ),

    Lesson("pip4", "Design an offer they can say yes to", 7, """
Most fractional CMOs sell themselves ("I'm available two days a week"). The top ones sell an offer: a named, scoped thing with a clear outcome, a clear first step, and a price.

Alex Hormozi's value equation is the best lens: Value = (Dream outcome × Perceived likelihood of achieving it) ÷ (Time delay × Effort and sacrifice). You raise value by making the outcome concrete, raising confidence with proof and a clear method, shortening the time to the first result, and lowering the work the client has to do.

The structure that works for fractionals is a ladder:
1. A front-door diagnostic. Fixed scope, fixed fee, two to four weeks. It ends with a written diagnosis, a 90-day plan, and a board-ready narrative. It's easy to buy because it's small, finite and useful even if they never hire you again.
2. The core retainer. You own the plan and lead the people, measured on agreed outcomes. Scoped by cadence and responsibilities, not hours.
3. An advisory tier. Lighter, for companies that already have a capable marketing lead who needs a senior sparring partner.

Name the diagnostic. "Growth Diagnostic" or "Pipeline Audit" is fine; a name turns a vague service into a product someone can forward to a co-founder.

Reduce risk where you can: a clear end date, a deliverable list, and if you're confident, a guarantee on the diagnostic ("if the plan isn't useful, you don't pay the second half"). Risk reversal costs less than you think, because good clients rarely invoke it.

Finally, make the first result arrive fast. Something tangible in week one — a teardown of their funnel, a fixed leak, a killed wasteful campaign — buys the trust that lets the rest of the engagement happen.
""".trim(),
        listOf(
            "Name and scope a fixed-fee diagnostic as your front door.",
            "Write the retainer as responsibilities + cadence + outcomes.",
            "Promise one tangible result in week one.",
        ),
        listOf(
            QA("Hormozi's value equation?", "(Dream outcome × perceived likelihood) ÷ (time delay × effort and sacrifice)."),
            QA("The fractional offer ladder?", "Front-door diagnostic → core retainer → advisory tier."),
            QA("Why name the diagnostic?", "A name turns a service into a product that can be forwarded and bought."),
            QA("Four ways to raise an offer's value?", "Concrete outcome, more proof/confidence, faster first result, less client effort."),
        ),
        example = """
"Pipeline Diagnostic — 3 weeks, $6,000.
Week 1: interviews with you, sales and 6 customers; funnel and spend audit.
Week 2: diagnosis — where pipeline really comes from, what's wasted, the 3 bets.
Week 3: 90-day plan, budget, metrics, and the slide your board will want.
If the plan isn't useful, you don't pay the second half.

Then, if you want me to run it: Growth Lead retainer — $9,000/month, two days a week, I own the plan, lead your marketer and agency, weekly sync, monthly board metrics."

Every value lever is visible: outcome (a plan and narrative), likelihood (a method and interviews), time (three weeks), effort (they give interviews, you do the rest).
""".trim(),
        exercise = Exercise(
            "Write your own offer ladder: a named diagnostic (scope, duration, price, deliverables, risk reversal) and a retainer (responsibilities, cadence, outcomes, price). Make it specific to your niche.",
            listOf("Diagnostic is concrete and easy to buy", "Retainer scoped by outcomes, not hours", "Value equation levers visible", "Fit with the niche"),
        ),
        template = "offer",
        sources = listOf("Alex Hormozi — \$100M Offers (value equation, offer design)", "Alan Weiss — Million Dollar Consulting", "Blair Enns — Pricing Creativity (offers and options)"),
    ),

    Lesson("pip5", "Pricing yourself", 6, """
Price is a positioning statement. A cheap fractional CMO signals junior; an expensive one with a sharp offer signals someone who has done this before. Underpricing doesn't win more deals — it wins worse clients.

Three anchors set your price:
- The alternative's cost. A full-time CMO costs a large salary plus equity, recruiting fees, months to hire, and a real risk of a bad hire. Two days a week of senior judgment is a fraction of that.
- The value of the problem. If flat growth is costing them a million dollars of planned revenue, a fee of $9,000 a month is a rounding error against the cost of inaction.
- The market. Fractional CMO retainers in the US commonly sit in the mid-four to low-five figures a month, with specialists above that. Know where you sit and why.

Never price by the hour. Jonathan Stark's point: hourly billing punishes you for being efficient and makes every conversation about time instead of value. Price the scope and the outcome.

Use options. Three prices (diagnostic, core, premium) let the client choose how to work with you instead of whether to. The premium option anchors the core one and is sometimes bought.

Raise prices on new clients when you're more than 80% booked or winning almost everything — a near-100% close rate means you're too cheap. Existing clients keep their rate until renewal.

Early on, the right move is often a lower price with a case-study agreement: a reduced fee in exchange for permission to publish results and a testimonial. That's buying proof, not discounting — and it should end after your first two or three clients.
""".trim(),
        listOf(
            "Anchor your price on the cost of a full-time hire and of the problem.",
            "Always present three options; never quote an hourly rate.",
            "Raise prices for new clients once you close almost everything.",
        ),
        listOf(
            QA("Three anchors for your price?", "The alternative's cost, the value of the problem, the market."),
            QA("Why not bill hourly?", "It punishes efficiency and turns conversations into time instead of value."),
            QA("Signal that you're underpriced?", "You win almost every deal or are fully booked."),
            QA("Legitimate early discount?", "A reduced fee in exchange for a published case study and testimonial."),
        ),
        example = """
A founder says: "What's your rate?"
Weak: "I charge $150 an hour."
Strong: "I don't bill by the hour — it would make me slower to help you. Most clients start with a three-week Pipeline Diagnostic at $6,000. If you want me to run the plan afterwards, the retainer is $9,000 a month; some clients add sales alignment for $13,000. For context, a full-time CMO search alone usually takes months before anyone starts."

The founder now compares you with a full-time hire and with the cost of their stuck pipeline — not with a freelancer's hourly rate.
""".trim(),
        exercise = Exercise(
            "Set your three price points (diagnostic, core retainer, premium) and write the two or three sentences you'd say when a founder asks \"what's your rate?\".",
            listOf("Anchored on value or alternatives, not time", "Three coherent options", "Confident, specific wording", "Realistic for the niche"),
        ),
        sources = listOf("Jonathan Stark — Hourly Billing Is Nuts", "Alan Weiss — Value-Based Fees", "Blair Enns — Pricing Creativity"),
    ),

    Lesson("pip11", "Your own pipeline math", 5, """
Run your own business the way you'll ask clients to run theirs: backwards from the number.

Say the goal is $30,000 a month in retainers. At $9,000 average, that's three to four clients. Retainers end — average engagements last somewhere between six and eighteen months — so you also need a steady flow of new ones: roughly one new client every quarter just to stay level, more to grow.

Now the funnel. If you win one in three proposals, you need three proposals per client. If one in two discovery calls leads to a proposal, that's six calls. If one in five real conversations becomes a call, that's thirty conversations. And if one in ten outreach touches starts a conversation, three hundred touches. Your rates will differ; the method won't.

That's why Hormozi's Rule of 100 exists: a hundred primary actions a day — outreach, or content minutes — for a hundred days. Volume early is how you get the data to improve the rates.

Two leading indicators matter most: conversations started and discovery calls held. Everything else follows from them. Track them weekly (that's what Field does in this app).

The other lever is conversion. Every rate in the chain improves with a sharper niche, better proof and a better offer. Doubling your call-to-proposal rate is worth as much as doubling your outreach — and it costs no extra hours.

Finally, protect the flow. Fractionals tend to stop prospecting when busy, then starve when engagements end. Keep a minimum weekly prospecting block even when full.
""".trim(),
        listOf(
            "Write your funnel backwards from your monthly target.",
            "Track conversations started and calls held every week.",
            "Keep a prospecting block in your calendar even when fully booked.",
        ),
        listOf(
            QA("Order of your own reverse funnel?", "Revenue target → clients → proposals → calls → conversations → touches."),
            QA("Hormozi's Rule of 100?", "100 primary actions a day (outreach or content) for 100 days."),
            QA("Your two key leading indicators?", "Conversations started and discovery calls held."),
            QA("The feast-and-famine trap?", "Stopping prospecting when busy, then starving when engagements end."),
        ),
        example = """
Target: $27,000/month → 3 clients at $9,000.
Close rate on proposals: 33% → 9 proposals over the ramp.
Call → proposal: 50% → 18 discovery calls.
Conversation → call: 25% → 72 conversations.
Touch → conversation: 10% → 720 touches.

Spread over 12 weeks: 60 touches a week, about 12 a day. That's the number the "5 outreach a day" move on Today is building toward — and every rate you improve lowers it.
""".trim(),
        exercise = Exercise(
            "Write your own reverse funnel from your monthly target down to weekly outreach, with the conversion rates you're assuming and which rate you'll try to improve first, and how.",
            listOf("Correct arithmetic", "Realistic assumptions", "Clear weekly activity number", "A smart choice of rate to improve"),
        ),
        sources = listOf("Alex Hormozi — \$100M Leads (Rule of 100, core four)", "Aaron Ross — Predictable Revenue"),
    ),

    Lesson("pip7", "Your profile is a landing page", 5, """
Every prospect checks your LinkedIn before replying. It's your homepage, and most fractional profiles waste it with a job title and a list of skills.

Treat it like a landing page with one reader: your niche.

The headline states who you help, the result, and how: "Fractional CMO for B2B SaaS ($2–10M ARR) — building pipeline after founder-led sales." Not "Marketing Leader | Growth | Strategy | Brand".

The banner is a billboard: the same promise, plus one proof point or your offer's name.

The About section follows a simple arc: the problem your niche feels (in their words), why it happens, what you do about it, proof (numbers, logos, a short story), and how to start ("Most clients begin with a three-week Pipeline Diagnostic — message me 'diagnostic'").

Featured is your shop window: your best case study, your offer one-pager, and your best-performing post.

Experience should read as outcomes, not duties: "Took pipeline from $400k to $1.4M a quarter in 9 months" beats "Responsible for demand generation."

Recommendations from founders in your niche are worth more than ten from colleagues. Ask your best past clients or bosses for two sentences about a specific result.

The test: a founder in your niche lands on the profile and, within ten seconds, knows you're for them and what to do next.
""".trim(),
        listOf(
            "Rewrite your headline as who + result + how.",
            "Put your offer and best case study in Featured.",
            "Rewrite experience bullets as outcomes with numbers.",
        ),
        listOf(
            QA("Formula for a strong headline?", "Who you help + the result + how."),
            QA("The arc of a strong About section?", "Their problem → why it happens → what you do → proof → how to start."),
            QA("The ten-second test?", "A founder in your niche knows you're for them and what to do next."),
        ),
        example = """
Before: "Marketing Executive | Growth | Brand | Demand Gen | Ex-Agency"
After: "Fractional CMO for B2B SaaS ($2–10M ARR) · Pipeline after founder-led sales · Pipeline Diagnostic in 3 weeks"

About, first lines: "Your first $2M came from you selling. The next $8M won't — and hiring a full-time CMO to fix it takes six months you don't have. I come in two days a week, find where pipeline really comes from, and build the machine that replaces you as the only salesperson."
""".trim(),
        exercise = Exercise(
            "Write your new LinkedIn headline, the first four sentences of your About section, and one experience bullet rewritten as an outcome.",
            listOf("Headline: who + result + how", "About speaks the niche's language", "Outcome-based proof", "Clear next step"),
        ),
        sources = listOf("April Dunford — Sales Pitch (leading with context)", "Alex Hormozi — \$100M Leads (warm audience)"),
    ),

    Lesson("pip2", "The authority engine", 6, """
Content does discovery for you. When a founder has read six of your posts before your first call, you're not pitching — you're confirming.

The goal isn't reach; it's resonance with a few hundred people who could buy. A post with 2,000 views from founders in your niche beats one with 50,000 from other marketers.

What to publish, in order of power:
1. Teardowns — a real (or anonymised) company's funnel, homepage, pricing page, or positioning, with what you'd change and why.
2. Numbers from the work — "We cut CAC payback from 19 to 11 months. Here's what moved it."
3. Frameworks — your method, named and drawn simply. Frameworks make you quotable and memorable.
4. Contrarian claims with reasoning — "Your next marketing hire shouldn't be a marketer."
5. Stories of mistakes — yours or (anonymised) clients'. They build trust faster than wins.

Cadence: three posts a week is enough if they're good. Consistency over months matters more than any single post.

Repurpose everything. A spar in this app becomes a post about a negotiation lesson. A client insight becomes a teardown. Five posts on one theme become a guide. A guide becomes a talk.

Then do the half most people skip: engage. Comment thoughtfully on posts by founders in your niche every day. That's how your name appears in their world before they've followed you.

Measure resonance with the right signals: replies and DMs from your niche, profile visits from founders, and how often prospects mention your posts on calls.
""".trim(),
        listOf(
            "Publish three posts a week aimed only at your niche.",
            "Turn every spar, case and client insight into a post.",
            "Comment on five posts by founders in your niche every day.",
        ),
        listOf(
            QA("Content goal: reach or resonance?", "Resonance with the few hundred people who could buy."),
            QA("Most powerful content formats?", "Teardowns, numbers from the work, frameworks, contrarian claims, mistake stories."),
            QA("How to measure content in sales terms?", "DMs from the niche, founder profile visits, prospects mentioning posts on calls."),
        ),
        example = """
Spar result: you lost points for not quantifying the cost of flat growth.
Post: "A founder told me growth had been flat for three quarters. I asked about channels. Wrong question. The right one: 'What did your board plan for these nine months?' $3.2M ARR growing at plan would be ~$4.2M. That gap — a million dollars — is the real problem. Marketing tactics are just the answer to it. Price your help against the gap, not against an agency."
""".trim(),
        exercise = Exercise(
            "Write one post for your niche: a hook line, one specific claim, proof (a number or story), the lesson, and a soft call to action.",
            listOf("Hook stops a founder in the niche", "One specific claim", "Credible proof", "Lesson is useful on its own"),
        ),
        template = "post",
        sources = listOf("Alex Hormozi — \$100M Leads (content as lead getter)", "Matthew Dixon & Brent Adamson — The Challenger Sale (teaching insight)"),
    ),

    Lesson("pip8", "Posts that pull", 5, """
A post has one job: make the right reader stop, think "that's me", and associate the insight with you.

The hook decides everything. The first line has to promise something specific to your reader: a number, a tension, a counterintuitive claim, or a scene. "Most SaaS founders hire their first marketer two years too early" beats "Some thoughts on marketing hires."

The body delivers on the hook with proof, in short lines and plain words. One idea per post. If you have three ideas, you have three posts.

Specificity is credibility. "We improved conversion" is forgettable; "Demo-request to meeting went from 41% to 73% after we called every lead within 10 minutes" is memorable — and it signals you've actually done it.

End with a soft call to action that fits the post: a question that invites experience ("What was your first marketing hire?"), or a low-key offer ("I wrote up the full checklist — comment 'checklist' and I'll send it"). Hard pitches in posts repel.

Write for your reader's vocabulary, not marketing jargon. Founders say "we're not getting enough good leads", not "our MQL-to-SQL conversion is suboptimal".

Keep a hook bank: every time a client, prospect or spar says something sharp, write it down. Most great posts start as someone else's sentence.
""".trim(),
        listOf(
            "Write five hook options for every post and pick the most specific.",
            "One idea per post, proved with a number or a scene.",
            "Keep a hook bank of sharp sentences you hear.",
        ),
        listOf(
            QA("The four strongest kinds of hook?", "A number, a tension, a counterintuitive claim, or a scene."),
            QA("Why specificity in posts?", "It's credibility: it signals you've actually done the thing."),
            QA("What kind of CTA works in posts?", "Soft: a question inviting experience or a low-key resource offer."),
        ),
        example = """
Weak hook: "Lead response time matters."
Strong hook: "A founder lost $340k of pipeline last year to a 2-day reply time. Nobody noticed."
Body: three short lines on how you found it (demo requests vs. first reply timestamps), what changed (10-minute routing), the result.
CTA: "How fast does your team answer a demo request? Honest answers only."
""".trim(),
        exercise = Exercise(
            "Write five different hooks for the same insight from your niche, then pick the best one and explain in one line why it's best.",
            listOf("Variety of hook types", "Specificity", "Speaks the niche's language", "Sound judgment in the pick"),
        ),
        sources = listOf("Alex Hormozi — \$100M Leads (hooks, retain, reward)"),
    ),

    Lesson("pip6", "Target list and account research", 5, """
Outbound starts long before the first message. The quality of your list decides your reply rate more than your copy does.

Build a list of 100–200 companies that fit your niche exactly. For each: company, stage signals (headcount, funding, revenue estimates), the decision-maker (usually the CEO or founder at this stage; sometimes a COO or VP Sales), and one trigger if any.

Triggers are why now: a recent funding round, a new head of sales, a marketing job post (they're feeling the pain), a founder posting about growth, a product launch, a price change, a key marketing person leaving. Companies with a trigger reply far more often.

Tier the list:
- Tier 1 (20): perfect fit plus a trigger. Fully personalised research and outreach.
- Tier 2 (50): perfect fit, no trigger. Personalised first line, lighter research.
- Tier 3 (rest): good fit. Lighter-touch sequences and content warming.

Research in ten minutes per Tier 1 account: their homepage message, pricing page, a recent post by the founder, the job board, reviews from customers, and how they show up in AI assistants for their category. You're looking for one observation that would make the founder think "they actually looked".

AI agents are perfect for the first pass — summarising a company, finding triggers, drafting an observation — but you verify every fact. One wrong detail destroys credibility.

Keep the list alive in Field → Pipeline: move people through stages and note the trigger and next step.
""".trim(),
        listOf(
            "Build a list of 100–200 exact-fit companies with the decision-maker.",
            "Tier it: 20 with triggers, 50 good fits, the rest.",
            "Find one specific observation per Tier 1 account before writing.",
        ),
        listOf(
            QA("What's a buying trigger?", "A 'why now' event: funding, new sales leader, marketing job post, launch, key person leaving."),
            QA("The three tiers of a target list?", "Tier 1 fit + trigger (full research), Tier 2 fit (personalised line), Tier 3 lighter touch."),
            QA("Rule for AI-assisted research?", "Use it for the first pass, verify every fact yourself."),
        ),
        example = """
Tier 1 entry: "Ledgerly — fintech tool for agencies, ~40 people, raised a seed extension in September. Founder Karim posted last week that 'outbound isn't working anymore'. Job post for a 'Growth Marketer' (junior, broad remit — they don't know what they need yet). Homepage leads with features, not the problem."

Observation for the first line: "Saw your post on outbound and the Growth Marketer opening — usually when both show up together, the real gap is the plan above the hire, not the hire."
""".trim(),
        exercise = Exercise(
            "Pick one real company in your niche. Write its Tier 1 research note (stage signals, decision-maker, trigger) and the one observation you'd open with.",
            listOf("Real, specific research", "A genuine trigger", "Observation would make the founder reply", "Accuracy and plausibility"),
        ),
        sources = listOf("Aaron Ross — Predictable Revenue (targeting and outbound)"),
    ),

    Lesson("pip3", "Outbound founders answer", 6, """
Founders delete templates within a sentence. They answer notes that show you understood their situation and that cost them little to reply to.

The structure: observation → hypothesis → proof → small ask. Four to six sentences, written like a person.

- Observation: something specific and true about them (from your research).
- Hypothesis: what it suggests about their problem — framed as a guess, not a diagnosis.
- Proof: one line showing you've solved this before, ideally with a number.
- Ask: low commitment and easy to answer. "Worth a 20-minute look?" or even "Want me to send the three things I'd check first?"

Interest-based asks ("want me to send...?") often outperform meeting asks for cold founders, because saying yes costs nothing and starts a conversation.

Warm before cold: comment on their posts for a week before writing. Your name is then familiar.

Channel: LinkedIn DM and email both work; a short video (60 seconds, screen-recording their homepage) can stand out for Tier 1 accounts.

Never: open with "I hope this finds you well", talk about yourself first, attach a deck, or ask for "15 minutes to introduce my services".

Hormozi's core four apply to you too: warm outreach (people who know you), cold outreach, content, and paid. Start with warm — your network, ex-colleagues, past clients — before cold. It converts several times better and teaches you what resonates.
""".trim(),
        listOf(
            "Observation → hypothesis → proof → small ask, under six sentences.",
            "Start with warm outreach before cold.",
            "Prefer interest-based asks for cold founders.",
        ),
        listOf(
            QA("Structure of an outbound note?", "Observation, hypothesis, proof, small ask."),
            QA("Why interest-based asks?", "Saying yes costs nothing, so they start conversations more often."),
            QA("Hormozi's core four lead getters?", "Warm outreach, cold outreach, content, paid ads."),
            QA("Three outbound sins?", "Talking about yourself first, attaching a deck, asking for time to 'introduce services'."),
        ),
        example = """
"Hi Karim — saw your post that outbound stopped working, and the Growth Marketer role on your site.
When both show up together, the gap is usually the plan above the hire: nobody's decided which channel the next $1M comes from, so the new hire inherits the guesswork.
Last year I helped a fintech at a similar stage go from founder-only sales to 60% of pipeline from marketing in two quarters.
Want me to send the three things I'd look at before you hire?"
""".trim(),
        exercise = Exercise(
            "Write a first outbound note to a real founder in your niche using observation → hypothesis → proof → small ask. Under 90 words.",
            listOf("Specific, true observation", "Insightful hypothesis", "Credible proof", "Low-friction ask"),
        ),
        template = "outreach",
        sources = listOf("Alex Hormozi — \$100M Leads (warm and cold outreach)", "Aaron Ross — Predictable Revenue"),
    ),

    Lesson("pip9", "Follow-up and cadence", 4, """
Most replies don't come from the first message. Busy founders read, mean to reply, and forget. The follow-up isn't pestering; it's catching the moment they have time.

Plan four touches before sending the first:
1. Day 0 — the note.
2. Day 3 — add value, not "just bumping this": a short teardown point, a relevant number, a resource.
3. Day 7 — a new angle on the same problem, or a short question.
4. Day 14 — the polite close: "I'll assume the timing's off — if pipeline after founder-led sales becomes a priority, I'm easy to find." Close-outs often get the most replies.

Each touch must stand alone; never require them to read the previous ones.

Vary channels: a LinkedIn note, then an email, then a comment on their post.

After the sequence: no means not now. Put them in a nurture list — they keep seeing your content, and you check in when a new trigger appears (funding, a new hire, a public struggle). A lot of fractional work closes six months after the first contact.

Track replies by touch number. If almost all replies come from touch 1, your follow-ups are weak; if they come from touch 4, your first note is weak.
""".trim(),
        listOf(
            "Plan four touches over 14 days before sending the first.",
            "Every follow-up adds value and stands alone.",
            "Move non-replies to nurture and re-open on a new trigger.",
        ),
        listOf(
            QA("The four-touch cadence?", "Day 0 note, day 3 value-add, day 7 new angle, day 14 polite close."),
            QA("What makes a good follow-up?", "It adds value and stands alone."),
            QA("What does 'no reply' usually mean?", "Not now — nurture and re-open on a new trigger."),
        ),
        example = """
Day 3: "One thing I noticed on your pricing page: the demo button sits below three feature blocks. In most of the SaaS funnels I've audited, moving the primary CTA above the fold lifts demo requests by a meaningful margin. Free to steal."
Day 14: "I'll assume now isn't the time. If 'where does the next $1M of pipeline come from' lands on your desk this year, I'm one message away. Good luck with the launch."
""".trim(),
        exercise = Exercise(
            "Write touches 2, 3 and 4 that would follow your first note to the same founder.",
            listOf("Each adds new value", "Each stands alone", "Tone stays confident, not needy", "The close-out is graceful"),
        ),
        template = "outreach",
        sources = listOf("Aaron Ross — Predictable Revenue"),
    ),

    Lesson("pip10", "Referral and partner engine", 6, """
For most established fractional CMOs, referrals and partners bring in the majority of clients. Cold outreach gets you started; a referral engine keeps you full.

Three referral sources to build deliberately:
1. Clients. Ask at moments of win — not at the end. Be specific: "Who else do you know running a SaaS company that's stuck after founder-led sales?" Specific asks get names; vague ones get "I'll keep you in mind".
2. Other fractionals. Fractional CFOs, COOs, CTOs and heads of sales sit inside exactly the companies you want and see the marketing gap first. Build a small circle and refer to each other.
3. Capital and advisors. VCs and PE operating partners have portfolios full of companies at your stage. Offer them value first: a short workshop for their founders, office hours, a teardown session. One good partner can send several clients a year.

Agencies are also partners: many agencies need someone to own strategy above them. Position yourself as the person who makes their client relationships last longer, not a competitor.

Make referring easy. Give partners a one-line description of who you help and a short forwardable blurb. People refer when it makes them look good.

Close the loop: always tell the referrer what happened and thank them, whether it closed or not. Referrers who feel appreciated refer again.
""".trim(),
        listOf(
            "Ask clients for specific referrals at moments of win.",
            "Build a circle of other fractionals and VC/PE operating partners.",
            "Give partners a forwardable blurb and always close the loop.",
        ),
        listOf(
            QA("Three deliberate referral sources?", "Clients, other fractionals, capital and advisors (VCs, PE operating partners)."),
            QA("Why specific referral asks?", "Specific asks produce names; vague ones produce 'I'll keep you in mind'."),
            QA("How to win VC/PE partners?", "Offer value first: workshops, office hours, teardowns for their founders."),
        ),
        example = """
To a fractional CFO in your circle: "When you see a SaaS company where the board keeps asking why pipeline is flat and the founder is still the main closer — that's exactly my sweet spot. Here's a two-line blurb you can forward. And if I meet a company whose numbers are a mess before a raise, you're my first call."
""".trim(),
        exercise = Exercise(
            "Name three referral partners you could approach (types or real people), write the forwardable two-line blurb about you, and the first message to one partner.",
            listOf("Well-chosen partners", "Blurb is specific and forwardable", "Message offers value first", "Reciprocity built in"),
        ),
        sources = listOf("Alan Weiss — Million Dollar Consulting (referrals)", "David C. Baker — The Business of Expertise"),
    ),
))
