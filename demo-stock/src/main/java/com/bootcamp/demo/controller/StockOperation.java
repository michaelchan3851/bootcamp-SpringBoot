package com.bootcamp.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo.exception.SYMExpection;
import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.Quote;


public interface StockOperation {
  
  @GetMapping(value = "/stock/{symbol}")
  ResponseEntity<ApiResponse<CompanyDTO>> findCompanyDTO(@PathVariable() String symbol) throws Exception;

  @GetMapping(value = "/stock/company/{symbol}")
  ResponseEntity<ApiResponse<Company>> findCompany(@PathVariable() String symbol) throws Exception;

  @GetMapping(value = "/stock/quote/{symbol}")
  ResponseEntity<ApiResponse<Quote>> findQuote(@PathVariable() String symbol) throws Exception;

  

}
