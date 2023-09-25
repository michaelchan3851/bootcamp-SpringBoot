package com.bootcamp.demo.exception;

import com.bootcamp.demo.infra.BusinessException;
import com.bootcamp.demo.infra.Code;

public class JPHExpection extends BusinessException {
  
  public JPHExpection(Code code){
    super(code);
  }
}
