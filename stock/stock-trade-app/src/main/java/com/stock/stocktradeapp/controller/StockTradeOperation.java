package com.stock.stocktradeapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stock.stocktradeapp.dto.req.PlaceOrderDTO;
import com.stock.stocktradeapp.dto.resp.OrderBookDTO;
import com.stock.stocktradeapp.model.Order;

public interface StockTradeOperation {

  @GetMapping(value = "stock/orderbook")
  @ResponseStatus(value = HttpStatus.OK)
  OrderBookDTO orderBook(String symbol);

  @PostMapping(value = "stock/order/userid/{userId}")
  @ResponseStatus(value = HttpStatus.OK)
  Order order(@RequestParam String userId,@RequestParam String symbol,
  @RequestBody PlaceOrderDTO tradeDTO);

}
