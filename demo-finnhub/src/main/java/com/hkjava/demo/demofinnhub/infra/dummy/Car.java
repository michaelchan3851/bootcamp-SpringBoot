package com.hkjava.demo.demofinnhub.infra.dummy;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class Car { //Service
  
  int speed = 0;

  public Car(){
  }

  public Car(int speed){
    this.speed = speed;
  }

}
