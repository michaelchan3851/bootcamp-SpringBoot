package com.stock.stocktradeapp.dto.resp;

import java.util.Deque;
import java.util.List;

import com.stock.stocktradeapp.model.Entry;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderBookDTO {
  
  private String symbol;

  private List<Entry> buyBook;

  private List<Entry> sellBook;
  
}
