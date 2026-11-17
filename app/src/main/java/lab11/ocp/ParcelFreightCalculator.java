package lab11.ocp;

public class ParcelFreightCalculator {

  public double calculateShippingCharge(String vanCategory, double weightKg, double distanceKm) {
    if (weightKg <= 0 || distanceKm <= 0)
      throw new IllegalArgumentException("Weight and distance must be positive.");

    if ("SLR_GUARD_VAN".equalsIgnoreCase(vanCategory)) {
      return 50.0 + (weightKg * distanceKm * 0.04);
    } else if ("VPU_PARCEL_EXPRESS".equalsIgnoreCase(vanCategory)) {
      return 120.0 + (weightKg * distanceKm * 0.07);
    } else if ("REFRIGERATED_VAN".equalsIgnoreCase(vanCategory)) {
      double base = 250.0 + (weightKg * distanceKm * 0.12);
      return base * 1.15; // 15% cold-chain power surcharge
    } else {
      throw new IllegalArgumentException("Unknown parcel van category: " + vanCategory);
    }
  }

  public static void main(String[] args) {
    ParcelFreightCalculator calc = new ParcelFreightCalculator();
    System.out.println("SLR Freight: INR " + calc.calculateShippingCharge("SLR_GUARD_VAN", 40.0, 500.0));
    System.out.println("Cold Van Freight: INR " + calc.calculateShippingCharge("REFRIGERATED_VAN", 40.0, 500.0));
  }
}