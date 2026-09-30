package book.inheritance;

/**
 * Represents a Manager in an organization.
 * 
 * <hr/>
 * Note: This example is adapted from Cay Horstmann's Object-Oriented Design and Patterns.
 * Included here for educational demonstration purposes in accordance with textbook guidelines.
 */
public class Manager extends Employee {
  private double bonus;

  public Manager(String name) {
    super(name);
    this.bonus = 10000;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  @Override
  public double getSalary() {
    return bonus + super.getSalary();
  }
}
