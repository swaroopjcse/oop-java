package patterns.railseva.factory2;

public abstract class TrainPantry {

  public Meal orderMeal(String diet) {
    Meal m = createMeal(diet);

    m.prepare();
    m.cook();
    m.pack();

    return m;
  }

  protected abstract Meal createMeal(String diet);
}
