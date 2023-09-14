package com.bootcamp.demo.controller.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.controller.CustomerOperation;
import com.bootcamp.demo.model.Customer;
import com.bootcamp.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController implements CustomerOperation {

  @Autowired
  CustomerService customerService;

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    return customerService.create(name, email, dob);
  }

  @Override
  public List<Customer> showCustomer() {
    return customerService.showCustomer();
  }

  @Override
  public Customer find(String customerId) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.find(id).orElse(null);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer create(Customer customer) {
    if(customer == null)
      return null;
    return customerService.create(customer);
  }

  @Override
  public Customer remove(String customerId) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.remove(id);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }
  

  @Override
  public Customer update(String customerId, Customer customer) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        if(customer.getId() != id)
          return null;
        return customerService.update(id, customer);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer patchEmail(String customerId, String email) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.patchEmail(id, email);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer patchName(String customerId, String name) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.patchName(id, name);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }
}
