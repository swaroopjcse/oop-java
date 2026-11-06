package designprinciples.railseva.bad.isp;

// Fat Interface forcing disparate hardware behaviors into one contract
public interface BookingEngine {
  void processPayment();

  void printPaperTicket();

  void dispenseCashChange();
}