package com.bootcamp.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.entity.StockPrice;
import com.bootcamp.demo.entity.StockSymbol;
import com.bootcamp.demo.exception.SYMExpection;
import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.mapper.CompanyMapper;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.model.Quote;
import com.bootcamp.demo.respository.StockPriceRepository;
import com.bootcamp.demo.respository.StockRepository;
import com.bootcamp.demo.respository.StockSymbolRepository;
import com.bootcamp.demo.service.StockService;

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  StockService stockService;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  StockSymbolRepository stockSymbolRepository;

  @Override
  public void run(String... args) throws BusinessException {
    // Before server start:
    // 0: get all symbol (US) from the below API.
    // https://finnhub.io/docs/api/stock-symbol?exchange=US
    // 0: Create one more Entity StockSymbol
    // 1. get company profile 2 and insert into database
    // 2. get stock price and insert into database
    // Fetch data from the API
    stockService.deleteAll();
    try {
      // Fetch data from the API
      StockSymbol[] stockSymbols = restTemplate.getForObject(
          "https://finnhub.io/api/v1/stock/symbol?exchange=US&mic=XNYS&token=ck4ffbpr01qus81pv1u0ck4ffbpr01qus81pv1ug",
          StockSymbol[].class);

      for (StockSymbol stockSymbol : stockSymbols) {
        System.out.println("TEST :  " + stockSymbol.getSymbol());
        Company company = stockService.findCompany(stockSymbol.getSymbol()); // Assuming stockService.findCompany() retrieves company data based on the symbol.
        CompanyProfile companyProfile = CompanyMapper.mapCompany(company);

        Stock stock = Stock.builder()
            .country(companyProfile.getCountry())
            .companyName(companyProfile.getCompanyName())
            .ipoDate(companyProfile.getIpoDate())
            .logo(companyProfile.getLogo())
            .marketCap(companyProfile.getMarketCap() != null ? companyProfile.getMarketCap().doubleValue() : 0.0)
            .currency(companyProfile.getCurrency())
            .build();
        stockRepository.save(stock);

        Quote quote = stockService.findQuote(stockSymbol.getSymbol()); // Assuming stockService.findQuote() retrieves quote data based on the symbol.
        StockPrice stockPrice = StockPrice.builder()
            .currentPrice(quote.getC())
            .dayHigh(quote.getH())
            .dayLow(quote.getL())
            .dayOpen(quote.getO())
            .prevDayClose(quote.getPc())
            .build();
        stockPriceRepository.save(stockPrice);

      }
    } catch (SYMExpection e) {
      // Handle the exception as needed
    } catch (BusinessException e) {
      // Handle the exception as needed
    }
  }
}