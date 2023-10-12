package com.stock.stocktradeapp.mapper;

import static java.util.stream.Collectors.toList;
import java.time.LocalDateTime;
import com.stock.stocktradeapp.dto.req.PlaceOrderDTO;
import com.stock.stocktradeapp.dto.resp.OrderBookDTO;
import com.stock.stocktradeapp.model.Order;
import com.stock.stocktradeapp.model.OrderBook;

public class StockMapper {

  // TBC. sort by Price
  public static OrderBookDTO map(String symbol, OrderBook book) {
    return OrderBookDTO.builder() //
        .symbol(symbol) //
        .buyBook(book.getBuyBook().stream().collect(toList())) //
        .sellBook(book.getSellBook().stream().collect(toList())) //
        .build();
  }

  public static Order map(String userId, PlaceOrderDTO placeOrderDTO) {
    return Order.of(userId, LocalDateTime.now(), placeOrderDTO.getAction(),
        placeOrderDTO.getOrderType(), placeOrderDTO.getPrice(), placeOrderDTO.getShare()); //

  }

}
