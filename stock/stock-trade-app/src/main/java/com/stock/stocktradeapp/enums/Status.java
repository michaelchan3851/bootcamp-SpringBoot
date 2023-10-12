package com.stock.stocktradeapp.enums;

import lombok.Getter;

@Getter
public enum Status {
  COMPLETED('C'), //
  PENDING('P'), //
  CANCELLED('N'), //
  ;

  char val;

  private Status(char val) {
    this.val = val;
  }

  public static Status valueOf(char val) {
    for (Status s : Status.values()) {
      if (s.getVal() == val)
        return s;
    }
    throw new IllegalArgumentException("Invalid Status character: " + val);
  }
}