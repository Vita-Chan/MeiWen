package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.MenuQueryBuilder;
import com.xiaomy.book_city.admin.entity.Menu;
import com.xiaomy.book_city.admin.service.MenuManageService;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menus")
public class MenuManageController {

  @Autowired
  private MenuManageService menuManageService;

  @ApiOperation("查询所有的权限")
  @GetMapping()
  public Result queryMenu(MenuQueryBuilder menuQueryBuilder){
    return Result.data(menuManageService.queryMenu(menuQueryBuilder));
  }

  @ApiOperation("删除某一个权限")
  @DeleteMapping("/{menuId}/{operator}")
  public Result deleteMenu(@PathVariable("menuId")int menuId, @PathVariable("operator")int operator){
    return Result.of(menuManageService.deleteMenu(menuId,operator))
        .success("删除权限成功")
        .fail("删除权限失败");
  }

  @ApiOperation("修改某一个权限")
  @PutMapping("/{menuId}/{operator}")
  public Result updateMenu(Menu menu,@PathVariable("menuId")int menuId, @PathVariable("operator")int operator){
    menu.setId(menuId);
    return Result.of(menuManageService.updateMenu(menu))
        .success("修改权限成功")
        .fail("修改权限失败");
  }

  @ApiOperation("添加一个权限")
  @PostMapping()
  public Result addMenu(Menu menu){
    return Result.of(menuManageService.addMenu(menu))
        .success("添加权限成功")
        .fail("添加权限失败");
  }
}
