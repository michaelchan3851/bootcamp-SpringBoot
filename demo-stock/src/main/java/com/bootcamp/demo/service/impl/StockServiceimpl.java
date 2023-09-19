package com.bootcamp.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.exception.SYMExpection;
import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.infra.Code;
import com.bootcamp.demo.infra.Protocol;
import com.bootcamp.demo.mapper.CompanyDTOMapper;
import com.bootcamp.demo.mapper.CompanyMapper;
import com.bootcamp.demo.model.Quote;
import com.bootcamp.demo.service.StockService;

@Service
public class StockServiceimpl implements StockService {

  @Autowired
  private RestTemplate restTemplate; // from Context

  @Value(value = "${api.finnhub.domain}")
  private String finnhubDomain; // jsonplaceholder.typicode.com // from yml

  @Value(value = "${api.finnhub.endpoints.profile2}")
  private String profile2Endpoint; // users from yml

  @Value(value = "${api.finnhub.endpoints.quote}")
  private String quoteEndpoint; // users from yml

  @Value(value = "${api.finnhub.endpoints.token}")
  private String apiToken; // users from yml

  @Override
  public Company findCompany(String symbol) throws BusinessException {

    String url = UriComponentsBuilder.newInstance() // static builder
        .scheme(Protocol.HTTPS.name()) // https
        .host(finnhubDomain) // www.jsonplaceholder.typicode.com
        .path(profile2Endpoint) //
        .queryParam("symbol", symbol)
        .queryParam("token", apiToken)
        .toUriString();

    System.out.println("url=" + url);
    // Invoke API + Deserialization (JSON -> Object)
    // url =
    // "https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck4ffbpr01qus81pv1u0ck4ffbpr01qus81pv1ug";
    // try {
    return restTemplate.getForObject(url, Company.class); // return type = User[].class
    // } catch (RestClientException e) {
    // throw new SYMExpection(Code.SYMExpection);
    // }

  }

  @Override
  public Quote findQuote(String symbol) throws BusinessException {

    String url = UriComponentsBuilder.newInstance() // static builder
        .scheme(Protocol.HTTPS.name()) // https
        .host(finnhubDomain) // www.jsonplaceholder.typicode.com
        .path(quoteEndpoint) //
        .queryParam("symbol", symbol)
        .queryParam("token", apiToken)
        .toUriString();

    System.out.println("url=" + url);
    // Invoke API + Deserialization (JSON -> Object)
    try {
      return restTemplate.getForObject(url, Quote.class); // return type = User[].class
    } catch (RestClientException e) {
      throw new SYMExpection(Code.SYMExpection);
    }
  }

  @Override
  public CompanyDTO findCompanyDTO(String symbol) throws BusinessException {
    Company company = findCompany(symbol);
    Quote quote = findQuote(symbol);
    CompanyProfile companyProfile = CompanyMapper.mapCompany(company);
    CompanyDTO companyDTO = CompanyDTOMapper.mapCompanyDTO(companyProfile, quote);
    return companyDTO;

  }
}