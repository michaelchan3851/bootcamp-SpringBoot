package com.bootcamp.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v2")
public class ControllerHelloWorld {

  @GetMapping(value = "/helloworld")
  public String helloworld(){
    return "Hello world! I am Version2.";
  }
  
}
