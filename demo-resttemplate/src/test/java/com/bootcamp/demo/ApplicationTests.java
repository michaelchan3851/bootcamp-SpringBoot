package com.bootcamp.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcret -> Matchers
// JUnit5 -> jupiter -> @Mock, @InjectMock, Mockito (when)
// Spring Test Framework -> @WebMvcTest
// What is @SpringBootTest?

// I am going test
@SpringBootTest // with a complete context
// mvn clean test -> Simulate App Server Start & Bean Injection on Context
class DemoResttempleApplicationTests {

  @Test
  void contextLoads() { // Test Server Start

  }
}
