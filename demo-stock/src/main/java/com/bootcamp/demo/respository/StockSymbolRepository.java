package com.bootcamp.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.demo.entity.StockSymbol;

public interface StockSymbolRepository extends JpaRepository<StockSymbol, Long> {
  
}
