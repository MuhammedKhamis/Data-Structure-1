package eg.edu.alexu.csd.datastructure.linkedList.cs70;

/**
 * The Class Tessst.
 */
public class Tessst {

  /**
   * The main method.
   * @param args the arguments.
   */
  public static void main(final String[] args) {
    PolynomialSolver test = new PolynomialSolver();
    final int x1 = 1;
    final int x2 = 2;
    final int x3 = 3;
    final int x0 = 0;
    final int x5 = 5;
    final int x4 = 4;
    final int xn7 = -7;
    int[][] array1 = new int[][] {{x2, x4}, {x3, x3}, {xn7, x2},
      {x3, x1}};
    int[][] array2 = new int[][] {{x2, x5}, {x3, x4}, {xn7, x3},
      {x3, x2}};
    int[][] array3 = new int[][] {{x0, x4}, {x0, x3}, {x0, x2},
      {x0, x1}};
    test.setPolynomial('A', array1);
    test.setPolynomial('B', array2);
    test.setPolynomial('C', array3);
    test.subtract('B', 'A');
    System.out.println(test.print('R'));
    test.subtract('A', 'B');
    System.out.println(test.print('R'));
  }
}
