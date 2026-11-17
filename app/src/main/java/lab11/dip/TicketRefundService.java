package lab11.dip;

// High-level domain policy tightly coupled to low-level concrete bank API
public class TicketRefundService {
  private final SbiNodalNeftGateway bankGateway;

  public TicketRefundService() {
    // Direct instantiation creates rigid compile-time & runtime coupling
    this.bankGateway = new SbiNodalNeftGateway();
  }

  public double processCancellationRefund(String pnr, String passengerBankAccount, double ticketFare,
      boolean isTatkal) {
    if (isTatkal) {
      System.out.println("PNR " + pnr + ": Confirmed Tatkal tickets are non-refundable.");
      return 0.0;
    }
    double refundAmount = ticketFare * 0.85; // 15% cancellation fee
    bankGateway.executeNeftPayout(passengerBankAccount, refundAmount);
    return refundAmount;
  }

  public static void main(String[] args) {
    TicketRefundService service = new TicketRefundService();
    service.processCancellationRefund("PNR774120", "SBIN0001234-998877", 1500.0, false);
  }
}
