package com.bootcamp.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
    User user1 = new User(1, "John", "johnlau", "johnlau@gmail.com", null, null, null, null);
    User user2 = new User(2, "Mary", "Marylau", "marylau@gmail.com", null, null,
        null, null);
    Mockito.when(userService.findUsers()).thenReturn(List.of(user1, user2));

    ResultActions mvcResult = //
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")); //

    mvcResult.andExpect(status().isOk()) // HTTP 200
        .andExpect(content().contentType("application/json")) //
        .andExpect(jsonPath("$.data[0].id").value(1)) //
        .andExpect(jsonPath("$.data[0].name").value("John")) //
        .andExpect(jsonPath("$.data[1].id").value(2))
        .andExpect(jsonPath("$.data[1].name").value("Mary")); //

  }
}
