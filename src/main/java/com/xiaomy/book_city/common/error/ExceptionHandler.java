package com.xiaomy.book_city.common.error;

import com.xiaomy.book_city.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  private static final int CODE = -1;

  private static final boolean SUCCESSFUL = false;

  @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result handler(Exception e) {
    Result result = new Result();
    if (e instanceof ConfCenterException) {
      return result.errorMassage(CODE,e.getMessage(),SUCCESSFUL);
    } else {
      LOGGER.error("exception:{}", e.getMessage(), e);
      return result.errorMassage(CODE,"服务器内部错误",SUCCESSFUL);
    }
  }
}
