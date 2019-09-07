package se.ec.robert;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultTest {
  @Test
  public void instantiatesProperly() {
    assertNotNull(new Result(false, true));
  }
}