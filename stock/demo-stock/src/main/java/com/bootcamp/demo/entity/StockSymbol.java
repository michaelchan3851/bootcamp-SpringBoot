package com.bootcamp.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "finnhub_stocksSymbol")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StockSymbol {
  
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String country;

  @Column(name = "currency")
  private String currency;

  @Column(name = "description")
  private String  description;

  @Column(name = "displaySymbol")
  private String  displaySymbol;

  @Column(name = "figi")
  private String  figi;

  @Column(name = "isin")
  private String  isin;

  @Column(name = "mic")
  private String  mic;

  @Column(name = "shareClassFIGI")
  private String  shareClassFIGI;

  @Column(name = "symbol")
  private String  symbol;

  @Column(name = "symbol2")
  private String  symbol2;

  @Column(name = "type")
  private String  type;
}
