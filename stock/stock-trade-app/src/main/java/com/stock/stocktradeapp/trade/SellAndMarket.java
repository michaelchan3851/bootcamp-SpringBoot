package com.stock.stocktradeapp.trade;

import java.util.Deque;

import com.stock.stocktradeapp.model.Entry;
import com.stock.stocktradeapp.model.Order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SellAndMarket implements Tradable{
  
  private Deque<Entry> buyBook;

  private Deque<Entry> sellBook;

  @Override
  public void trade(Double orderPrice, Integer orderShare){

  }
}
