package com.bootcamp.demo.mapper;

import com.bootcamp.demo.model.User;
import com.bootcamp.demo.model.UserDTO;

public class UserMapper {

  public static UserDTO map(User user) {
    return UserDTO.builder() //
        .id(user.getId()) //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .phone(user.getPhone()) //
        .build();
  }
}
