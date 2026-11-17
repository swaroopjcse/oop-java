package patterns.railseva.observer;

public class SMSNotificationManager implements ChartObserver {

  public void onChartUpdate(Chart ch) {
    System.out.println("Sending SMS to all passengers on the chart...");
  }

}
