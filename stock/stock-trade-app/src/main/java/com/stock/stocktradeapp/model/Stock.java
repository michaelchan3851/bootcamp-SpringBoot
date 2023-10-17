package com.stock.stocktradeapp.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.stock.stocktradeapp.trade.Tradable;
import com.stock.stocktradeapp.trade.TradeFactory;

import lombok.Getter;

@Getter
public class Stock {

  private static Map<String, Stock> stocks = new HashMap<>();

  private String symbol;

  private Book buyBook;

  private Book sellBook;

  public Stock(String symbol) {
    this.symbol = symbol;
    this.buyBook = getBuyBook(symbol);
    this.sellBook = getSellBook(symbol);
  }

  public void processOrder(Order order) {
    Deque<Entry> buyDeque = this.buyBook.toBuyDeque();
    Deque<Entry> sellDeque = this.sellBook.toSellDeque();
    Tradable transaction =
      TradeFactory.produce(buyDeque, sellDeque, order.getAction(), order.getOrderType());
      transaction.trade(order.getPrice(), order.getShare());
  }

  public static Book getBuyBook(String symbol) {
    return stocks.get(symbol).getBuyBook();
  }

  public static Book getSellBook(String symbol) {
    return stocks.get(symbol).getSellBook();
  }

  public static Stock getStock(String symbol) {
    return stocks.get(symbol);
  }

  public static void setData(String symbol, Stock stock) {
    if (Stock.getStock(symbol) == null)
      throw new IllegalArgumentException();
    stocks.put(symbol, stock);

  }
}
