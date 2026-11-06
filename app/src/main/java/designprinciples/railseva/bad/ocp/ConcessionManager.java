package designprinciples.railseva.bad.ocp;

public class ConcessionManager {
  // Violates OCP: Adding a new concession requires editing this method and
  // re-testing all cases
  public double applyConcession(ConcessionCategory category, double standardFare) {
    if (category == ConcessionCategory.SENIOR_CITIZEN) {
      return standardFare * 0.60; // 40% discount
    } else if (category == ConcessionCategory.STUDENT) {
      return standardFare * 0.50; // 50% discount
    } else if (category == ConcessionCategory.DIVYANGJAN) {
      return standardFare * 0.25; // 75% discount
    } else {
      return standardFare; // Full fare
    }
  }
}