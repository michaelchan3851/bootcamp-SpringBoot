package com.bootcamp.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.controller.StockOperation;
import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.infra.Code;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.Quote;
import com.bootcamp.demo.service.StockService;


@RestController
@RequestMapping(value = "/api/v1")
public class StockController implements StockOperation {

  @Autowired
  StockService stockService;

  @Override
  public ResponseEntity<ApiResponse<Company>> findCompany(String symbol) throws Exception {
    Company company = stockService.findCompany(symbol);

    if (company == null) {
      ApiResponse<Company> response = ApiResponse.<Company>builder()//
          .status(Code.SYMExpection) //
          .data(null) //
          .build();
      return ResponseEntity.badRequest().body(response);
    }

    ApiResponse<Company> response = ApiResponse.<Company>builder()//
        .ok() //
        .data(company) //
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Quote>> findQuote(String symbol) throws Exception {
    Quote quote = stockService.findQuote(symbol);

    if (quote == null) {
      ApiResponse<Quote> response = ApiResponse.<Quote>builder()//
          .status(Code.SYMExpection) //
          .data(null) //
          .build();
      return ResponseEntity.badRequest().body(response);
    }

    ApiResponse<Quote> response = ApiResponse.<Quote>builder()//
        .ok() //
        .data(quote) //
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<CompanyDTO>> findCompanyDTO(String symbol) throws Exception {
    CompanyDTO companyDTO = stockService.findCompanyDTO(symbol);

    if (companyDTO == null) {
      ApiResponse<CompanyDTO> response = ApiResponse.<CompanyDTO>builder()//
          .status(Code.SYMExpection) //
          .data(null) //
          .build();
      return ResponseEntity.badRequest().body(response);
    }

    ApiResponse<CompanyDTO> response = ApiResponse.<CompanyDTO>builder()//
        .ok() //
        .data(companyDTO) //
        .build();
    return ResponseEntity.ok().body(response);
  }

}
