package com.bootcamp.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // one of componet annotation // Annotation on method ONLY
public class AppConfig {

  @Bean // Annotation on method ONLY must under METHOD
  RestTemplate restTemplate() { // public, private, nothing
    return new RestTemplate();
  }

}
