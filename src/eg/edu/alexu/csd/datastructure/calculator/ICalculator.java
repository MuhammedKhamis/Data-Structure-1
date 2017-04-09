package eg.edu.alexu.csd.datastructure.calculator;

public interface ICalculator {
  /**
   * Adds given two numbers.
   * 
   * @param x1
   *          first number.
   * @param y1
   *          second number.
   * @return the sum of the two numbers.
   **/
  int add(int x1, int y1);

  /**
   * Divides two numbers.
   * 
   * @param x1
   *          first number.
   * @param y1
   *          second number.
   * @return the division result.
   **/
  float divide(int x1, int y1);
}
