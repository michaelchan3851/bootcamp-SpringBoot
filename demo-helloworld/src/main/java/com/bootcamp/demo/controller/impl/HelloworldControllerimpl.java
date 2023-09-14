package com.bootcamp.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.demo.controller.HelloworldController;
import com.bootcamp.demo.service.HelloworldService;
import com.bootcamp.demo.service.impl.HelloworldServiceImpl;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1") // "/"
public class HelloworldControllerimpl implements HelloworldController {

  
  @Autowired // Check if any object implementing HelloworldService in SpringContext
  HelloworldService helloworldService;

  @Override
  public String hello() {
    // HelloworldService helloworldService = new HelloworldService();
    return helloworldService.generate(102);
  }

}


