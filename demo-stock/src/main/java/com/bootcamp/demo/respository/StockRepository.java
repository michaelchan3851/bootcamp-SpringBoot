package com.bootcamp.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.entity.Stock;

import java.util.List;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

  // select * from table where company_name = "";
  List<Stock> findByCompanyName(String companyName); 
  
}