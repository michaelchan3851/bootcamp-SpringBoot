package com.hkjava.demo.demofinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.model.Quote;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;
import com.hkjava.demo.demofinnhub.service.WebStockService;

@Service
public class WebStockServiceImpl implements WebStockService {

  @Autowired
  private CompanyService companyService;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Override
  public StockDTO stockInfo(String symbol) throws FinnhubException {
    CompanyProfile profile = companyService.getCompanyProfile(symbol);
    Quote quote = stockPriceService.getQuote(symbol);
    if (profile == null && quote == null)
      throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
    return finnhubMapper.map(profile, quote);
  }

  

}
