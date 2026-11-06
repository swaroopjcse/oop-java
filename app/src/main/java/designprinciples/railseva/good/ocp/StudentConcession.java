package designprinciples.railseva.good.ocp;

// Extension 2: Student
public final class StudentConcession implements ConcessionPolicy {
  @Override
  public double applyDiscount(double standardFare) {
    return standardFare * 0.50;
  }
}