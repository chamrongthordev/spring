package com.chamrong.jacococodecoverage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessagesTest {

  @Test
  void testNameChamrong() {
    Messages obj = new Messages();
    Assertions.assertEquals("Hello Chamrong!", obj.getMessage("Chamrong"));
  }

  @Test
  void testNameBlank() {
    Messages obj = new Messages();
    Assertions.assertEquals("Please Provide a name!", obj.getMessage(""));
  }

  @Test
  void testNameNull() {
    Messages obj = new Messages();
    Assertions.assertEquals("Please Provide a name!", obj.getMessage(null));
  }
}