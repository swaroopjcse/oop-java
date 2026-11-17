package patterns.railseva.factory1;

public class TrainPantryTester {
  public static void main(String[] args) {
    SimpleMealFactory f = new SimpleMealFactory();
    TrainPantry t = new TrainPantry(f);

    t.orderMeal("NONVEG");

    t.orderMeal("VEG");
  }
}
