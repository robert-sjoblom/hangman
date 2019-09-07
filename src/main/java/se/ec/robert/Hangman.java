package se.ec.robert;

public class Hangman {
  private Engine engine;

  public Hangman() {
    this.engine = new Engine();
  }

  public static void main(String[] args) {
    Hangman game = new Hangman();
    game.start();
  }

  private void start() {
    engine.run();
  }
}