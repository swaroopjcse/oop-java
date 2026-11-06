package designprinciples.railseva.bad.lsp;

public class StandardTicket {
  protected double fare;
  protected boolean isCancelled = false;

  public StandardTicket(double fare) {
    this.fare = fare;
  }

  public double cancelAndCalculateRefund() {
    this.isCancelled = true;
    return this.fare * 0.80; // 80% refund after clerkage charge
  }
}