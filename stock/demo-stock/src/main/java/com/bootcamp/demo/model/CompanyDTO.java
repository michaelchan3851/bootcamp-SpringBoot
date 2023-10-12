package com.bootcamp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
  private CompanyProfile companyProfile;
  private Double currenctPrice;
  private Double dayHigh;
  private Double dayLow;
  private Double dayOpen;
  private Double preDayClose;

}
