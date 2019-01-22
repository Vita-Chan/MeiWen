package com.xiaomy.book_city.app.controller;

import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.User;
import com.xiaomy.book_city.common.result.Result;
import com.xiaomy.book_city.app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @ApiOperation("逻辑删除消费记录")
  @DeleteMapping("buy/{userId}/{buyId}")
  public Result removeBuy(@PathVariable("userId") int userId,@PathVariable("buyId") int buyId){
    return Result.of(userService.removeBuy(userId,buyId))
        .success("{删除消费记录成功}")
        .fail("{删除消费记录失败}");
  }

  @ApiOperation("添加消费记录")
  @PostMapping("/buy")
  public Result addBuy(@RequestBody Buy buy){
    return Result.of(userService.addBuy(buy))
        .success("{添加消费记录成功}")
        .fail("{添加消费记录失败}");
  }

  @ApiOperation("浏览历史查询")
  @GetMapping("/browse/{userId}")
  public Result queryBrowse(@PathVariable("userId") int userId){
    return Result.data(userService.queryBrowse(userId));
  }

  @ApiOperation("添加浏览历史")
  @PostMapping("/browse")
  public Result addBrowse(@RequestBody Browse browse){
    return Result.of(userService.addBrowse(browse))
        .success("{添加浏览历史成功}")
        .fail("{添加浏览历史失败}");
  }

  @ApiOperation("删除浏览历史, 物理删除")
  @DeleteMapping("/delete/{userId}/{browseId}")
  public Result deleteBrowse(@PathVariable("userId") int userId,@PathVariable("browseId") int browseId){
    return Result.of(userService.deleteBrowse(userId,browseId))
        .success("{删除浏览历史成功}")
        .fail("{删除浏览历史失败}");
  }

  @ApiOperation("收藏列表查询")
  @GetMapping("/collect/{userId}")
  public Result queryCollect(@PathVariable("userId") int userId){
    return Result.data(userService.queryCollect(userId));
  }

}
