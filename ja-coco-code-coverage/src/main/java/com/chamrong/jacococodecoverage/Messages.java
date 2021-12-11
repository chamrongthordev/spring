package com.chamrong.jacococodecoverage;

public class Messages {
  public String getMessage(String name) {
    StringBuilder s = new StringBuilder();
    if (name == null || name.trim().length() == 0) {
      s.append("Please Provide a name!");
    } else {
      s.append("Hello ").append(name).append("!");
    }

    return s.toString();
  }
}
