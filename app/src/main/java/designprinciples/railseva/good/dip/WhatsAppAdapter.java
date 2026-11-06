package designprinciples.railseva.good.dip;

// 3. Low-level adapter implementing the domain contract
public final class WhatsAppAdapter implements NotificationChannel {
  @Override
  public void sendNotification(String destination, String message) {
    System.out.println("Dispatching via WhatsApp to " + destination + ": " + message);
  }
}