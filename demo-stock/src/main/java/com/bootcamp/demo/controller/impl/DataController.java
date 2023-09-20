package com.bootcamp.demo.controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.controller.DataOperation;
import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.service.StockService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation{

  @Autowired
  StockService stockService;

  @Override
  public Stock save(Stock stock){
    return stockService.save(stock);
  }
  
}
