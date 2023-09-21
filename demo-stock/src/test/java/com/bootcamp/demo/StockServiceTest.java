package com.bootcamp.demo;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.entity.Stock;
import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.respository.StockRepository;
import com.bootcamp.demo.service.StockService;

@SpringBootTest
public class StockServiceTest {

  @MockBean // service will autowird repository
  StockRepository stockRepository;

  @MockBean
  private RestTemplate restTemplate;

  @Autowired
  private StockService stockService;

  // Hamcrest, hasItem() -> test Array
  @Test
  void testFindAll() {
    Stock stock = Stock.builder().id(1L).country("US").build();
    Stock stock2 = Stock.builder().id(2L).country("CN").build();
    Mockito.when(stockRepository.findAll()).thenReturn(List.of(stock, stock2));

    List<Stock> stocks = stockService.findAll(); // call stockRepository.findAll()
    assertThat(stocks, hasItem(hasProperty("country", equalTo("CN"))));
    assertThat(stocks, hasItem(hasProperty("country", equalTo("US"))));
    assertThat(stocks, not(hasItem(hasProperty("country", equalTo("HK")))));

  }

  @Test
  void testRestTemplate() throws BusinessException {
    String expectedUrl = "HTTPS://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck4ffbpr01qus81pv1u0ck4ffbpr01qus81pv1ug";
    Company mockedCompanyProfile = Company.builder()
        .country("US") //
        .ipo(LocalDate.of(1988, 12, 31)) //
        .build();
    Mockito.when(restTemplate.getForObject(expectedUrl, Company.class))
        .thenReturn(mockedCompanyProfile);
    // ...
    Company profile = stockService.findCompany("AAPL"); // call stock
    assertThat(profile, hasProperty("country", equalTo("US")));

  }
}
