package patterns.railseva.factory1;

public class NonVegMeal extends Meal {

  public NonVegMeal() {
    name = "Chicken Biryani";
    ingredients = "Basmati Rice, Chicken";
  }

  @Override
  public void cook() {
    System.out.println("Cooking: 30 min medium flame");
  }

}
