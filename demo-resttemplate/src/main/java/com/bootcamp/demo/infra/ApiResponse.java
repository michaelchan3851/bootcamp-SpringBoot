package com.bootcamp.demo.infra;

import lombok.ToString;

@ToString
public class ApiResponse<T> {
  private int code;
  private String message;
  // attribute name by default same as JSON field name after serialization
  // @JsonProperty(value = "/status")
  private T data;

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> ApiResponseBuilder<T> builder() { // static method to describle the range
    return new ApiResponseBuilder<>();
  }

  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class ApiResponseBuilder<T> {
    private int code;
    private String message;
    // attribute name same as JSON field name after serialization
    private T data;

    public ApiResponseBuilder<T> status(Code code) {
      this.code = code.getCode();
      this.message = code.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> ok() {
      this.code = Code.OK.getCode();
      this.message = Code.OK.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      if (this.code == 0 || this.message == null)
        throw new RuntimeException();
      return new ApiResponse<>(this);
    }
  }

}

// {
// "code" : 200,
// "message" : "OK",

// "data" : [

// ],
// "error" : [

// ],
// }