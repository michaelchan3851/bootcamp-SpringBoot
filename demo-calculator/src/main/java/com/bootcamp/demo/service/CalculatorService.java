package com.bootcamp.demo.service;

import java.util.List;

public interface CalculatorService {

  /**
   * 
   * @param x
   * @param y
   * @return
   */
  List<String> getStrings();

  /**
   * 
   * @param x
   * @param y
   * @return
   */
  int add(int x, int y);

  /**
   * A method to substract x by y.
   * @param x
   * @param y
   * @return
   */
  int substract(int x, int y);
}
