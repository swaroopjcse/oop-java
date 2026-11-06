package designprinciples.railseva.good.isp;

// Station counter implements Cash Processing and Ticket Printing capabilities
public final class StationCounterBookingEngine implements CashPaymentProcessor, PhysicalTicketPrinter {
  @Override
  public double processCashPayment() {
    System.out.println("Take cash and return the change.");
    return 0; // placeholder
  }

  @Override
  public void printPaperTicket(String pnrDetails) {
    System.out.println("Printing ticket: " + pnrDetails);
  }
}