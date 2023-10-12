package com.stock.stocktradeapp.dto.req;

import com.stock.stocktradeapp.enums.Action;
import com.stock.stocktradeapp.enums.OrderType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlaceOrderDTO {

  private String symbol;
  
  private Action action;

  private OrderType orderType;

  private Double price; // null

  private Integer share; // null
}
