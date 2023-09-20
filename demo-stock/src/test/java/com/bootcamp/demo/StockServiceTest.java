// package com.bootcamp.demo;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.web.client.RestTemplate;


// import com.bootcamp.demo.model.CompanyDTO;

// public class StockServiceTest {
//   @WebMvcTest
//   public class StockControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private RestTemplate restTemplate;

//     @Test
//     void testEmptyUsers() throws Exception {
//       // String url = UriComponentsBuilder.newInstance()
//       // .toUriString();
//       String url = "https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck4ffbpr01qus81pv1u0ck4ffbpr01qus81pv1ug";
     
//       Mockito.when(restTemplate.getForObject(url, CompanyDTO.class)).thenReturn(null);

//     }
//   }
// }
