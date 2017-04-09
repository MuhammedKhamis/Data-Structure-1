package eg.edu.alexu.csd.datastructure.stack;

public interface IExpressionEvaluator {
  /**
   * Takes a symbolic/numeric infix expression as input and converts it to postfix notation. There
   * is no assumption on spaces between terms or the length of the term (e.g., two digits symbolic
   * or numeric term).
   * 
   * @param expression
   *          infix expression.
   * @return post fix expression.
   */
  public String infixToPostfix(String expression);

  /**
   * Evaluate a post fix numeric expression, with a single space separator.
   * 
   * @param expression
   *          post fix expression.
   * @return the expression evaluated value.
   */
  public int evaluate(String expression);
}
