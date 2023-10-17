package com.stock.stocktradeapp.trade;

import java.util.Deque;
import java.util.Iterator;

import com.stock.stocktradeapp.enums.Action;
import com.stock.stocktradeapp.enums.OrderType;
import com.stock.stocktradeapp.model.Entry;

public class TradeFactory {

  public static Tradable produce(Deque<Entry> buyBook, Deque<Entry> sellBook, Action action, OrderType orderType) {
    if (action == Action.BUY && orderType == OrderType.LIMIT)
      return new BuyAndLimit(buyBook, sellBook);
    else if (action == Action.BUY && orderType == OrderType.MARKET)
      return new BuyAndMarket(buyBook, sellBook);
    else if (action == Action.SELL && orderType == OrderType.LIMIT)
      return new SellAndLimit(buyBook, sellBook);
    else if (action == Action.SELL && orderType == OrderType.MARKET)
      return new SellAndMarket(buyBook, sellBook);
    return null;
  }

  public static void placeBook(Deque<Entry> entries, Double orderPrice, Integer orderInteger){
    Iterator<Entry> itr = entries.iterator();
    Entry entry = null;
    while (itr.hasNext()){
      
    }
  }

}
