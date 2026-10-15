package polymorphism.day;

public interface Day extends Comparable<Day> {
  /**
   * Returns the year of the day represented in this object.
   * 
   * @return gregorian year
   */
  public int getYear();

  /**
   * Returns the month of the day represented in this object.
   * 
   * @return month of the year
   */
  public int getMonth();

  /**
   * Returns the date of the month represented in this object.
   * 
   * @return date of the month
   */
  public int getDate();

  /**
   * Returns the number of days the other day is from this day.
   * 
   * @param other the other day
   * @return the number of days that other day is away from
   *         this (negative if other comes before this)
   */
  public int daysFrom(Day other);

  /**
   * Returns a day that is a certain number of days away from this day.
   * 
   * @param n the number of days, can be negative
   * @return a day that is n days away from this one
   */
  public Day plusDays(int n);

  @Override
  default public int compareTo(Day other) {
    if (this.getYear() > other.getYear())
      return 1;
    if (this.getYear() < other.getYear())
      return -1;
    if (this.getMonth() > other.getMonth())
      return 1;
    if (this.getMonth() < other.getMonth())
      return -1;
    return this.getDate() - other.getDate();
  }
}
