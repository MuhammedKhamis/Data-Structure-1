package eg.edu.alexu.csd.datastructure.stack.cs70;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * The Class Main.
 */
public class Main {

  /**
   * The main method.
   * @param args the arguments.
   */
  public static void main(final String[] args) {
    IExpressionEvaluator testMe = new ExpressionEvaluator();
    StringBuilder string = new StringBuilder();
    final int x1 = 1000000;
    for (int i = 0; i < x1; i++) {
      string = string.append("1+");
    }
    string = string.append("1");
    long start = System.currentTimeMillis();
    String ev = testMe.infixToPostfix(string.toString());
    long first = System.currentTimeMillis();
    testMe.evaluate(ev);
    long second = System.currentTimeMillis();
    System.out.println(first - start);
    System.out.println(second - first);
    System.out.println(second - start);
  }
}
