package polymorphism.day;

public class DaySimple implements Day {

  private int year, month, date;

  private static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  private static final int GREGORIAN_START_YEAR = 1582;
  private static final int GREGORIAN_START_MONTH = 10;
  private static final int GREGORIAN_START_DAY = 15;
  private static final int JULIAN_END_DAY = 4;

  private static final int JANUARY = 1;
  private static final int FEBRUARY = 2;
  private static final int DECEMBER = 12;

  /**
   * Constructs a Day object with the given parameters.
   * 
   * @param year  Year for this day
   * @param month Month for this day (Jan 1,.., Dec 12)
   * @param date  Date for this day (1..31)
   */
  public DaySimple(int year, int month, int date) {
    this.year = year;
    this.month = month;
    this.date = date;
  }

  @Override
  public int getYear() {
    return this.year;
  }

  @Override
  public int getMonth() {
    return this.month;
  }

  @Override
  public int getDate() {
    return this.date;
  }

  @Override
  public int daysFrom(Day other) {
    int n = 0;
    DaySimple d = this;
    while (d.compareTo(other) > 0) {
      d = d.previousDay();
      n--;
    }
    while (d.compareTo(other) < 0) {
      d = d.nextDay();
      n++;
    }
    return n;
  }

  @Override
  public Day plusDays(int n) {
    DaySimple result = this;
    while (n > 0) {
      result = result.nextDay();
      n--;
    }
    while (n < 0) {
      result = result.previousDay();
      n++;
    }
    return result;
  }

  /**
   * Computes the next day.
   * 
   * @return the day following this day
   */
  private DaySimple nextDay() {
    int y = year;
    int m = month;
    int d = date;

    if (y == GREGORIAN_START_YEAR
        && m == GREGORIAN_START_MONTH
        && d == JULIAN_END_DAY)
      d = GREGORIAN_START_DAY;
    else if (d < daysPerMonth(y, m))
      d++;
    else {
      d = 1;
      m++;
      if (m > DECEMBER) {
        m = JANUARY;
        y++;
        if (y == 0)
          y++;
      }
    }
    return new DaySimple(y, m, d);
  }

  /**
   * Computes the previous day.
   * 
   * @return the day preceding this day
   */
  private DaySimple previousDay() {
    int y = year;
    int m = month;
    int d = date;

    if (y == GREGORIAN_START_YEAR
        && m == GREGORIAN_START_MONTH
        && d == GREGORIAN_START_DAY)
      d = JULIAN_END_DAY;
    else if (d > 1)
      d--;
    else {
      m--;
      if (m < JANUARY) {
        m = DECEMBER;
        y--;
        if (y == 0)
          y--;
      }
      d = daysPerMonth(y, m);
    }
    return new DaySimple(y, m, d);
  }

  /**
   * Gets the days in a given month
   * 
   * @param y the year
   * @param m the month
   * @return the last day in the given month
   */
  private static int daysPerMonth(int y, int m) {
    int days = DAYS_PER_MONTH[m - 1];
    if (m == FEBRUARY && isLeapYear(y))
      days++;
    return days;
  }

  /**
   * Tests if a year is a leap year
   * 
   * @param y the year
   * @return true if y is a leap year
   */
  private static boolean isLeapYear(int y) {
    if (y % 4 != 0)
      return false;
    if (y < GREGORIAN_START_YEAR)
      return true;
    return (y % 100 != 0) || (y % 400 == 0);
  }
}
