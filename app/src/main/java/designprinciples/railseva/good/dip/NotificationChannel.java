package designprinciples.railseva.good.dip;

// 1. High-level abstraction defined by domain needs
public interface NotificationChannel {
  void sendNotification(String destination, String message);
}