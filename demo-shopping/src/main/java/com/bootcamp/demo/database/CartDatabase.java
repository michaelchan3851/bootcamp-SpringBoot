package com.bootcamp.demo.database;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.demo.model.Cart;

public class CartDatabase {
  public static List<Cart> carts = new ArrayList<>();

  /**
   * remove cart by customer id from List<Cart>
   * @param customerId
   */
  public static void clear(int customerId){
    
  }

  public static void add(Cart cart){
    carts.add(cart);
  }
}
