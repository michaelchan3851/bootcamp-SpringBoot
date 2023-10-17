package com.stock.stocktradeapp.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
public class Entry {

  private double price;

  private int share;

  public void addShare(int share) {
    this.share += share;
  }

  public void deductShare(int share) {
    this.share -= share;
  }

  public void clearShare() {
    this.share = 0;
  }

}
