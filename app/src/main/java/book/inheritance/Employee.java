package book.inheritance;

/**
 * 
 * Represents an Employee in an organization.
 * 
 * <hr/>
 * Note: This example is adapted from Cay Horstmann's Object-Oriented Design and Patterns.
 * Included here for educational demonstration purposes in accordance with textbook guidelines.
 */
public class Employee {
  private String name;
  private double salary;

  /**
   * Creates an Employee object with the given name and default salary.
   * 
   * @param name Name of the Employee
   */
  public Employee(String name) {
    this.name = name;
    this.salary = 50000;
  }

  /**
   * Sets this employee's salary to the given salary.
   * 
   * @param salary new salary (Pre: salary > getSalary())
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }

  /**
   * Returns the name of this employee.
   * 
   * @return Name of this employee
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the salary of this employee.
   * 
   * @return Salary of this employee
   */
  public double getSalary() {
    return salary;
  }
}