package com.hkjava.demo.demofinnhub.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.hkjava.demo.demofinnhub.infra.AppleRestClient;

@Configuration
public class AppConfig {

  @Value(value = "${api.finnhub.token}")
  private String token;

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }
  
  @Bean
  String finnhubToken() {
    return token;
  }

  @Bean 
  AppleRestClient stockService(RestTemplate restTemplate){
    return new AppleRestClient(restTemplate);
  }

  @Bean
  RestTemplate restTemplate() { // method name -> bean name
    return new RestTemplate();
  }

}
