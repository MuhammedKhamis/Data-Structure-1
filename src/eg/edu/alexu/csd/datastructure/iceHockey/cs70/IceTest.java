package eg.edu.alexu.csd.datastructure.iceHockey.cs70;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Point;

import org.junit.Test;

/**
 * The Class IceTest.
 */

public class IceTest {

  /**
   * Test0.
   */
  @Test
  public void test0() {
    final int x5 = 5;
    final int x13 = 13;
    final int x2 = 2;
    final int x14 = 14;
    final int x4 = 4;
    final int x9 = 9;
    String[] image = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3",
        "VNDSD333", "OINFD33X"};
    Point[] answer = new Point[] {new Point(x4, x5), new Point(x13, x9),
        new Point(x14, x2)};
    final Integer team = 3;
    final Integer threashold = 16;
    Ice playersFinder = new Ice();
    Point[] result = playersFinder.findPlayers(image, team, threashold);
    assertArrayEquals(answer, result);
  }

  /**
   * Test1.
   */
  @Test
  public void test1() {
    final int x5 = 5;
    String[] image = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
    Point[] answer = new Point[] {new Point(x5, x5), new Point(x5, x5)};
    final Integer team = 1;
    final Integer threashold = 3;
    Ice playersFinder = new Ice();
    Point[] result = playersFinder.findPlayers(image, team, threashold);
    assertArrayEquals(answer, result);
  }

  /**
   * Test2.
   */
  @Test
  public void test2() {
    final int x1 = 1;
    final int x17 = 17;
    final int x3 = 3;
    final int x10 = 10;
    final int x25 = 25;
    final int x5 = 5;
    final int x21 = 21;
    final int x9 = 9;
    final int x2 = 2;
    final int x18 = 18;
    final int x28 = 28;
    final int x22 = 22;
    final int x20 = 20;
    final int x23 = 23;
    final int x26 = 26;
    final int x24 = 24;
    final int x15 = 15;
    final int x27 = 27;
    final int x16 = 16;
    final int x29 = 29;
    final int x11 = 11;
    final int x12 = 12;
    final int x8 = 8;

    String[] image = {"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO",
        "LUQ888A8TH8OIH8", "888QJ88R8SG88TY", "88ZQV88B88OUZ8O", "FQ88WF8Q8G"
        + "G88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8", "8S8A88MGVDG8XK8",
        "M" + "88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88",
        "U88H" + "8NI8CZB88B8", "8PK8H8T8888TQR8"};
    Point[] answer = new Point[] {new Point(x1, x17), new Point(x3, x3),
        new Point(x3, x10),
        new Point(x3, x25), new Point(x5, x21), new Point(x8, x17),
        new Point(x9, x2),
        new Point(x10, x9), new Point(x12, x23), new Point(x17, x16),
        new Point(x18, x3),
        new Point(x18, x11), new Point(x18, x28), new Point(x22, x20),
        new Point(x23, x26),
        new Point(x24, x15), new Point(x27, x2), new Point(x28, x26),
        new Point(x29, x16)};
    final Integer team = 8;
    final Integer threashold = 9;
    Ice playersFinder = new Ice();
    Point[] result = playersFinder.findPlayers(image, team, threashold);
    assertArrayEquals(answer, result);
  }

  /**
   * Test3.
   */
  @Test
  public void test3() {
    final int x3 = 3;
    final int x8 = 8;
    final int x4 = 4;
    final int x16 = 16;
    final int x5 = 5;
    final int x17 = 17;
    final int x9 = 9;
    String[] image = {"44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44",
        "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444",
        "4G4V4T4444"};
    Point[] answer = new Point[] {new Point(x3, x8), new Point(x4, x16),
        new Point(x5, x4),
        new Point(x16, x3), new Point(x16, x17), new Point(x17, x9)};
    final Integer team = 4;
    final Integer threashold = 16;
    Ice playersFinder = new Ice();
    Point[] result = playersFinder.findPlayers(image, team, threashold);
    assertArrayEquals(answer, result);
  }
}
