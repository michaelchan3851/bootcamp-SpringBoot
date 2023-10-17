package com.stock.stocktradeapp.trade;

import java.util.Deque;

import com.stock.stocktradeapp.model.Entry;
import com.stock.stocktradeapp.model.Order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BuyAndLimit implements Tradable {

  private Deque<Entry> buyBook; // descending, 51.5, 51.25, 51.0

  private Deque<Entry> sellBook; // ascending, 51.75, 52.0, 52.25

  @Override
  public void trade(Double orderPrice, Integer orderShare) {
    if (orderPrice == null || orderShare == null)
      throw new IllegalArgumentException();
    // Order Price not matching existing sell book,
    // Place Buy Book and return.
    if (orderPrice.compareTo(sellBook.peek().getPrice()) < 0) {
      placeBook(this.buyBook, orderPrice, orderShare);
      return;
    }
    // Loop to check sellbook and add back to buyBook
    Entry head = this.sellBook.poll(); // head
    int restToBuy = orderShare;
    while (orderPrice.compareTo(head.getPrice()) >= 0) {
      if (restToBuy >= head.getShare()) {
        restToBuy -= head.getShare();
        head.clearShare();
        this.buyBook.addFirst(head);
      } else {
        head.deductShare(restToBuy);
        restToBuy = 0;
      }
      if (restToBuy <= 0) {
        break;
      }
      head = this.sellBook.poll(); // update head
    }
  }
}
