package patterns.railseva.factory1;

public class TrainPantry {
  private SimpleMealFactory factory;

  public TrainPantry(SimpleMealFactory factory) {
    this.factory = factory;
  }

  public Meal orderMeal(String diet) {
    Meal m = null;

    m = factory.createMeal(diet);

    m.prepare();
    m.cook();
    m.pack();

    return m;
  }
}
