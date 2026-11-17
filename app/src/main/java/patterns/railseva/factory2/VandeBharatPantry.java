package patterns.railseva.factory2;

public class VandeBharatPantry extends TrainPantry {

  @Override
  protected Meal createMeal(String diet) {
    if (diet.equals("VEG"))
      return new VandeBharatMealVeg();
    else if (diet.equals("NONVEG"))
      return new VandeBharatMealNonVeg();
    throw new IllegalArgumentException();
  }

}
