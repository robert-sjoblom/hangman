package se.ec.robert;

import java.util.Random;

public class Dictionary {
  static private String[] words = {
      "secret", "java", "superfluous", "banana", "glass"
  };

  static String randomWord() {
    int rnd = new Random().nextInt(words.length);
    return words[rnd];
  }
}
