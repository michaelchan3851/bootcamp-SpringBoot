package com.hkjava.demo.demofinnhub.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demofinnhub.infra.AppleRestClient;
import com.hkjava.demo.demofinnhub.infra.RedisHelper;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

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
  AppleRestClient stockService(RestTemplate restTemplate) {
    return new AppleRestClient(restTemplate);
  }

  // @Bean
  // public RedisConnectionFactory redisConnectionFactory() {
  // JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
  // // Configure the connection factory, e.g., set host, port, and other
  // properties
  // jedisConnectionFactory.setHostName("localhost"); // Set your Redis server
  // host
  // jedisConnectionFactory.setPort(6379); // Set your Redis server port
  // // You can set other properties like password, etc. if needed

  // return jedisConnectionFactory;
  // }

  @Bean
  RestTemplate restTemplate() { // method name -> bean name
    return new RestTemplate();
  }

  // @Bean
  // RedisTemplate<String, CompanyProfile> redisTemplate() { // method name ->
  // bean name
  // return new RedisTemplate<String, CompanyProfile>();
  // }

  // @Bean
  // RedisHelper<CompanyProfile> redisHelper(RedisTemplate<String, CompanyProfile>
  // redisTemplate) {
  // return new RedisHelper<CompanyProfile>(redisTemplate);
  // }

  @Bean
  public RedisTemplate<String, CompanyProfile> redisTemplate(RedisConnectionFactory redisConnectionFactory,
      ObjectMapper objectMapper) {
    RedisTemplate<String, CompanyProfile> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(CompanyProfile.class));
    ((Jackson2JsonRedisSerializer<?>) redisTemplate.getValueSerializer()).setObjectMapper(objectMapper);
    return redisTemplate;
  }

  @Bean
  RedisHelper<CompanyProfile> redisHelper(
      RedisTemplate<String, CompanyProfile> redisTemplate) {
    return new RedisHelper<>(redisTemplate);
  }
}
