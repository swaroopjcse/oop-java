package patterns.railseva.factory1;

public class VegMeal extends Meal {

  public VegMeal() {
    name = "Paneer Biryani";
    ingredients = "Basmati Rice, Paneer";
  }

  @Override
  public void cook() {
    System.out.println("Cooking: 30 min medium flame");
  }

}
