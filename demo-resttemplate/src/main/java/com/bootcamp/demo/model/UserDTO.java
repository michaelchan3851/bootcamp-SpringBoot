package com.bootcamp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO { // output
  private long id;
  private String name;

  @JsonProperty(value = "x")
  private String username;
  
  private String phone;
}