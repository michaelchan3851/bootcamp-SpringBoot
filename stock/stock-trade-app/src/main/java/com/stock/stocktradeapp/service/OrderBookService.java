package com.stock.stocktradeapp.service;

import com.stock.stocktradeapp.dto.req.PlaceOrderDTO;
import com.stock.stocktradeapp.dto.resp.OrderBookDTO;
import com.stock.stocktradeapp.model.Order;
import com.stock.stocktradeapp.model.OrderBook;

public interface OrderBookService {
  
  OrderBook orderBook(String symbol);

  //OrderBook orderAndGet(String userId, TradeDTO tradeDTO);

  Order order(String userId, String symbol, PlaceOrderDTO tradeDTO);

}
