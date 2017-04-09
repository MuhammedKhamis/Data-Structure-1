package eg.edu.alexu.csd.datastructure.hangman.cs70;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;

/**
 * The Class Hangman.
 */
public class Hangman implements IHangman {

  /** The added words. */
  String[] addedWords;
  /** The number. */
  int num = 0;
  /** The max tries. */
  int maxTries = 0;
  /** The tries. */
  int tries = 0;
  /** The Constant x51. */
  static final  int X5 = 51;
  /** The selected word. */
  String selectedWord = new String();
  /** The s. */
  static String s = new String();
  /** The to print. */
  static char[] toPrint = new char[X5];
  /**
   * Set dictionary words to pick secret words from.
   * @param words
   *          an array of words.
   */

  @Override
  public void setDictionary(final String[] words) {
    num = words.length;
    addedWords = new String[num];
    for (int i = 0; i < num; i++) {
      addedWords[i] = words[i];
    }
  }
  /**
   * Pick a random secret word from dictionary and returns it.
   * @return secret word.
   */

  @Override
  public String selectRandomSecretWord() {
    if (num == 0) {
      return null;
    }
    Random number = new Random();
    int xnum = number.nextInt(num);
    selectedWord = addedWords[xnum];
    toPrint = selectedWord.toCharArray();
    int len = selectedWord.length();
    for (int i = 0; i < len; i++) {
      toPrint[i] = '-';
    }
    s = String.valueOf(toPrint);
    return selectedWord;
  }

  /**
   * Receive a new user guess, and verify it against the secret word.
   * @param c1
   *          case insensitive user guess. If c is NULL then ignore it
   *           and do no change.
   * @return secret word with hidden characters
   *         (use '-' instead unsolved characters),
   *         or return NULL if user reached max wrong guesses.
   */
  @Override
  public String guess(final Character c1) {
    if (c1 == null) {
      return s;
    }
    int flag = 0;
    char cs;
    if (!s.contains("-")) {
      return null;
    }
    String key = selectedWord;
    if (key.toUpperCase() == selectedWord) {
      cs = (char) Character.toUpperCase(c1);
    } else {
      cs = (char) Character.toLowerCase(c1);
    }
    int len = selectedWord.length();
    for (int i = 0; i < len; i++) {
      if (cs == selectedWord.charAt(i)) {
        if (toPrint[i] == '-') {
          toPrint[i] = cs;
          flag = 1;
        } else {
          flag = 1;
        }
      }
    }
    s = String.valueOf(toPrint);
    if (flag == 0) {
      tries++;
    }
    if (tries == maxTries) {
      return null;
    }
    return s;
  }

  /**
   * Set the maximum number of wrong guesses.
   * @param max
   *          maximum number of wrong guesses, If is NULL, then assume it 0.
   */
  @Override
  public void setMaxWrongGuesses(final Integer max) {
    if (max != null) {
      maxTries = max;
    }
  }
}
