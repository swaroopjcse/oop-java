package ch07.book;

import java.time.Instant;
import java.util.Date;

/**
 * 
 * Represents an Employee in an organization.
 * 
 * <hr/>
 * Note: This example is adapted from Cay Horstmann's Object-Oriented Design and
 * Patterns.
 * Included here for educational demonstration purposes in accordance with
 * textbook guidelines.
 */
public class Employee implements Cloneable {
  private String name;
  private double salary;
  private Date hireDate;

  /**
   * Creates an Employee object with the given name and default salary.
   * 
   * @param name Name of the Employee
   */
  public Employee(String name) {
    this.name = name;
    this.salary = 50000;
    this.hireDate = Date.from(Instant.now());
  }

  /**
   * Sets this employee's salary to the given salary.
   * 
   * @param salary new salary (Pre: salary > getSalary())
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
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

  @Override
  public int hashCode() {
    return 11 * name.hashCode() + 13 * ((Double) salary).hashCode();
  }

  @Override
  public Employee clone() {
    try {
      Employee cloned = (Employee) super.clone();
      cloned.hireDate = (Date) hireDate.clone();
      return cloned;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "[name=" + getName() + ", salary=" + getSalary() + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass())
      return false; // standard opening till here
    return getName().equals(((Employee) obj).getName()); // class specific
  }
}