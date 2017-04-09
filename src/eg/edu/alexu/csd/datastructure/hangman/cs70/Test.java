package eg.edu.alexu.csd.datastructure.hangman.cs70;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Scanner;

/**
 * The Class test.
 */
public class Test {

  /** The directionary. */
  static String[] directionary = new String[] {"BELGIUM", "BURUNDI",
      "COLOMBIA",
      "EGYPT",
      "KAZAKHSTAN", "MAURITANIA", "SINGAPORE", "UZBEKISTAN"};
  /** The input. */
  private static Scanner input;

  /**
   * The main method.
   * @param args the arguments
   */
  public static void main(final String[] args) {
    IHangman hangman = new Hangman();
    hangman.setDictionary(directionary);
    final int x3 = 3;
    hangman.setMaxWrongGuesses(x3);
    String secret = hangman.selectRandomSecretWord();
    input = new Scanner(System.in);
    Character guess = null;
    do {
      String result = hangman.guess(guess);
      if (result == null) {
        System.out.println("Fail! correct answer = '" + secret + "'");
        return;
      }
      System.out.println(result);
      if (!result.contains("-")) {
        System.out.println("Well Done!"); // win
        return;
      }
      guess = input.next().charAt(0);
    } while (true);
  }
}
