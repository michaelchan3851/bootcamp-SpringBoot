package com.bootcamp.demo.service;

import java.util.List;

import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.exception.SYMExpection;
import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.Quote;

public interface StockService {

  void updateById(Long id, Stock stock);

  List<Stock> findAll();

  List<Stock> findByCountry(String country);

  List<Stock> findByCountryAndMarketCapGreaterThan(String country, double marketCap);

  Company findCompany(String symbol) throws BusinessException;

  Quote findQuote(String symbol) throws BusinessException;

  CompanyDTO findCompanyDTO(String symbol) throws BusinessException;

  Stock save(Stock stock);

  void deleteById(Long id);

  void updateCompanyNameById(Long id, String companyName);

  
}
