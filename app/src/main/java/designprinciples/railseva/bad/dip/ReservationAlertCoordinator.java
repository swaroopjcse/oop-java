package designprinciples.railseva.bad.dip;

// High-level domain service directly coupled to concrete vendor driver
public class ReservationAlertCoordinator {
  private final BsnlSmsGatewayDriver bsnlDriver;

  public ReservationAlertCoordinator() {
    // Changing the service provider requires changing this high-level class
    this.bsnlDriver = new BsnlSmsGatewayDriver();
  }

  public void alertPassenger(String pnr, String mobile) {
    bsnlDriver.sendSms(mobile, "PNR " + pnr + " is confirmed.");
  }
}