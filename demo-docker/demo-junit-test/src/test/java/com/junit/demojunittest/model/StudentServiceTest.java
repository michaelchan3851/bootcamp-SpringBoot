package com.junit.demojunittest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;


import com.junit.demojunittest.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
  
  @Spy // Similar to @Autowired, but some of its method can be mocked
  private StudentService studentService;

  @Test
  void testGetDB(){
    //when 
    Mockito.when(studentService.getDB()).thenReturn("Mary Lau");
    //test
    String result = studentService.getStudentName("Dummy");
    // Assert
    assertEquals("Mary Lau", result);

    // Test and Assert
    // assertThrows(IllegalArgumentException.class)
      
  }
}
