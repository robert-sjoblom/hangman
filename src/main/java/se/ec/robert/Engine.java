package se.ec.robert;

import java.util.Scanner;

public class Engine {
  private int guesses;
  private Scanner sc;
  private SecretWord secretWord;
  private boolean win;

  public Engine() {
    this.secretWord = new SecretWord();
    this.sc = new Scanner(System.in);
    this.guesses = 0;
    this.win = false;
  }

  public void run() {
    System.out.println("Welcome to Hangman!");
    System.out.println("Make a guess. The secret word looks like this: " +  secretWord);
    Result result;
    do {
      try {
        result = guess();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        continue;
      }

      win = result.wordFound;
      if (win) continue;

      if (!result.charMatched) guesses++;

      System.out.println(status());
    } while (!win && guesses < 8);

    doGameOverStuff();
  }

  private String status() {
    return String.format(
        "The secret word is %s. \nYou've made %d incorrect guesses",
        secretWord,
        guesses
    );
  }

  private Result guess() {
    String guess = userInput();

    if (guess.length() < 1) {
      throw new IllegalArgumentException("No letter found");
    } else if (guess.length() == 1) {
      return secretWord.guess(guess.charAt(0));
    } else {
      return secretWord.guess(guess);
    }
  }

  private void doGameOverStuff() {
    if (win) System.out.println(win());
    else if (!win) System.out.println(lose());
  }

  private String userInput() {
    return sc.nextLine();
  }

  private String win() {
    return String.format("The secret word was \"%s\". You win!", secretWord);
  }

  private String lose() {
    return "You ran out of guesses. You lose.";
  }
}
