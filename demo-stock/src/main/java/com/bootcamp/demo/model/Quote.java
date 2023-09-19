package com.bootcamp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
  private Double c;
  private Double h;
  private Double l;
  private Double o;
  private Double pc;
  private Long t;
}
