package designprinciples.railseva.bad.lsp;

// Violates LSP: Tatkal tickets cannot be refunded once the chart is prepared!
public class ConfirmedTatkalTicket extends StandardTicket {
  public ConfirmedTatkalTicket(double fare) {
    super(fare);
  }

  @Override
  public double cancelAndCalculateRefund() {
    // Severe LSP Violation: Breaks base class behavioral expectations at runtime
    throw new UnsupportedOperationException("Confirmed Tatkal tickets are strictly non-refundable!");
  }
}