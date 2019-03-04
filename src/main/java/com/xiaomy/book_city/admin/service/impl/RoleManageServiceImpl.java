package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.RoleQueryBuilder;
import com.xiaomy.book_city.admin.entity.Role;
import com.xiaomy.book_city.admin.error.AdminError;
import com.xiaomy.book_city.admin.mapper.RoleManageMapper;
import com.xiaomy.book_city.admin.service.RoleManageService;
import com.xiaomy.book_city.common.error.ConfCenterException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleManageServiceImpl implements RoleManageService {

  @Autowired
  private RoleManageMapper roleManageMapper;

  @Override
  public List<Role> queryRole(RoleQueryBuilder roleQueryBuilder) {
    List<Role> roles = roleManageMapper.queryRole(roleQueryBuilder);
    return roles;
  }

  @Transactional
  @Override
  public int deleteRoleById(int roleId, int operator) {
    int row = roleManageMapper.deleteRoleById(roleId);
    return roleManageMapper.deleteRoleResourceByRoleId(roleId);
  }

  @Transactional
  @Override
  public int updateRole(Role role) {
    if(roleManageMapper.isRole(role.getName())){
      throw new ConfCenterException(AdminError.THE_ROLE_ALREADY_EXIST);
    }
    role.setUpdateTime(new Date());
    roleManageMapper.updateRole(role);
    return updateMenu(role.getId(),role.getMenuIds());
  }

  @Transactional
  @Override
  public int addRole(Role role) {
    if(roleManageMapper.isRole(role.getName())){
      throw new ConfCenterException(AdminError.THE_ROLE_ALREADY_EXIST);
    }
    role.setCreateTime(new Date());
    roleManageMapper.addRole(role);
    return roleManageMapper.addRoleResource(role.getId(),role.getMenuIds());
  }


  public int updateMenu(int roleId,Set<Integer> menus){
    int row = roleManageMapper.deleteRoleResourceByRoleId(roleId);
    if(row > 0){
      row = roleManageMapper.addRoleResource(roleId,menus);
    }
    return row;
  }
}
