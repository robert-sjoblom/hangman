package se.ec.robert;

import java.util.Arrays;
import java.util.Objects;

public class SecretWord {
  /**
   * This class keeps track of the secret word
   * It also has helper functions
   */
  private String secretWord;
  private StringBuilder guesses;
  private char[] correctlyGuessedLetters;

  public SecretWord() {
    this(Dictionary.randomWord()); // this needs to be random from array of words
  }

  public SecretWord(String secretWord) {
    this.secretWord = secretWord;
    this.guesses = new StringBuilder();
    this.correctlyGuessedLetters = new char[0];
  }

  @Override
  public String toString() {
    return toStringRepresentation();
  }

  public Result guess(String input) {
    boolean wordFound = this.equals(input);
    return new Result(wordFound);
  }

  public Result guess(char c) {
    addToGuesses(c);
    boolean wordFound = this.equals(this.toString());
    boolean charMatched = charInSecretWord(c);

    return new Result(wordFound, charMatched);
  }

  private boolean equals(String word) {
    return secretWord.equalsIgnoreCase(word);
  }


  private void addToGuesses(char c) {
    if (!charInGuesses(c)) guesses.append(c);

    if (charInSecretWord(c)) {
      addToCorrectlyGuessedLetters(c);
    }
  }

  private boolean charInGuesses(char c) {
    return guesses.indexOf("" + c) < 0;
  }

  private boolean charInSecretWord(char c) {
    return secretWord.indexOf(Character.toLowerCase(c)) >= 0;
  }

  private void addToCorrectlyGuessedLetters(char c) {
    if (guessInCorrectlyGuessedLetters(c)) return;

    int offset = correctlyGuessedLetters.length;
    char[] newArray = Arrays.copyOf(correctlyGuessedLetters, offset + 1);
    newArray[offset] = c;

    this.correctlyGuessedLetters = newArray;
  }

  private boolean guessInCorrectlyGuessedLetters(char c) {
    String s = new String(correctlyGuessedLetters);
    return s.indexOf(c) >= 0;
  }

  private String toStringRepresentation() {
    String representation = "";

    for (int i = 0; i < secretWord.length(); i++) {
      boolean found = false;

      for (int j = 0; j < correctlyGuessedLetters.length; j++) {
        if (secretWord.charAt(i) == correctlyGuessedLetters[j]) {
          representation += secretWord.charAt(i);
          found = true;
        }
      }
      if (!found) {
        representation += "_";
      }
    }
    return representation;
  }
}
