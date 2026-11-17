package patterns.railseva.observer;

public interface Subject {

  public void register(ChartObserver observer);

  public void unregister(ChartObserver observer);

  public void notifyAllObservers();
}
