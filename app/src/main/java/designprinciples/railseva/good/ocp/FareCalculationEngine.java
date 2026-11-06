package designprinciples.railseva.good.ocp;

// Closed for modification, open for extension via polymorphism
public final class FareCalculationEngine {
  public double calculatePayableFare(double baseFare, ConcessionPolicy concession) {
    return concession.applyDiscount(baseFare);
  }
}