package com.bootcamp.demo.mapper;

import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.model.Quote;

public class CompanyDTOMapper {
  
  public static CompanyDTO mapCompanyDTO(CompanyProfile companyProfile, Quote quote){
    return CompanyDTO.builder()
      .companyProfile(companyProfile) //
      .currenctPrice(quote.getC()) //
      .dayHigh(quote.getH()) //
      .dayLow(quote.getL()) //
      .dayOpen(quote.getO()) //
      .preDayClose(quote.getPc()) //
      .build(); //
      
  }
}
