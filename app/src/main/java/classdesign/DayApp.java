package classdesign;

public class DayApp {
  public static void main(String[] args) {
    Day today = new Day(2026, 9, 3);

    Day diwali = new Day(2026, 11, 8);

    System.out.println("Diwali is after " + today.daysFrom(diwali) + " days");
  }
}
