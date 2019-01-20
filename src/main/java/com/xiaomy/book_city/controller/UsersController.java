package com.xiaomy.book_city.controller;

import com.xiaomy.book_city.entity.User;
import com.xiaomy.book_city.result.Result;
import com.xiaomy.book_city.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @ApiOperation("个人用户编辑")
  @PutMapping("/{id}")
  public Result updateUser(@RequestBody User user,@PathVariable("id")int id){
    user.setId(id);
    return Result.of(userService.updateUser(user))
        .success("{个人用户编辑成功}")
        .fail("{个人用户编辑失败}");
  }

  @ApiOperation("消费记录查询")
  @GetMapping("/buy/{userId}")
  public Result queryBuy(@PathVariable("userId") int userId){
    return Result.data(userService.queryBuys(userId));
  }

  @ApiOperation("浏览历史查询")
  @GetMapping("/browse/{userId}")
  public Result queryBrowse(@PathVariable("userId") int userId){
    return Result.data(userService.queryBrowse(userId));
  }

  @ApiOperation("收藏列表查询")
  @GetMapping("/collect/{userId}")
  public Result queryCollect(@PathVariable("userId") int userId){
    return Result.data(userService.queryCollect(userId));
  }

}
