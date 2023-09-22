package com.bootcamp.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long>{
  
  
}
