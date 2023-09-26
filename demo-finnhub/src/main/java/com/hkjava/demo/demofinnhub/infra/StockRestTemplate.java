package com.hkjava.demo.demofinnhub.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

//@Service // Bean
public class StockRestTemplate { // Service

  // @Autowired
  RestTemplate restTemplate;

  static final String url = "xxxx";

  public StockRestTemplate(){ //library
    if(restTemplate == null)
      throw new IllegalArgumentException();
    this.restTemplate = new RestTemplate();
  }

  public StockRestTemplate(RestTemplate restTemplate){ //library
    if(restTemplate == null)
      throw new IllegalArgumentException();
    this.restTemplate = restTemplate;
  }

  public CompanyProfile getProfile(String symbol) {
    //String url = "xxxx";
    return restTemplate.getForObject(url, CompanyProfile.class);
  }

}
