package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.Symbol;

public interface StockSymbolService {

  List<Symbol> getAllSymbols() throws FinnhubException;

  List<StockSymbol> save(List<Symbol> symbols);

  void deleteAll();

}
