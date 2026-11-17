package lab11.isp;

public interface SmartStationTerminal {
  void printUnreservedTicket(String source, String destination);

  boolean validateQrPass(String qrPayload);

  void setCoachAirConditioning(int targetCelsius);

  void broadcastPlatformAnnouncement(String message);
}
