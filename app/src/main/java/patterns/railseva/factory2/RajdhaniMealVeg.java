package patterns.railseva.factory2;

public class RajdhaniMealVeg extends Meal {
  public RajdhaniMealVeg() {
    super("Paneer Biryani", "Basmati Rice, Paneer", 30);
    addItem("Raita");
    addItem("Gulab Jamun");
  }
}
