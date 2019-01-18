package com.xiaomy.book_city.controller;

import com.xiaomy.book_city.result.Result;
import com.xiaomy.book_city.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private UserService userService;

  @ApiOperation("用户个人信息获取")
  @GetMapping("/{id}")
  public Result findUserById(@PathVariable("id")int id){
    return Result.data(userService.findUserById(id));
  }
}
