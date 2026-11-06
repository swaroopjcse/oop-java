package designprinciples.railseva.good.dip;

// 3. Low-level adapter implementing the domain contract
public final class BsnlSmsAdapter implements NotificationChannel {
  @Override
  public void sendNotification(String destination, String message) {
    System.out.println("Dispatching via BSNL SMS Server to " + destination + ": " + message);
  }
}