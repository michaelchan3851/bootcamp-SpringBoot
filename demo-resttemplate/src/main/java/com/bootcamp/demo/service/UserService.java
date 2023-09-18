package com.bootcamp.demo.service;

import java.util.List;

import com.bootcamp.demo.model.User;

public interface UserService {

  List<User>findUsers();

  User findById(Long id);

}
