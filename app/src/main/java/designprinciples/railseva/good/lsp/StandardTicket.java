package designprinciples.railseva.good.lsp;

// Standard ticket fulfills RefundableTicket
public final class StandardTicket implements CancellableTrainTicket {
  private final String pnr;
  private final double fare;

  public StandardTicket(String pnr, double fare) {
    this.pnr = pnr;
    this.fare = fare;
  }

  @Override
  public double processCancellation() {
    return fare * 0.80;
  }

  @Override
  public String getPnr() {
    return pnr;
  }

  @Override
  public double getFarePaid() {
    return fare;
  }
}