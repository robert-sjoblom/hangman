package se.ec.robert;


public class Result {
  public boolean wordFound;
  public boolean charMatched;

  public Result(boolean wordFound, boolean charMatched) {
    this.wordFound = wordFound;
    this.charMatched = charMatched;
  }

  public Result(boolean wordFound) {
    this(wordFound, false);
  }
}
