package com.bootcamp.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.entity.StockPrice;
import com.bootcamp.demo.exception.SYMExpection;
import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.infra.Code;
import com.bootcamp.demo.infra.Protocol;
import com.bootcamp.demo.mapper.CompanyDTOMapper;
import com.bootcamp.demo.mapper.CompanyMapper;
import com.bootcamp.demo.model.Quote;
import com.bootcamp.demo.respository.StockPriceRepository;
import com.bootcamp.demo.respository.StockRepository;
import com.bootcamp.demo.service.StockService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceimpl implements StockService {

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockPriceRepository stockPriceRepository;

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
  public List<Stock> findAll() {
    // return stockRepository.findAllById2(4L);
    // return stockRepository.findAllById3();
    return stockRepository.findAll();
  }

  @Override
  public List<Stock> findByCountry(String country) {
    return stockRepository.findByCountry(country);
  }

  @Override
  public List<Stock> findByCountryAndMarketCapGreaterThan(String country, double marketCap) {
    return stockRepository.findByCountryAndMarketCapGreaterThan(country, marketCap);
  }

  @Override
  public void updateById(Long id, Stock newStock) {
    // if (!stockRepository.existsById(id))
    // return false;
    // stockRepository.save(stock);
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(() -> new EntityNotFoundException("Entity Stock ID not Found"));
    stock.setCompanyName(newStock.getCompanyName());
    stock.setCountry(newStock.getCountry());
    stock.setIpoDate(newStock.getIpoDate());
    stock.setMarketCap(newStock.getMarketCap());
    stock.setCurrency(newStock.getCurrency());
    stock.setLogo(newStock.getLogo());
    stockRepository.save(stock);
  }

  @Override
  public Stock save(Stock stock) {
    return stockRepository.save(stock); // insert into
  }

  @Override
  public void deleteById(Long Id) {
    stockRepository.deleteById(Id);
  }

  @Override 
  public void deleteAll(){
    stockRepository.deleteAll();
    stockPriceRepository.deleteAll();
  }

  @Override
  public void updateCompanyNameById(Long id, String companyName) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(() -> new EntityNotFoundException("Entity Stock ID not Found"));

    stock.setCompanyName(companyName);
    stockRepository.save(stock);
    // Optional<Stock> stock = stockRepository.findById(id);
    // log.info("check : " + stockRepository.findById(id).toString());
    // log.info("companyName : " + companyName);
    // if (stock.isPresent()) {
    // stock.stream() //
    // .filter(c -> c.getId() == id) //
    // .forEach(c -> { //
    // c.setCompanyName(companyName); //
    // });
    // }
    // stockRepository.save(stock.get());
    // log.info("after : " + stock);

  }

  @Override
  public Company findCompany(String symbol) throws BusinessException {

    String url = UriComponentsBuilder.newInstance() // static builder
        .scheme(Protocol.HTTPS.name()) // https
        .host(finnhubDomain) // www.jsonplaceholder.typicode.com
        .path(profile2Endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", apiToken) //
        .toUriString();

    // logic 2 - 100 lines, call service, mocked resttemplate

    String url2 = "abc.com/stock";

    // logic 3 - 100 lines, call service
    String url3 = "abc.com/stock";

    System.out.println("url=" + url);
    // Invoke API + Deserialization (JSON -> Object)
    // url =
    // "https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck4ffbpr01qus81pv1u0ck4ffbpr01qus81pv1ug";
    try {
      return restTemplate.getForObject(url, Company.class); // return type = User[].class
    } catch (RestClientException e) {
      throw new SYMExpection(Code.SYMExpection);
    }

  }

  @Override
  public Quote findQuote(String symbol) throws BusinessException{

    String url = UriComponentsBuilder.newInstance() // static builder
        .scheme(Protocol.HTTPS.name()) // https
        .host(finnhubDomain) // www.jsonplaceholder.typicode.com
        .path(quoteEndpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", apiToken) //
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

  @Override
  public StockPrice save(Long id, StockPrice stockPrice) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(() -> new EntityNotFoundException());
    stockPrice.setStock(stock);
    return stockPriceRepository.save(stockPrice);
  }


}