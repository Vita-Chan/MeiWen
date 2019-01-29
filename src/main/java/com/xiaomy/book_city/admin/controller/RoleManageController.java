package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.RoleQueryBuilder;
import com.xiaomy.book_city.admin.entity.Role;
import com.xiaomy.book_city.admin.service.RoleManageService;
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
@RequestMapping("/admin/roles")
public class RoleManageController {

  @Autowired
  private RoleManageService roleManageService;

  @ApiOperation("查询显示所有角色")
  @GetMapping
  public Result queryRoles(RoleQueryBuilder roleQueryBuilder){
    return Result.data(roleManageService.queryRole(roleQueryBuilder));
  }

  @ApiOperation("删除角色, 物理删除")
  @DeleteMapping("/{roleId}/{operator}")
  public Result deleteRoleById(@PathVariable("roleId")int roleId, @PathVariable("operator")int operator){
    return Result.of(roleManageService.deleteRoleById(roleId,operator))
        .success("删除角色成功")
        .fail("删除角色失败");
  }

  @ApiOperation("修改角色")
  @PutMapping("/{roleId}/{operator}")
  public Result updateRole(Role role, @PathVariable("roleId")int roleId, @PathVariable("operator")int operator){
    role.setId(roleId);
    return Result.of(roleManageService.updateRole(role))
        .success("修改角色成功")
        .fail("修改角色失败");
  }

  @ApiOperation("添加角色")
  @PostMapping("/{operator}")
  public Result addRole(Role role, @PathVariable("operator")int operator){
    return Result.of(roleManageService.addRole(role))
        .success("添加角色成功")
        .fail("添加角色失败");
  }
}
