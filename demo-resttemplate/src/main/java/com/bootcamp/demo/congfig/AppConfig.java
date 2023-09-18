package com.bootcamp.demo.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // one of Component
public class AppConfig { // Bean

  /**
   * RestTemplate is a tool/ class (library) to invoke third party APIs
   * restTemplate object can be with lots of states.variables.
   * 
   * @return an object of RestTemplate
   */
  @Bean
  RestTemplate restTemplate() {
    // A tool class (library) to invoke third party APIs
    return new RestTemplate(); // lots of states/ Variables
  }
}
