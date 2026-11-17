package patterns.railseva.factory2;

public class TrainPantryTester {
  public static void main(String[] args) {
    TrainPantry rp = new RajdhaniPantry();
    rp.orderMeal("NONVEG");

    TrainPantry vbp = new VandeBharatPantry();
    vbp.orderMeal("VEG");
  }
}
