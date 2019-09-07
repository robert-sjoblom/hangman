package se.ec.robert;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class DictionaryTest {

  @Test
  public void randomWord() {
    String[] words = { "secret", "java", "superfluous", "banana", "glass" };
    String word = Dictionary.randomWord();
    assertTrue(Arrays.asList(words).contains(word));
  }
}