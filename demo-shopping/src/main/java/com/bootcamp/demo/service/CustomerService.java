package com.bootcamp.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.bootcamp.demo.model.Customer;

public interface CustomerService {

  Customer create(String name, String email, LocalDate dob);

  Customer create(Customer customer);

  List<Customer> showCustomer();

  Optional<Customer> find(long id);

  Customer remove(long id);

  Customer update(long id, Customer customer);

  Customer patchEmail(long id, String email);

  Customer patchName(long id, String name);

}
