package designprinciples.railseva.bad.isp;

// An online Web BookingEngine has no cash dispenser or physical printer!
public class OnlineBookingEngine implements BookingEngine {
  @Override
  public void processPayment() {
    System.out.println("Processing UPI Payment.");
  }

  @Override
  public void printPaperTicket() {
    // Violates ISP
    throw new UnsupportedOperationException("Cannot print a paper ticket");
  }

  @Override
  public void dispenseCashChange() {
    // Violates ISP
    throw new UnsupportedOperationException("Cannot dispense cash over HTTP");
  }
}