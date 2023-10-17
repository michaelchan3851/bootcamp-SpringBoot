package com.bootcamp.demojmetertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class JmeterController {
  
  public static int counter = 0;

  @GetMapping(value = "/jmeter")
  public String jmeterTest(){
    System.out.println(++counter);
    return "current count=" + String.valueOf(counter);
  }

}
