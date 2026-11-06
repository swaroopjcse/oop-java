package designprinciples.railseva.good.ocp;

// Strategy Interface: The Extension Point
public interface ConcessionPolicy {
  double applyDiscount(double standardFare);
}