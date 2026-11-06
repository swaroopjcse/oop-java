package designprinciples.railseva.good.isp;

// Role-Specific Interfaces
public interface OnlinePaymentProcessor {
  void processDigitalPayment();
}