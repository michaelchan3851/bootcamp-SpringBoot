package com.stock.stocktradeapp.model;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Book {

  private List<Entry> entries;

  private Deque<Entry> buyBook;

  private Deque<Entry> sellBook;

  // public static Stock getData(String symbol) {
  // return data.get(symbol);
  // }

  public Deque<Entry> sorted() {
    Comparator<Entry> sortedByPrice = //
        (e1, e2) -> e1.getPrice() < e2.getPrice() ? -1 : 1;
    return this.entries.stream() //
        .sorted(sortedByPrice) //
        .collect(Collectors.toCollection(LinkedList::new));
  }

  public List<Entry> reversed() {
    return this.entries.stream() //
        .sorted(sortedByPrice()) //
        .collect(Collectors.toList());
  }

  public Deque<Entry> toSellDeque() {
    return this.entries.stream() //
        .sorted(sortedByPrice()) //
        .collect(Collectors.toCollection(LinkedList::new));
  }

  public Deque<Entry> toBuyDeque() {
    return this.entries.stream() //
        .sorted(reversedByPrice()) //
        .collect(Collectors.toCollection(LinkedList::new));
  }

  private Comparator<Entry> sortedByPrice() {
    return (e1, e2) -> e1.getPrice() < e2.getPrice() ? -1 : 1;
  }

  private Comparator<Entry> reversedByPrice() {
    return (e1, e2) -> e1.getPrice() > e2.getPrice() ? -1 : 1;
  }

}
