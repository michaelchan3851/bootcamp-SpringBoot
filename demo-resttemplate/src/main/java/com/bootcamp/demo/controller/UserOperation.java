package com.bootcamp.demo.controller;

import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.model.User;
import com.bootcamp.demo.model.UserDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserOperation {

  @GetMapping(value = "/users") // under the contract
  ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception;

  @GetMapping(value = "/users/{id}")
  User findById(@PathVariable() Long id) throws Exception;
}
