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

  
  @Autowired
  HelloworldServiceImpl helloworldServiceImpl;

  @Override
  public String hello() {
    //HelloworldServiceImpl helloworldServiceImpl = new HelloworldService() {
    return helloworldServiceImpl.generate(102);
  }

}

