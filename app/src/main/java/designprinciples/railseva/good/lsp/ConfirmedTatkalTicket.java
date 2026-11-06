package designprinciples.railseva.good.lsp;

// Tatkal ticket implements TrainTicket, but not RefundableTicket
public final class ConfirmedTatkalTicket implements TrainTicket {
  private final String pnr;
  private final double fare;

  public ConfirmedTatkalTicket(String pnr, double fare) {
    this.pnr = pnr;
    this.fare = fare;
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