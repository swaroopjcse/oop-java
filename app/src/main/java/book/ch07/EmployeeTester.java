package book.ch07;

public class EmployeeTester {
  public static void main(String[] args) {
    Employee e1 = new Employee("Ajay");
    System.out.println(e1);

    System.out.println("\nAliasing\n");
    Employee e2 = e1;
    e2.setSalary(70000);
    System.out.println(e1);
    System.out.println(e2);

    System.out.println("\nCloning\n");
    Employee e3 = e1.clone();
    e3.setSalary(80000);
    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e3);
  }
}