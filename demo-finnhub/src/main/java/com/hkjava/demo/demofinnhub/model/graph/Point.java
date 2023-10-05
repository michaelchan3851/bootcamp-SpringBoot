package com.hkjava.demo.demofinnhub.model.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Point {

  private Price closePrice;

  private TranDayTime tranDateTime;

  public Point(double closePrice, TranDayTime tranDateTime) {
    this.closePrice = new Price(closePrice);
    this.tranDateTime = tranDateTime;
  }

}
