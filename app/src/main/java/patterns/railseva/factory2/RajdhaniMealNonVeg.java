package patterns.railseva.factory2;

public class RajdhaniMealNonVeg extends Meal {
  public RajdhaniMealNonVeg() {
    super("Chicken Biryani", "Basmati Rice, Chicken", 40);
    addItem("Gravy");
    addItem("Gulab Jamun");
  }
}