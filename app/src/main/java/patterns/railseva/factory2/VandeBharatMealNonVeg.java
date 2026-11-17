package patterns.railseva.factory2;

public class VandeBharatMealNonVeg extends Meal {
  public VandeBharatMealNonVeg() {
    super("Chicken Fried Rice", "Rice, Chicken", 35);
    addItem("Chicken Manchurian Soup");
    addItem("Chocolate Cake");
  }
}