package com.bootcamp.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Item extends Good {
  private int quantity;

  public Item(double price, String description, int quantity) {
    super(price, description);
    this.quantity = quantity;
  }

  public static void main(String[] args) {
    Item item = new Item(30.5, "ABC", 3);
    System.out.println(item.getId());
    Item item2 = new Item(99.9, "XYZ", 11);
    System.out.println(item2);
  }
}
