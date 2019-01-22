package com.xiaomy.book_city.common.result;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

public class Result extends LinkedHashMap<String, Object> {
  public static final String DATA = "data";
  public static final int FAIL = 0;
  public static final int SUCCESS = 1;
  private int status = -1;
  private HttpStatus httpStatus;
  private boolean successful = true;

  public Result() {
  }

  public static Result of(boolean success) {
    return (new Result()).status(success);
  }

  public static Result of(Number success) {
    return (new Result()).status(success.intValue());
  }

  public static Result of(String name, Object o) {
    return (new Result()).addAttribute(name, o);
  }

  public static Result data(Object data) {
    return (new Result()).addAttribute("data", data);
  }

  public Result status(boolean success) {
    return this.status(success ? 1 : 0);
  }

  public Result status(int status) {
    this.status = status;
    if (this.status <= 0) {
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

  public Result success(String message, HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
    return this.success(message);
  }

  public Result fail(String message) {
    Assert.isTrue(!this.successful,message);
    return this;
  }

  public Result fail(String message, String attributeName, Object attributeValue) {
    Map<String, Object> attributes = Maps.newHashMap();
    attributes.put(attributeName, attributeValue);
    return this.fail(message, attributes);
  }

  public Result fail(String message, Map<String, Object> attributes) {
    Assert.isTrue(!this.successful,message);
    return this;
  }

  public Result message(String message) {
    this.addAttribute("message", message);
    return this;
  }

  public String getMessage() {
    return (String)this.get("message");
  }

  public Result addAttribute(String attributeName, Object attributeValue) {
    Preconditions.checkNotNull(attributeName, "Model attribute name must not be null");
    this.put(attributeName, attributeValue);
    return this;
  }

  public Result addAllAttributes(Map<String, ?> attributes) {
    if (attributes != null) {
      this.putAll(attributes);
    }

    return this;
  }
}