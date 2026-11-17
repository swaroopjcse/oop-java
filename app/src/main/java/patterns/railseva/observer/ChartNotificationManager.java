package patterns.railseva.observer;

import java.util.ArrayList;
import java.util.List;

public class ChartNotificationManager implements Subject {
  private List<ChartObserver> observers = new ArrayList<>();
  private Chart chart;

  public void register(ChartObserver observer) {
    observers.add(observer);
  }

  public void unregister(ChartObserver observer) {
    observers.remove(observer);
  }

  public void notifyAllObservers() {
    for (ChartObserver ob : observers) {
      ob.onChartUpdate(chart);
    }
  }

}
