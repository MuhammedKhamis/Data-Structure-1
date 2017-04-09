package eg.edu.alexu.csd.datastructure.stack.cs70;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * The Class ExpressionEvaluator.
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

  /** The stack. */
  private MyStack stack;

  /**
   * Takes a symbolic/numeric infix expression as input and converts it to
   * postfix notation. There is no assumption on spaces between terms or
   *  the length of the term (e.g., two digits symbolic
   * or numeric term).
   * @param exp
   *          infix expression.
   * @return post fix expression.
   */
  @Override
  public String infixToPostfix(final String exp) {
    String expression = exp;
    stack = new MyStack();
    int operator = 0;
    int operante = 0;
    int prant = 0;
    if (expression.contains("%") || expression.contains("&")
        || expression.contains("|") || expression.contains("!")
        || expression.contains("^")) {
      throw new RuntimeException("ERROR Unary");
    }
    int num = expression.length();
    StringBuilder ex = new StringBuilder();
    for (int i = 0; i < num; i++) {
      switch (expression.charAt(i)) {
        case '(':
          ex.append(" ( ");
          break;
        case ')':
          ex.append(" ) ");
          break;
        case '+':
          ex.append(" + ");
          break;
        case '-':
          ex.append(" - ");
          break;
        case '*':
          ex.append(" * ");
          break;
        case '/':
          ex.append(" / ");
          break;
        default:
          ex.append(expression.charAt(i));
      }
    }
    expression = ex.toString();
    expression = expression.trim();
    String[] array = expression.split(" ");
    num = array.length;
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < num; i++) {
      if (array[i].equals("")) {
        continue;
      }
      if (array[i].equals("(")) {
        prant++;
        stack.push("(");
      } else if (array[i].equals(")")) {
        prant--;
        if (prant < 0) {
          throw new RuntimeException("Wrong brackets");
        }
        while (!stack.peek().equals("(")) {
          str.append(stack.pop().toString() + " ");
        }
        stack.pop();
      } else if (array[i].equals("*") || array[i].equals("/")) {
        if (!stack.isEmpty()) {
          if (stack.peek().equals("*") || stack.peek().equals("/")) {
            str.append(stack.pop() + " ");
          }
        }
        stack.push(array[i]);
        operator++;
      } else if (array[i].equals("+") || array[i].equals("-")) {
        if (!stack.isEmpty()) {
          while (!stack.isEmpty() && !stack.peek().equals("(")) {
            str.append(stack.pop() + " ");
          }
        }
        operator++;
        stack.push(array[i]);
      } else {
        str.append(array[i] + " ");
        operante++;
      }
    }
    num = stack.size();
    for (int i = 0; i < num - 1; i++) {
      str.append(stack.pop() + " ");
    }
    if (!stack.isEmpty()) {
      str.append(stack.pop());
    }
    if (prant != 0 || operator + 1 != operante) {
      throw new RuntimeException("something wrong");
    }
    return str.toString();
  }

  /**
   * Evaluate a post fix numeric expression, with a single space separator.
   * @param exp
   *          post fix expression.
   * @return the expression evaluated value.
   */
  @Override
  public int evaluate(final String exp) {
    String expression = exp;
    float firstnum = 0;
    float secondnum = 0;
    stack = new MyStack();
    expression.trim();
    String[] array = expression.split(" ");
    int num = array.length;
    stack.push(array[0]);
    for (int i = 1; i < num; i++) {
      switch (array[i]) {
        case "-":
          firstnum = Float.parseFloat(stack.pop().toString());
          secondnum = Float.parseFloat(stack.pop().toString());
          stack.push(secondnum - firstnum);
          break;
        case "/":
          firstnum = Float.parseFloat(stack.pop().toString());
          secondnum = Float.parseFloat(stack.pop().toString());
          if (firstnum == 0.0) {
            throw new RuntimeException("Can't Evaluate");
          }
          stack.push(secondnum / firstnum);
          break;
        case "+":
          firstnum = Float.parseFloat(stack.pop().toString());
          secondnum = Float.parseFloat(stack.pop().toString());
          stack.push(secondnum + firstnum);
          break;
        case "*":
          firstnum = Float.parseFloat(stack.pop().toString());
          secondnum = Float.parseFloat(stack.pop().toString());
          stack.push(secondnum * firstnum);
          break;
        default:
          stack.push(array[i]);
      }
    }
    return (int) Float.parseFloat(stack.pop().toString());
  }
}
