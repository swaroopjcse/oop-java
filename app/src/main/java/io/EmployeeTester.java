package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTester {
  public static void main(String[] args) {
    List<Employee> staff = new ArrayList<>();
    
    Employee e = new Employee("Ajay");
    Manager m = new Manager("Vijay");
    staff.add(e);
    staff.add(m);
    
    System.out.println("\nText file IO\n");
    System.out.println(staff.toString());
    writeToText(staff, "staff.csv");
    List<Employee> myStaff = readFromText("staff.csv");
    System.out.println(myStaff);

    System.out.println("\nObj file IO\n");

    System.out.println(staff.toString());
    writeObjToFile(staff, "staff.dat");
    List<Employee> myStaff2 = readObjFromFile("staff.dat");
    System.out.println(myStaff2);
  }

  private static List<Employee> readFromText(String filename) {
    List<Employee> result = new ArrayList<>();

    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String line = null;
      int count = 0;
      while ((line = in.readLine()) != null) {
        if (count++ == 0)
          continue;
        String[] parts = line.split(",");

        Employee e = new Employee(parts[1]);
        e.setSalary(Double.parseDouble(parts[2]));

        result.add(e);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  private static void writeObjToFile(List<Employee> staff, String filename) {
    try (OutputStream fs = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fs)) {
      out.writeObject(staff);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static List<Employee> readObjFromFile(String filename) {
    List<Employee> result = null;
    try (FileInputStream fs = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fs)) {
      result = (List<Employee>) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static void writeToText(List<Employee> staff, String filename) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(filename));
      out.write("# Sr, Name, Salary\n");

      int count = 1;
      for (Employee e : staff) {
        StringBuilder sb = new StringBuilder();
        sb.append(count++).append(",")
            .append(e.getName()).append(",")
            .append(e.getSalary()).append("\n");

        out.write(sb.toString());
      }
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}