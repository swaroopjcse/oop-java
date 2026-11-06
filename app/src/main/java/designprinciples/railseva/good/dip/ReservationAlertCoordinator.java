package designprinciples.railseva.good.dip;

import java.util.Objects;

// 2. High-level business coordinator depending exclusively on abstraction
public final class ReservationAlertCoordinator {
  private final NotificationChannel notificationChannel;

  // The caller of this module can inject BsnlSmsAdapter or WhatsAppAdapter or a completely new implementation in the future
  public ReservationAlertCoordinator(NotificationChannel notificationChannel) {
    this.notificationChannel = Objects.requireNonNull(notificationChannel);
  }

  public void alertPassenger(String pnr, String mobile) {
    notificationChannel.sendNotification(mobile, "PNR " + pnr + " is confirmed.");
  }
}