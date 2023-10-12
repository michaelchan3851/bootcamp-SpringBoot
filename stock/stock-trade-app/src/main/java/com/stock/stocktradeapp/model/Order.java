package com.stock.stocktradeapp.model;

import java.time.LocalDateTime;
import com.stock.stocktradeapp.enums.Action;
import com.stock.stocktradeapp.enums.OrderType;
import lombok.Getter;

//No other lombok Constructor / Builder, lock the id increment
@Getter
public class Order {

  private static int idCounter = 0;

  private int id;

  private String userId;

  private LocalDateTime tranDateTime;

  private Action action;

  private OrderType orderType;

  private Double price;

  private Integer share;

  public static Order of(String userId, LocalDateTime tranDateTime, Action action,
      OrderType orderType, double price, int share) {
    return new Order(userId, tranDateTime, action, orderType, price, share);

  }

  public Order(String userId, LocalDateTime tranDateTime, Action action,
      OrderType orderType, double price, int share) {
    this.id = ++idCounter; // Review
    this.userId = userId;
    this.tranDateTime = tranDateTime;
    this.action = action;
    this.orderType = orderType;
    this.price = price;
    this.share = share;
  }
}
