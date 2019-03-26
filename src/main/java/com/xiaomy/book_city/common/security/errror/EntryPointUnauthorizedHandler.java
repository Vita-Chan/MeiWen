package com.xiaomy.book_city.common.security.errror;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * 自定义没有携带token, 或者token无效的异常
 * AuthenticationEntryPoint -
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

  @Override
  public void commence(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    //返回json形式的错误信息
    httpServletResponse.setCharacterEncoding("UTF-8");
    httpServletResponse.setContentType("application/json");

    httpServletResponse.getWriter().println("{\"code\":401,\"message\":\"您没有携带token,或者token 无效！\",\"data\":\"\"}");
    httpServletResponse.getWriter().flush();
  }

}