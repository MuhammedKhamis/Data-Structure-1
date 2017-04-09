package eg.edu.alexu.csd.datastructure.iceHockey.cs70;

import java.awt.Point;

/**
 * The Class Test.
 */
public class Test {

  /**
   * The main method.
   * @param args
   *          the arguments.
   */
  public static void main(final String[] args) {

    String[] image = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
    final Integer team = 1;
    final Integer threashold = 3;
    Ice playersFinder = new Ice();
    Point[] result = playersFinder.findPlayers(image, team, threashold);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i].x + "," + result[i].y);
    }
  }
}
