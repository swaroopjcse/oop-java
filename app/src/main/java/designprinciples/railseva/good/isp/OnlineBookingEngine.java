package designprinciples.railseva.good.isp;

// Web portal implements ONLY digital payment capabilities
public final class OnlineBookingEngine implements OnlinePaymentProcessor {
  @Override
  public void processDigitalPayment() {
    System.out.println("Processing net banking / UPI payment");
  }
}