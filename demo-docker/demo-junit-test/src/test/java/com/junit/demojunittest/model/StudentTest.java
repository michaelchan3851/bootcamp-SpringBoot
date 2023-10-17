package com.junit.demojunittest.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

  @Test
  void testSetterGetter() {
    // when
    Student student = new Student("John", 30);
    // test
    String name = student.getName();
    // assert
    assertEquals("John", name);

  }

  @Test
  void testConcat() {
    String lastName = "Wong";
    Student student = new Student("John", 30);
    String result = student.concat(lastName);
    assertEquals("John Wong", result);
  }

  @Test
  void testCalculateScore() {
    // when
    int score = 20;
    Student student = new Student("John", 30);
    // test
    int result = student.calculateScore(score);
    assertEquals(20, result);

    student.setAge(17);
    result = student.calculateScore(score);
    assertEquals(25, result);

    student.setAge(18);
    result = student.calculateScore(score);
    assertEquals(20, result);

    student.setAge(65);
    result = student.calculateScore(score);
    assertEquals(30, result);

    student.setAge(64);
    result = student.calculateScore(score);
    assertEquals(20, result);
  }



}
