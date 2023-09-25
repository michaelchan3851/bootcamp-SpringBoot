package com.hkjava.demo.demofinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;

public interface StockOperation {

  @GetMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<StockDTO> stockInfo(@RequestParam("symbol") String symbol)
      throws FinnhubException;

  // @GetMapping(value = "/stockfromdb")
  // @ResponseStatus(value = HttpStatus.OK)
  // ApiResponse<StockDTO> stockInfoFromDb(@RequestParam("symbol") String symbol)
  //     throws FinnhubException;

}
