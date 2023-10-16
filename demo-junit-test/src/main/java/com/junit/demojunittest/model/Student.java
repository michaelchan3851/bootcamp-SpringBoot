package com.junit.demojunittest.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {

  private String name;

  private int age;

  public Student (String name, int age){
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String concat(String lastName){
    return this.name + " " + lastName;
  }

  public int calculateScore(int score){
    if(this.age >= 65)
      return score + 10;
    else if(this.age < 18)
      return score + 5;
    return score;
  }
}
