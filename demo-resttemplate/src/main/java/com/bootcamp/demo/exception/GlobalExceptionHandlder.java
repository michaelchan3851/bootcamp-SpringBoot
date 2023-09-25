package com.bootcamp.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.infra.ApiResponse;
import com.bootcamp.demo.infra.Code;


@RestControllerAdvice // @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandlder {

  @ExceptionHandler(value = JPHExpection.class)
  public ResponseEntity<ApiResponse<Void>> getUserExceptionHandler(){
    ApiResponse<Void> response = ApiResponse.<Void>builder()
      .status(Code.JPH_NOTFOUND) //
      .data(null)
      .build();
      return ResponseEntity.badRequest().body(response);
  }
}
