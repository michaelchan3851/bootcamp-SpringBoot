package com.bootcamp.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.isNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.bootcamp.demo.model.User;
import com.bootcamp.demo.service.UserService;

// This is another Testing Environment
// which may not require a full context
@WebMvcTest // @AutoConfigureMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void testGetUsers() throws Exception {
    User user1 = new User(1, "John", "johnlau", "johnlau@gmail.com", null, "90123", null, null);
    User user2 = new User(2, "Mary", "Marylau", "marylau@gmail.com", null, null, null, null);
    Mockito.when(userService.findUsers()).thenReturn(List.of(user1, user2));
    // Mockito.verify(null, null)

    // ResultActions mvcResult = //
    // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")); //

    mockMvc.perform(get("/api/v1/users")) // HTTP 200
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.code").value(20000))
        .andExpect(jsonPath("$.message").value("OK"))
        .andExpect(jsonPath("$.data[0].phone").value("90123"))
        .andExpect(jsonPath("$.data[0].id").value(1)) //
        .andExpect(jsonPath("$.data[0].name").value("John")) //
        .andExpect(jsonPath("$.data[1].id").value(2))
        .andExpect(jsonPath("$.data[1].name").value("Mary")); //
  }

  @Test
  void testEmptyUsers() throws Exception {
    Mockito.when(userService.findUsers()).thenReturn(null);

    mockMvc.perform(get("/api/v1/users"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.code").value(40001)) //
        .andExpect(jsonPath("$.message").value("JsonPlaceHolder RestClientException"))
        // .andExpect(jsonPath("$.data").value(isNull()));
        .andExpect(jsonPath("$.data").doesNotExist());
        

  }
}
