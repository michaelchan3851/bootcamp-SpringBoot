package com.bootcamp.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyProfile {
  private String country;
  private String companyName;
  private LocalDate ipoDate;
  private String logo;
  private Double marketCap;
  private String currency;

}
