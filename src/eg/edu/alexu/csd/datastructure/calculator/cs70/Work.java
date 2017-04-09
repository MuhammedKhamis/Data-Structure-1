package eg.edu.alexu.csd.datastructure.calculator.cs70;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * The Class Work.
 */
public class Work implements ICalculator {

  /**  used to divide.
   * @param x1 .
   * @param y1 .
   * @return division of x1, y1.
   */
  @Override
  public float divide(final int x1, final int y1) {
    return (float) x1 / y1;
  }

  /** used to add.
   * @param x1 .
   * @param y1 .
   * @return sum of the numbers.
   */
  @Override
  public int add(final int x1, final int y1) {
    return x1 + y1;
  }
}
