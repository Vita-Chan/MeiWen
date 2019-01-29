package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.service.UserManageService;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user/manger")
public class UserManageController {

  @Autowired
  private UserManageService userManageService;

  @ApiOperation("获取所有的用户信息 - 分页查询")
  @GetMapping()
  public Result queryUsers(UserQueryBuilder userQueryBuilder){
    return Result.data(userManageService.queryUsers(userQueryBuilder));
  }

  @ApiOperation("删除某一个账户 相当于注销")
  @DeleteMapping("/users/{userId}/{operator}")
  public Result removeUsers(@PathVariable("userId")int userId, @PathVariable("operator")int operator){
    return Result.of(userManageService.removeUser(userId,operator))
        .success("{删除成功}")
        .fail("{删除失败}");
  }

  @ApiOperation("查询一个用户的信息")
  @GetMapping("/{userId}/{operator}")
  public Result findByUserId(@PathVariable("userId")int userId, @PathVariable("operator")int operator){
    return Result.data(userManageService.findUserById(userId));
  }

  @ApiOperation("修改一个user信息")
  @PutMapping("/{operator}")
  public Result updateUser(@RequestBody UserVo userVo, @PathVariable("operator")int operator){
    userVo.setOperator(operator);
    return Result.of(userManageService.updateUser(userVo))
        .success("{修改用户成功}")
        .fail("{修改用户失败}");
  }
}
