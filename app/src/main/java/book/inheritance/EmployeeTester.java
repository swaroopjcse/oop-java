package book.inheritance;

public class EmployeeTester {
  public static void main(String[] args) {
    Employee e = new Employee("Ajay");
    Manager m = new Manager("Vijay");

    System.out.println(e.getName() + " - " + e.getSalary());
    System.out.println(m.getName() + " - " + m.getSalary());

    Employee m2 = new Manager("Sanjay");
    System.out.println(m2.getName() + " - " + m2.getSalary());

    // m2.setBonus(20000); // Syntax error!
  }
}