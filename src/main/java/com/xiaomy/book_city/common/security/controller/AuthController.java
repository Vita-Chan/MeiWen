package com.xiaomy.book_city.common.security.controller;

import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.common.result.Result;
import com.xiaomy.book_city.common.security.entity.JwtAuthenticationRequest;
import com.xiaomy.book_city.common.security.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Auth")
public class AuthController {
  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private AuthService authService;

  @ApiOperation("登录")
  @PostMapping("/login")
  public Result login(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest){
    return Result.data(authService.login(jwtAuthenticationRequest.getUsername(),jwtAuthenticationRequest.getPassword()));
  }

  @ApiOperation("注册")
  @PostMapping("/register")
  public Result register(UserVo userVo){
    return Result.of(authService.register(userVo))
        .success("注册成功")
        .fail("注册失败");
  }

  @ApiOperation("刷新token")
  @GetMapping("/refresh")
  public Result refresh(@RequestParam("refreshToken")String refreshToken){
    return Result.data(authService.refresh(refreshToken));
  }
}
