package classdesign;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DayTest {

  @Test
  void test() {
    assertEquals(2, 1+1);
  }

  @Test
  public void testGetYear(){
    Day d = new Day(2026,9,3); // today's date
    assertEquals(2026, d.getYear());
  }

  @Test
  public void daysFrom20260903_20260907_is_4() {
    Day d = new Day(2026, 9, 3);
    Day other = new Day(2026, 9, 7);

    int ans = d.daysFrom(other);

    assertEquals(4, ans);
  }


  @Test
  public void daysFrom20080228_20080301_is_2() {
    Day d = new Day(2008, 2, 28);
    Day other = new Day(2008, 3, 1);

    int ans = d.daysFrom(other);

    assertEquals(2, ans);
  }


  @Test
  public void daysFrom20260903_20260801_is_Neg33() {
    Day d = new Day(2026, 9, 3);
    Day other = new Day(2026, 8, 1);

    int ans = d.daysFrom(other);

    assertEquals(-33, ans);
  }


  @Test
  public void daysFrom20260903_20260903_is_0() {
    Day d = new Day(2026, 9, 3);
    Day other = new Day(2026, 9, 3);

    int ans = d.daysFrom(other);

    assertEquals(0, ans);
  }

}
