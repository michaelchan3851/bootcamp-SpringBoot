package com.hkjava.demo.demofinnhub.infra.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.Setter;

@Setter
@Component
public class Distance { // controller

  int hours;

  @Autowired
  Car car; // service

  public int calculate() {
    return this.car.getSpeed() * this.hours;
  }

}
