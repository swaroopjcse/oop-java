package designprinciples.railseva.good.srp;

// 2. Commercial Tariff Policy: Changes ONLY when fare regulations change
public final class DistanceFareCalculator {
    private static final double BASE_RATE_PER_KM = 1.25;
    private static final double MINIMUM_FARE = 50.0;

    public double computeBaseFare(double distanceKm) {
        return Math.max(MINIMUM_FARE, distanceKm * BASE_RATE_PER_KM);
    }
}