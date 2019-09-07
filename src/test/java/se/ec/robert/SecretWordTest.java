package se.ec.robert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SecretWordTest {
  private SecretWord sw;

  @Before
  public void setup() {
    sw = new SecretWord("secret");
  }

  @Test
  public void printSecretWord() {
    assertEquals("______", sw.toString());

    sw.guess('s');
    assertEquals("s_____", sw.toString());

    sw.guess('t');
    assertEquals("s____t", sw.toString());
  }

  @Test
  public void wordIsEqualToSecretWord() {
    Result result = sw.guess("secret");
    assertTrue(result.wordFound);
    assertFalse(result.charMatched);
  }

  @Test
  public void wordIsNotEqualToSecretWord() {
    Result result = sw.guess("not secret");
    assertFalse(result.wordFound);
    assertFalse(result.charMatched);
  }

  @Test
  public void toString1() {}

  @Test
  public void guess() {
    Result result = sw.guess('s');
    assertTrue(result.charMatched);
    assertFalse(result.wordFound);
  }

  @Test
  public void guessEntireWordWithChars() {
    sw.guess('s'); sw.guess('e'); sw.guess('c'); sw.guess('r');
    Result result = sw.guess('t');
    assertTrue(result.wordFound);
    assertTrue(result.charMatched);
  }

  @Test
  public void guessEntireWordWithRepeatingLetters() {
    sw.guess('s'); sw.guess('e'); sw.guess('c'); sw.guess('r');
    sw.guess('e');
    assertEquals("secre_", sw.toString());
  }
}
