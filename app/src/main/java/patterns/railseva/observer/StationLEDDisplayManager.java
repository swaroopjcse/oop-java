package patterns.railseva.observer;

public class StationLEDDisplayManager implements ChartObserver {

  public void onChartUpdate(Chart ch) {
    System.out.println("Updating all LED Displays...");
  }

}
