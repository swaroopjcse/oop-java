package lab11.isp;

public class PlatformTicketVendingMachine implements SmartStationTerminal {

  @Override
  public void printUnreservedTicket(String source, String destination) {
    System.out.println("Printing UTS Ticket: " + source + " -> " + destination);
  }

  @Override
  public boolean validateQrPass(String qrPayload) {
    return qrPayload != null && qrPayload.startsWith("UTS-QR-");
  }

  @Override
  public void setCoachAirConditioning(int targetCelsius) {
    throw new UnsupportedOperationException("ATVM kiosk cannot control train AC");
  }

  @Override
  public void broadcastPlatformAnnouncement(String message) {
    throw new UnsupportedOperationException("ATVM kiosk has no PA speaker system");
  }

  public static void main(String[] args) {
    SmartStationTerminal atvm = new PlatformTicketVendingMachine();
    atvm.printUnreservedTicket("CSMT", "Dadar");
    System.out.println("QR Valid: " + atvm.validateQrPass("UTS-QR-9921"));
  }
}