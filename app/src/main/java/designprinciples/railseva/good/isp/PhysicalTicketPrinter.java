package designprinciples.railseva.good.isp;

// Role-Specific Interfaces
public interface PhysicalTicketPrinter {
  void printPaperTicket(String pnrDetails);
}