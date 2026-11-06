package designprinciples.railseva.bad.srp;

// Violates SRP: Changes to fare slabs, SQL schemas, or SMS formats all mutate this file
public class TrainTicket {
  private final String pnr;
  private final double distanceKm;

  public TrainTicket(String pnr, double distanceKm) {
    this.pnr = pnr;
    this.distanceKm = distanceKm;
  }

  // Reason to change 1: Ministry of Railways tariff slab revision
  public double calculateFare() {
    return 50.0 + (distanceKm * 1.25);
  }

  // Reason to change 2: Database migration from Oracle to PostgreSQL
  public void persistToDatabase() {
    System.out.println("Executing INSERT INTO irctc_tickets VALUES ('" + pnr + "')");
  }

  // Reason to change 3: Regulatory requirement to use WhatsApp instead of SMS
  public void sendDispatchAlert(String mobileNo) {
    System.out.println("Sending SMS to " + mobileNo + ": Ticket booked for PNR " + pnr);
  }
}