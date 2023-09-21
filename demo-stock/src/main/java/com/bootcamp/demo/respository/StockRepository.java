package com.bootcamp.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.entity.Stock;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

  // select * from table where company_name = "";
  List<Stock> findAll();

  List<Stock> findByCountry(String country);

  List<Stock> findByCountryAndMarketCapGreaterThan(String country, double marketCap);

  // update stocks set field = x where field = ? //
  // solution: (Put/ Patch) findById() -> set() -> save()
  // post (insert)

  // Native SQL query
  @Query(
    value = "select s.id, s.country, s.company_name, s.ipo_date, s.logo, s.market_cap, s.currency from finnhub_stocks s where s.id = :id",
      nativeQuery = true)
  List<Stock> findAllById2(@Param(value = "id") Long id);
   

  //JPQL (Java Persistence query language)
  @Query(value = "select s from Stock s where s.id = :id")
  List<Stock> findAllById3(@Param(value = "id") Long id);

}