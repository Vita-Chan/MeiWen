package com.xiaomy.book_city.common.result;

import com.google.common.base.Preconditions;
import com.xiaomy.book_city.common.error.ConfCenterException;
import java.util.LinkedHashMap;

public class Result extends LinkedHashMap<String, Object> {

  private Object data;

  private int status = -1;

  private boolean successful = true;


  public Result(int status, boolean successful, Object data){
    this.status = status;
    this.successful = successful;
    this.data = data;
  }
  public Result(){}
  public static Result data(Object data){
    return (new Result()).addAttribute("data", data);
  }

  public static Result of(Number success){
    return new Result().isStatus(success.intValue());
  }

  public Result isStatus(int status){
    this.status = status;
    if(status <= 0){
      this.successful = false;
    }
    this.addAttribute("successful", this.successful);
    this.addAttribute("status", this.status);
    return this;
  }

  public Result success(String message) {
    if (this.successful) {
      this.message(message);
    }
    return this;
  }
  public Result message(String message) {
    this.addAttribute("message", message);
    return this;
  }

  public Result errorMassage(int code, String message, boolean successful){
    this.addAttribute("code", code);
    this.addAttribute("successful", successful);
    this.addAttribute("message", message);
    return this;
  }

  public Result fail(String message) {
    if (!this.successful) {
      throw new ConfCenterException(message);
    }
    return this;
  }

  public Result addAttribute(String attributeName, Object attributeValue) {
    Preconditions.checkNotNull(attributeName, "Model attribute name must not be null");
    this.put(attributeName, attributeValue);
    return this;
  }
}