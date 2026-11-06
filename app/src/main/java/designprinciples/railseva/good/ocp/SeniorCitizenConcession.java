package designprinciples.railseva.good.ocp;

// Extension 1: Senior Citizen
public final class SeniorCitizenConcession implements ConcessionPolicy {
  @Override
  public double applyDiscount(double standardFare) {
    return standardFare * 0.60;
  }
}