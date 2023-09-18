package com.bootcamp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // Getter + No-args constructor
@AllArgsConstructor
public class User {
  private long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private company company;

  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

  }

  @Getter
  public static class Geo {
    private String lat;
    private String Ing;
  }

  @Getter
  public static class company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

}
