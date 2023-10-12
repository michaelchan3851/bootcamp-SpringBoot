package com.hkjava.demo.demofinnhub.infra;

import lombok.Setter;

public class NameHolder {

  String name;

  @Setter
  StringCase stringCase = StringCase.UPPERCASE;

  public NameHolder(String name) {
    this.name = name;
  }

  public boolean isTooLong() {
    return name.length() > 100;
  }

  public static boolean isTooLong(String name) {
    return name.length() > 100;
  }

  public String getName() {
    return stringCase == StringCase.UPPERCASE ? name.toUpperCase()
        : name.toLowerCase();
  }

  public static void main(String[] args) {
    NameHolder name = new NameHolder("John");
    name.getName(); // JOHN
    name.setStringCase(StringCase.LOWERCASE);
    name.getName(); // john
  }
}
