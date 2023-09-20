package com.bootcamp.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.CompanyProfile;
import com.bootcamp.demo.service.StockService;

@WebMvcTest
public class StockControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StockService stockService;

  @Test
  void testCompanyDTO() throws Exception {
    String symbol = "AAPL";
    CompanyProfile companyProfile = new CompanyProfile("US", "Apple Inc", "1980-12-12",
        "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg", 2782424.256787212, "USD");
    CompanyDTO companyDTO = new CompanyDTO(companyProfile, 177.97, 179.38, 176.44, 176.48, 175.01);
    Mockito.when(stockService.findCompanyDTO(symbol)).thenReturn(companyDTO);

    mockMvc.perform(get("/api/v1/stock/AAPL")) //
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.code").value(20000))
        .andExpect(jsonPath("$.message").value("OK"))
        .andExpect(jsonPath("$.data.dayHigh").value(179.38));
  }

  @Test
  void testEmptyUsers() throws Exception {
    String symbol = "AAPL";
    Mockito.when(stockService.findCompanyDTO(symbol)).thenReturn(null);

    mockMvc.perform(get("/api/v1/stock/AAPL"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.code").value(40001)) //
        .andExpect(jsonPath("$.message").value("finnhub RestClientException"))
        // .andExpect(jsonPath("$.data").value(isNull()));
        .andExpect(jsonPath("$.data").doesNotExist());

  }

}
