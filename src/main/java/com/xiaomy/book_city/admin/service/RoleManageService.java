package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.RoleQueryBuilder;
import com.xiaomy.book_city.admin.entity.Role;
import java.util.List;

public interface RoleManageService {

  List<Role> queryRole(RoleQueryBuilder roleQueryBuilder);

  int deleteRoleById(int roleId, int operator);

  int updateRole(Role role);

  int addRole(Role role);

}
