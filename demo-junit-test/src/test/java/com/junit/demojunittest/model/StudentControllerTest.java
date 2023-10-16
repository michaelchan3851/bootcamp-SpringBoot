package com.junit.demojunittest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.junit.demojunittest.controller.StudentController;
import com.junit.demojunittest.service.StudentService;

@SpringBootTest
public class StudentControllerTest {
  
  @MockBean
  private StudentService studentService;

  @Autowired 
  private StudentController studentController;

  @Test
  void testService(){
    //when
    Mockito.when(studentService.getStudentName("Peter")).thenReturn("Jenny Lee");
    // test
    String result = studentController.getStudentName("Peter");
    // Assert
    assertEquals("Jenny Lee", result);
  }
}
