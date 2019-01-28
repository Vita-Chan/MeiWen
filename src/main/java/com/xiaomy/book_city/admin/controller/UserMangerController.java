package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.admin.service.UserMangerService;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user/manger")
public class UserMangerController {

  @Autowired
  private UserMangerService userMangerService;

  @ApiOperation("获取所有的用户信息 - 分页查询")
  @GetMapping()
  public Result queryUsers(UserQueryBuilder userQueryBuilder){
    return Result.data(userMangerService.queryUsers(userQueryBuilder));
  }

  @ApiOperation("删除某一个账户 相当于注销")
  @DeleteMapping("/users/{userId}/{operator}")
  public Result removeUsers(@PathVariable("userId")int userId, @PathVariable("operator")int operator){
    return Result.of(userMangerService.removeUser(userId,operator))
        .success("{删除成功}")
        .fail("{删除失败}");
  }

  @ApiOperation("查询一个用户的信息")
  @GetMapping("/{userId}/{operator}")
  public Result findByUserId(@PathVariable("userId")int userId, @PathVariable("operator")int operator){
    return Result.data(userMangerService.findUserById(userId));
  }

}
