package com.bootcamp.demo.controller;

import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.model.User;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserOperation {

  @GetMapping(value = "/users") // under the contract
  ResponseEntity<ApiResponse<List<User>>> findUsers();

  @GetMapping(value = "/users/{id}")
  User findById(@PathVariable() Long id);
}
