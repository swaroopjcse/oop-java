package patterns.railseva.factory2;

public class RajdhaniPantry extends TrainPantry {

  @Override
  protected Meal createMeal(String diet) {
    if (diet.equals("VEG"))
      return new RajdhaniMealVeg();
    else if (diet.equals("NONVEG"))
      return new RajdhaniMealNonVeg();
    throw new IllegalArgumentException();
  }

}
