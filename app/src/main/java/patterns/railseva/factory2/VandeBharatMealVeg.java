package patterns.railseva.factory2;

public class VandeBharatMealVeg extends Meal {
  public VandeBharatMealVeg() {
    super("Veg Fried Rice", "Rice, Veggies", 30);
    addItem("Veg Clear Soup");
    addItem("Ice Cream Cup");
  }
}
