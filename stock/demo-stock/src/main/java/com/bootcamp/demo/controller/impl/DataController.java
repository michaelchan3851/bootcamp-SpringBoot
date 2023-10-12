package com.bootcamp.demo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.controller.DataOperation;
import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.entity.StockPrice;
import com.bootcamp.demo.service.StockService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {

  @Autowired
  StockService stockService;

  @Override
  public StockPrice save(Long id, StockPrice stockPrice) {
    return stockService.save(id, stockPrice);
  }

  @Override
  public List<Stock> findAll() {
    return stockService.findAll();
  }

  @Override
  public List<Stock> findByCountry(String country) {
    return stockService.findByCountry(country);
  };

  @Override
  public List<Stock> findByCountryAndMarketCapGreaterThan(String country, double marketCap) {
    return stockService.findByCountryAndMarketCapGreaterThan(country, marketCap);
  }

  @Override
  public Stock save(Stock stock) {
    return stockService.save(stock);
  }

  public void updateById(Long id, Stock stock) {
    stockService.updateById(id, stock);
  }

  @Override
  public void deleteById(Long id) {
    stockService.deleteById(id);
  }

  @Override
  public void updateCompanyNameById(Long id, String companyName) {
    stockService.updateCompanyNameById(id, companyName);
  }

}
