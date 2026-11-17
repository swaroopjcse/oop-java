package patterns.railseva.factory2;

import java.util.ArrayList;
import java.util.List;

public abstract class Meal {
  private String name;
  private String ingredients;
  private int cookTime;
  private List<String> otherItems;

  public Meal(String name, String ingredients, int cookTime) {
    this.name = name;
    this.ingredients = ingredients;
    this.cookTime = cookTime;
    otherItems = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void addItem(String item) {
    otherItems.add(item);
  }

  public void prepare() {
    System.out.println("\n=== " + name + " ===\n");
    System.out.println("Preparing: " + ingredients);
  }

  public void cook() {
    System.out.println("Cooking for " + cookTime + " minutes");
  }

  public void pack() {
    System.out.println("Adding: " + otherItems);
    System.out.println("Packing in a bio-degradable container.");
  }
}
