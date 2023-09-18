package com.bootcamp.demo.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.controller.UserOperation;
import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.infra.Code;
import com.bootcamp.demo.model.User;
import com.bootcamp.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController // Controller + ResponseBody
@RequestMapping(value = "/api/v1") // design
public class UserController implements UserOperation {

  @Autowired
  UserService UserService;

  @Override
  public ResponseEntity<ApiResponse<List<User>>> findUsers() {
    List<User> users = UserService.findUsers();
    if (users == null) {
      ApiResponse<List<User>> response = ApiResponse.<List<User>>builder()//
          .status(Code.JPH_NOTFOUND) //
          .data(users) //
          .build();
      return ResponseEntity.badRequest().body(response);
    }
    ApiResponse<List<User>> response = ApiResponse.<List<User>>builder()//
        // .status(Code.OK) // .ok()
        .ok() //
        .data(UserService.findUsers()) //
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public User findById(Long id) {
    try {
      return UserService.findById(id);
    } catch (NumberFormatException e) {

    }
    return UserService.findById(id);
  }
}
