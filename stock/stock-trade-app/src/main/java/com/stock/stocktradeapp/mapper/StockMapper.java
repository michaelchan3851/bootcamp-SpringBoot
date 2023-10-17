package com.stock.stocktradeapp.mapper;

import static java.util.stream.Collectors.toList;
import java.time.LocalDateTime;
import com.stock.stocktradeapp.dto.req.PlaceOrderDTO;
import com.stock.stocktradeapp.dto.resp.OrderBookDTO;
import com.stock.stocktradeapp.model.Order;
import com.stock.stocktradeapp.model.Stock;

public class StockMapper {

  // TBC. sort by Price
  public static OrderBookDTO map(String symbol, Stock book) {
    return OrderBookDTO.builder() //
        .symbol(symbol) //
        .buyBook(book.getBuyBook().reversed()) //
        .sellBook(book.getSellBook().reversed()) //
        .build();
  }

  public static Order map(String userId, PlaceOrderDTO placeOrderDTO) {
    return Order.of(userId, LocalDateTime.now(), placeOrderDTO.getAction(),
        placeOrderDTO.getOrderType(), placeOrderDTO.getPrice(), placeOrderDTO.getShare()); //

  }

}
