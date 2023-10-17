package com.stock.stocktradeapp.trade;

import java.util.Deque;

import com.stock.stocktradeapp.model.Entry;
import com.stock.stocktradeapp.model.Order;

@FunctionalInterface
public interface Tradable {

  void trade(Double orderPrice, Integer orderShare);

  default void placeBook(Deque<Entry> entries, Double orderPrice, Integer orderShare ){
    TradeFactory.placeBook(entries, orderPrice, orderShare);
  }

}