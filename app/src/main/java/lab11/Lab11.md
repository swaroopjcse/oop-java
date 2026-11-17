# Lab 11: Software Design Principles

- This lab provides an opportunity to practice refactoring rotting code to apply the SOLID principles.
- It continues a version of the *RailSeva* app discussed in class.
- Each exercise below presents a **compilable, functionally working** class or subsystem that suffers from structural "code rot" (rigidity, fragility, immobility, or viscosity).
- For each task, analyze the code using the reflection prompts, and identify the violated design principle.
- Refactor the code into clean, testable Java without changing its external functional behavior, into a new package named `lab11.<principle>.refactored` where `<principle>` is one of `srp`, `ocp`, `lsp`, `isp`, or `dip`.
- Refer to the [Software Design Principles](https://docs.google.com/presentation/d/1Dz4lV6edjYMvvgHOBEpWH6vOyPQ3f_P0ZXhox6glNTc/edit?usp=sharing) slides from class.

## Exercise 1: The Monolithic Pantry Order Processor

1. Correctly Functioning but Rotting Code is given in the `lab11.srp` package.
2. Principle to Apply (SRP): Separate domain pricing rules, storage persistence, and passenger notification delivery into independent, single-purpose classes.
3. Questions to consider:
   - Identify the three distinct stakeholders (business actors) who could request a change to `CateringOrderProcessor` over the next six months.
   - If the Ministry of Railways revises the catering GST rate from 5% to 12%, why is it risky that the same file also manages File writing operations?
   - If RailSeva migrates from SMS to WhatsApp notifications, which lines of code must be modified, and what regression risk does this introduce to the billing logic?

### Exercise 2: The Rigid Parcel Freight Calculator

1. Correctly Functioning but Rotting Code is given in the `lab11.ocp` package.
2. Principle to Apply (OCP): Replace the string-based conditional ladder with a polymorphic `FreightRatePolicy` abstraction so new parcel categories can be added without modifying `ParcelFreightCalculator`.
3. Questions to consider:
   - Suppose Indian Railways launches a new "Kisan Rail Agro-Express" tariff next quarter. Which exact lines of `ParcelFreightCalculator` must be edited, and what regression risk does this introduce to existing `SLR_GUARD_VAN` calculations?
   - What type of coupling (from the coupling spectrum) is created when a caller passes a `String vanCategory` flag to dictate internal branching?
   - How can you design an abstraction so that `ParcelFreightCalculator` contains zero `if-else` branches for van categories?

### Exercise 3: The Exploding Unreserved Coach Subclass

1. Correctly Functioning but Rotting Code is given in the `lab11.lsp` package.
2. Principle to Apply (LSP): Restructure the inheritance hierarchy so that `GeneralUnreservedCoach` does not inherit an unsupported `assignBerth` contract from `PassengerCoach`.
3. Questions to consider:
   - What is `Map` and `HashMap` in Java Collections Framework, and why is it used in `PassengerCoach`?
   - Look at `GeneralUnreservedCoach.assignBerth(...)`. If a boarding controller holds a reference of type `PassengerCoach` and calls `coach.assignBerth(1, "Ravi")`, what happens at runtime?
   - Which Design by Contract rule (preconditions, postconditions, or invariants) is violated when a subclass throws `UnsupportedOperationException` for an inherited public method?
   - What is the true shared abstraction between a Sleeper Coach and a General Unreserved Coach?

### Exercise 4: The Bloated Station Smart-Device Interface

1. Correctly Functioning but Rotting Code is given in the `lab11.isp` package.
2. Principle to Apply (ISP): Split the monolithic `SmartStationTerminal` interface into cohesive, role-specific capability interfaces so hardware devices implement only the contracts they actually support.
3. Questions to consider:
   - Why is forcing `PlatformTicketVendingMachine` to implement `setCoachAirConditioning` an architectural hazard even if the method is never called in `main()`?
   - If the Railway Engineering team changes the signature of `broadcastPlatformAnnouncement` to accept a language code (`String langCode, String message`), why must `PlatformTicketVendingMachine` be modified and recompiled?
   - How many focused interfaces should replace `SmartStationTerminal` so that both an ATVM kiosk and a Train Guard Console can compose only what they need?

### Exercise 5: The Hardcoded Nodal Bank Refund Service

1. Correctly Functioning but Rotting Code is given in the `lab11.dip` package.
2. Principle to Apply (DIP): Define a domain-owned `RefundPayoutGateway` abstraction, inject it into `TicketRefundService` via constructor injection, and have `SbiNodalNeftGateway` implement that interface.
3. Questions to consider:
   - Look at the dependency arrow between `TicketRefundService` (high-level business policy) and `SbiNodalNeftGateway` (low-level banking driver). Which class currently imports and instantiates the other?
   - Suppose you want to write an automated JUnit 5 test verifying that `isTatkal = false` calculates an exact 85% refund. What happens when your test instantiates `new TicketRefundService()`?
   - If RailSeva migrates its nodal settlement bank from SBI to HDFC or RBI e-Rupi next year, how can we ensure `TicketRefundService` does not require a single line of modification?
