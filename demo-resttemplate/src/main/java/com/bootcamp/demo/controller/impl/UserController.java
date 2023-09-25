package com.bootcamp.demo.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.controller.UserOperation;
import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.infra.Code;
import com.bootcamp.demo.mapper.UserMapper;
import com.bootcamp.demo.model.User;
import com.bootcamp.demo.model.UserDTO;
import com.bootcamp.demo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController // Controller + ResponseBody
@RequestMapping(value = "/api/v1") // design
public class UserController implements UserOperation {

  @Autowired
  UserService UserService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception{
    List<User> users = UserService.findUsers();

    if (users == null) {
      ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder()//
          .status(Code.JPH_NOTFOUND) //
          .data(null) //
          .build();
      return ResponseEntity.badRequest().body(response);
    }

    // Conversion (User -> userDTOs)
    List<UserDTO> userDTOs = users.stream() // 
        .map(user -> UserMapper.map(user)) //
        .collect(Collectors.toList());

    ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder()//
        // .status(Code.OK) // .ok()
        .ok() //
        .data(userDTOs) //
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public User findById(Long id) throws Exception{
    try {
      return UserService.findById(id);
    } catch (NumberFormatException e) {

    }
    return UserService.findById(id);
  }
}
