package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.RoleQueryBuilder;
import com.xiaomy.book_city.admin.entity.Role;

public interface RoleManageService {

  PageInfo<Role> queryRole(RoleQueryBuilder roleQueryBuilder);

  int deleteRoleById(int roleId, int operator);

  int updateRole(Role role);

  int addRole(Role role);

}
