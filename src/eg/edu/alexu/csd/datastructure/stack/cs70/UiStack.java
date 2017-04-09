package eg.edu.alexu.csd.datastructure.stack.cs70;

import java.util.Scanner;

/**
 * The Class UiStack.
 */
public class UiStack {
  /**
   * The main method.
   * @param args
   *          the arguments.
   */
  public static void main(final String[] args) {
    MyStack stack = new MyStack();
    Scanner sc = new Scanner(System.in);
    final int x1 = 1;
    final int x2 = 2;
    final int x3 = 3;
    final int x4 = 4;
    final int x5 = 5;
    while (true) {
      try {
        System.out.println("Choose the number of the operation or any "
            + "other key to quit :  ");
        System.out.println("1-Push ");
        System.out.println("2-Pop ");
        System.out.println("3-Peek ");
        System.out.println("4-Size ");
        System.out.println("5-Check if Empty ");
        int operation = Integer.parseInt(sc.nextLine());
        switch (operation) {
          case x1:
            System.out.println("Enter input :  ");
            stack.push(sc.nextLine());
            break;
          case x2:
            System.out.println(stack.pop().toString());
            break;
          case x3:
            System.out.println(stack.peek().toString());
            break;
          case x4:
            System.out.println(stack.size());
            break;
          case x5:
            if (stack.isEmpty()) {
              System.out.println("Stack is empty");
            } else {
              System.out.println("Stack is not empty yet :D");
            }
            break;
          default:
            sc.close();
            return;
        }
      } catch (RuntimeException ex) {
        System.out.println("Error");
      }
    }
  }
}
