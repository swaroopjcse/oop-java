package patterns.railseva.observer;

public class TTEDesk implements ChartObserver {

  public void onChartUpdate(Chart ch) {
    System.out.println("Printing the chart for the TTEs of this train...");
  }

}
