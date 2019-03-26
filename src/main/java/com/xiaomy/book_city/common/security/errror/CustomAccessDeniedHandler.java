package com.xiaomy.book_city.common.security.errror;

import com.xiaomy.book_city.common.result.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 自定义没权限的报错机制, 用法就是实现 AccessDeniedHandler接口, 并重写handle方法即可
 * AccessDeniedHandler: - 对权限操作的处理器, 拒绝访问时做的处理
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
    Result result = new Result().fail("抱歉, 您没有权限");
    httpServletResponse.getWriter().write(result.toString());
  }
}
