package com.bootcamp.demo.service;

import java.util.List;

import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.model.User;

public interface UserService {

  List<User> findUsers() throws BusinessException;

  User findById(Long id) throws BusinessException;

}
