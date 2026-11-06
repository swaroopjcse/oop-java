package designprinciples.railseva.good.ocp;

// Extension 3: Divyangjan Concession
public final class DivyangjanConcession implements ConcessionPolicy {
  @Override
  public double applyDiscount(double standardFare) {
    return standardFare * 0.25;
  }
}