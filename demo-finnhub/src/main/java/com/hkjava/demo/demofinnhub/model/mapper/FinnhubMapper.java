package com.hkjava.demo.demofinnhub.model.mapper;

import java.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.model.Quote;
import com.hkjava.demo.demofinnhub.model.Symbol;
import com.hkjava.demo.demofinnhub.model.dto.CompanyProfileDTO;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import jakarta.persistence.Column;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;

  public StockDTO map(CompanyProfile companyProfile, Quote quote) {
    return StockDTO.builder() //
        .companyProfile(
            modelMapper.map(companyProfile, CompanyProfileDTO.class)) //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }

  public StockSymbol map(Symbol symbol) {
    return StockSymbol.builder() //
        .symbol(symbol.getSymbol()) //
        .build();
  }

  public Stock map(CompanyProfile profile) {
    return Stock.builder() //
        .country(profile.getCountry()) //
        .companyName(profile.getCompanyName()) //
        .logo(profile.getLogo()) //
        .marketCap(profile.getMarketCap()) //
        .currency(profile.getCurrency()) //
        .build();
  }

  public StockPrice map(Quote quote) {
    return StockPrice.builder() //
        .currentPrice(quote.getCurrentPrice())
        .dayHigh(quote.getDayHigh())
        .dayHigh(quote.getDayHigh())
        .dayLow(quote.getDayLow())
        .dayOpen(quote.getDayOpen())
        .prevDayClose(quote.getPrevDayClose())
        .build();
  }

}
