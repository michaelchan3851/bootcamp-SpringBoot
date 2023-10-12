package com.stock.stocktradeapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stocktradeapp.controller.StockTradeOperation;
import com.stock.stocktradeapp.dto.req.PlaceOrderDTO;
import com.stock.stocktradeapp.dto.resp.OrderBookDTO;
import com.stock.stocktradeapp.mapper.StockMapper;
import com.stock.stocktradeapp.model.Order;
import com.stock.stocktradeapp.service.OrderBookService;

@RestController
@RequestMapping(value = "/stock/v1")
public class StockTradeController implements StockTradeOperation {

  @Autowired
  private OrderBookService orderBookService;

  @Override
  public OrderBookDTO orderBook(String symbol) {
    return StockMapper.map(symbol, orderBookService.orderBook(symbol));
  }

  @Override
  public Order order(String userId,String symbol, PlaceOrderDTO tradeDTO) {
    return orderBookService.order(userId,symbol, tradeDTO);
  }
}
