package com.bootcamp.demo.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Member of @Component
public class BeanCreator {

  @Bean(name = "arraylist")
  List<String> createArrayList() {
    List<String> strings = new ArrayList<>();
    strings.add("abc");
    strings.add("ijk");
    strings.add("xyz");
    return strings;
  }

  @Bean(name = "linkedlist")
  List<String> createLinkedList() {
    return new LinkedList<>();
  }
}
