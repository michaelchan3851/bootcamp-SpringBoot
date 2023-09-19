package com.bootcamp.demo.mapper;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.model.Quote;


public class CompanyMapper {
  public static CompanyProfile mapCompany(Company company){
    return CompanyProfile.builder()
      .country(company.getCountry()) //
      .companyName(company.getName()) //
      .ipoDate(company.getIpo()) //
      .logo(company.getLogo()) //
      .marketCap(company.getMarketCapitalization()) //
      .currency(company.getCurrency()) //
      .build();
  } 
}
