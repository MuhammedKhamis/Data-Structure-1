package eg.edu.alexu.csd.datastructure.stack.cs70;

import java.util.Scanner;

/**
 * The Class UiExp.
 */
public class UiExp {

  /**
   * The main method.
   * @param args
   *          the arguments.
   */
  public static void main(final String[] args) {
    ExpressionEvaluator exp = new ExpressionEvaluator();
    Scanner sc = new Scanner(System.in);
    String input;
    String expression;
    try {
      System.out.println("Enter the operation :  ");
      input = sc.nextLine();
      int len = input.length();
      boolean checker = false;
      for (int i = 0; i < len; i++) {
        if (input.charAt(i) == '/') {
          checker = true;
        } else {
          if (checker && input.charAt(i) == '0') {
            System.out.println("Error");
            sc.close();
            return;
          }
          checker = false;
        }
      }
      expression = exp.infixToPostfix(input);
      System.out.println(exp.evaluate(expression));
      System.out.println(expression);
    } catch (RuntimeException ex) {
      System.out.println("Error Stack");
      sc.close();
    }
  }
}
