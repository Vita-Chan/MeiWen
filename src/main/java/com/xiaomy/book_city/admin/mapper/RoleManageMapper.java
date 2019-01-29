package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.RoleQueryBuilder;
import com.xiaomy.book_city.admin.entity.Role;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleManageMapper {
  List<Role> queryRole(RoleQueryBuilder roleQueryBuilder);

  int deleteRoleById(@Param("roleId")int roleId);

  int deleteRoleResourceByRoleId(@Param("roleId")int roleId);

  int updateRole(Role role);

  int addRoleResource(@Param("roleId")int roleId, @Param("menus")Set<Integer> menus);

  int addRole(Role role);

  boolean isRole(@Param("roleName") String roleName);
}
