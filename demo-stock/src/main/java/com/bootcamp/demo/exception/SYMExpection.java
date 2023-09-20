package com.bootcamp.demo.exception;

import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.infra.Code;


public class SYMExpection extends BusinessException {
  
  public SYMExpection(Code code){
    super(code);
  }
}
