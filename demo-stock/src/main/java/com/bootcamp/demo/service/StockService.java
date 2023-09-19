package com.bootcamp.demo.service;

import java.util.List;

import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.model.Company;
import com.bootcamp.demo.model.CompanyDTO;
import com.bootcamp.demo.model.Quote;

public interface StockService {

  Company findCompany(String symbol) throws BusinessException;

  Quote findQuote(String symbol) throws BusinessException;

  CompanyDTO findCompanyDTO(String symbol) throws BusinessException;
}
