package patterns.railseva.factory1;

public class SimpleMealFactory {
  Meal createMeal(String diet) {
    Meal m = null;
    if (diet.equals("VEG"))
      m = new VegMeal();
    else if (diet.equals("NONVEG"))
      m = new NonVegMeal();
    else
      throw new IllegalArgumentException("diet must be VEG or NONVEG");
    return m;
  }
}
