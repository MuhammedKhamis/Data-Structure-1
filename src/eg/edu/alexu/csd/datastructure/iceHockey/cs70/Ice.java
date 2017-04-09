package eg.edu.alexu.csd.datastructure.iceHockey.cs70;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

import java.awt.Point;

/**
 * The Class Ice.
 */
public class Ice implements IPlayersFinder {

  /** The visited. */
  // help variables
  boolean[][] visited;
  /** The digit. */
  int digit;
  /** The squares. */
  int sq;
  /** The up. */
  int up;
  /** The right. */
  int right;
  /** The left. */
  int left;
  /** The down. */
  int down;
  /** The x50. */
  final int x50 = 50;
  /** The x4. */
  final int x4 = 4;
  /** The x1. */
  final int x1 = 1;

  /**
   * Search for players locations at the given photo.
   * @param photo
   *          Two dimension array of photo contents Will contain
   *          between 1 and 50 elements inclusive.
   * @param team
   *          Identifier of the team.
   * @param threshold
   *          Minimum area for an element Will be between 1 and 10000,
   *          inclusive.
   * @return Array of players locations of the given team.
   */
  public java.awt.Point[] findPlayers(final String[] photo, final int team,
      final int threshold) {
    // main function
    if (photo == null || photo.length == 0) {
      return new Point[] {};
    }
    digit = team;
    visited = new boolean[photo.length][photo[0].length()];
    Point[] places = new Point[x50];
    int key = 0;
    for (int i = 0; i < photo.length; i++) {
      for (int j = 0; j < photo[i].length(); j++) {
        up = i;
        down = i;
        right = j;
        left = j;
        if (Character.isDigit(photo[i].charAt(j))) {
          if (Character.getNumericValue(photo[i].charAt(j)) == digit) {
            sq = 0;
            searcharound(photo, i, j);
            if (sq * x4 >= threshold && sq > 0) {
              down = x1 + down;
              right = x1 + right;
              places[key] = new Point(right + left, up + down);
              key++;
            }
          }
        }
      }
    }
    Point[] placesHold = new Point[key];
    for (int i = 0; i < key; i++) {
      placesHold[i] = places[i];
    }
    sort(placesHold);
    return placesHold;
  }

  /**
   * Search around.
   * @param photo
   *          the photo.
   * @param i0
   *          the i0.
   * @param j0
   *          the j0.
   */
  public void searcharound(final String[] photo, final int i0, final int j0) {
    // searching function ^_^
    if (i0 >= 0 && j0 >= 0 && i0 != photo.length && j0 != photo[0].length()) {
      if (Character.isDigit(photo[i0].charAt(j0))) {
        if (Character.getNumericValue(photo[i0].charAt(j0)) == digit) {
          if (!visited[i0][j0]) {
            sq++;
            visited[i0][j0] = true;
            if (i0 + 1 <= photo.length) {
              if (down < i0) {
                down = i0;
              }
              searcharound(photo, i0 + 1, j0);
            }
            if (i0 > -1) {
              searcharound(photo, i0 - 1, j0);
            }
            if (j0 + 1 <= photo[i0].length()) {
              if (right < j0) {
                right = j0;
              }
              searcharound(photo, i0, j0 + 1);
            }
            if (j0 > -1) {
              if (left > j0) {
                left = j0;
              }
              searcharound(photo, i0, j0 - 1);
            }
          }
        }
      }
    }
  }

  /**
   * Sort.
   * @param places
   *          the places.
   */
  private void sort(final Point[] places) {
    // sorting function
    for (int i = 0; i < places.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < places.length; j++) {
        if (places[minIndex].x > places[j].x) {
          minIndex = j;
        } else if (places[minIndex].x == places[j].x) {
          if (places[minIndex].y > places[j].y) {
            minIndex = j;
          }
        }
      }
      int tmpX = places[i].x;
      int tmpY = places[i].y;
      places[i].x = places[minIndex].x;
      places[i].y = places[minIndex].y;
      places[minIndex].x = tmpX;
      places[minIndex].y = tmpY;
    }
  }
}
