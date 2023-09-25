package com.hkjava.demo.demofinnhub;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.CompanyService;

@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

  @MockBean // service will autowird repository
  private StockRepository stockRepository;

  @MockBean // service will autowird repository
  private RestTemplate restTemplate;

  @Autowired // service will autowird repository
  private String finnhubToken;

  @Autowired
  private CompanyService companyService;

  // Hamcrest, hasItem() -> test Array
  @Test
  void testFindAll() {
    Stock stock1 = Stock.builder().id(1L).country("US").build();
    Stock stock2 = Stock.builder().id(2L).country("CN").build();
    Mockito.when(stockRepository.findAll()).thenReturn(List.of(stock1, stock2));

    List<Stock> stocks = companyService.findAll(); // call stockRepository.findAll()
    assertThat(stocks, hasItem(hasProperty("country", equalTo("CN"))));
    assertThat(stocks, hasItem(hasProperty("country", equalTo("US"))));
    assertThat(stocks, not(hasItem(hasProperty("country", equalTo("HK")))));
  }

  @Test
  void testUrl1ByUri() throws FinnhubException {
    String expectedUrl =
        "https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token="
            .concat(finnhubToken);
    CompanyProfile mockedCompanyProfile = CompanyProfile.builder() //
        .country("US") //
        .ipoDate(LocalDate.of(1988, 12, 31)) //
        .build();
    Mockito.when(restTemplate.getForObject(expectedUrl, CompanyProfile.class))
        .thenReturn(mockedCompanyProfile);
    CompanyProfile profile = companyService.getCompanyProfile("AAPL"); // call stockRepository.findAll()
    assertThat(profile, hasProperty("country", equalTo("US")));
  }


}
