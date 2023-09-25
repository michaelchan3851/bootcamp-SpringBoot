package com.bootcamp.demo.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bootcamp.demo.model.Customer;

public class CustomerDatabase {

  public static List<Customer> customers = new ArrayList<>();

  public static void add(Customer customer) {
    customers.add(customer);
  }

  public static List<Customer> findAll() {
    return customers;
  }

  public static Optional<Customer> find(long id) {
    return customers.stream() //
        .filter(c -> c.getId() == id) //
        .findFirst();
  }

  public static Customer remove(long id) {
    Optional<Customer> customer = find(id);

    // if(customer.isPresent()){
    // customers.stream()
    // .filter(c -> c.getId() != id)
    // .collect(Collectors.toList());
    // }
    if (!customer.isPresent())
      return null;
    CustomerDatabase.customers.remove(customer.get());
    return customer.get();
  }

  public static Customer update(long id, Customer newCustomer) {
    // Optional<Customer> oldCustomer = find(id);
    // if (!oldCustomer.isPresent())
    // return null;
    // int index = customers.indexOf(oldCustomer.get());
    // customers.set(index, newCustomer);
    // return oldCustomer.get();
    if (!find(id).isPresent())
      return null;
    customers.stream()
        .filter(customer -> customer.getId() == id)
        .forEach(e -> {
          // e.setDob(newCustomer.getDob());
          // e.setEmail(newCustomer.getEmail());
          // e.setName(newCustomer.getName());
          e = newCustomer;
        });
    return newCustomer;
  }

  public static Customer patchEmail(long id, String email){
    Optional <Customer> customer = find(id);
    if(!customer.isPresent())
      return null;
    //customer.get().setEmail(email);
    customers.stream() //
      .forEach(c -> {
        c.setEmail(email);
      });
      customer.get().setEmail(email);
    return customer.get();
  }

  public static Customer patchName(long id, String name){
    Optional <Customer> customer = find(id);
    if(!customer.isPresent())
      return null;
    //customer.get().setEmail(email);
    customers.stream() //
      .forEach(c -> {
        c.setName(name);
      });
      customer.get().setName(name);
    return customer.get();
  }
}
