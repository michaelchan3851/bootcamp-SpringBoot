package com.bootcamp.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {

    @GetMapping(value = "/strings")
    List<String> getStrings();

  // http://127.0.0.1:8081/api/v1/add?x=10&y=30
  @GetMapping(value = "/add") // normally user input
  Integer add(@RequestParam(name = "x") int salary //
      , @RequestParam(name = "y") int bonus //
      , @RequestParam(name = "z", required = false, defaultValue = "100") String dividend //
      , @RequestParam int k);

  // http://127.0.0.1:8081/api/v1/substract/10/20
  @GetMapping(value = { "/substract/{x}/{y}/{z}", // normally server to server
      "/substract/{x}/{y}" }) // in this case only accecpt 2 || 3 parameter
  Integer substract(@PathVariable(name = "x") int salary //
      , @PathVariable() int y //
      , @PathVariable(required = false) String z);
}
