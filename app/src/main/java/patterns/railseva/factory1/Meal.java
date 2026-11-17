package patterns.railseva.factory1;

public abstract class Meal {
  protected String name;
  protected String ingredients;

  public String getName() {
    return name;
  }

  public void prepare() {
    System.out.println("\n=== " + name + " ===\n");
    System.out.println("Preparing: " + ingredients);
  }

  public abstract void cook();

  public void pack() {
    System.out.println("Packing in a bio-degradable container.");
  }
}
