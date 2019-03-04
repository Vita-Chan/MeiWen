package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.mapper.RoleManageMapper;
import com.xiaomy.book_city.admin.mapper.UserManageMapper;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.admin.service.UserManageService;
import java.util.Date;
import java.util.List;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements UserManageService {

  @Autowired
  private UserManageMapper userMangerMapper;

  @Autowired
  private RoleManageMapper roleManageMapper;

  @Override
  public PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilder) {
    PageHelper.startPage(userQueryBuilder.getPageNum(),userQueryBuilder.getPageSize());
    List<UserVo> userVos = userMangerMapper.queryUserVo(userQueryBuilder);
    return new PageInfo<UserVo>(userVos);
  }

  @Override
  public int removeUser(Integer[] users) {
    return userMangerMapper.removeUsers(users,new Date());
  }

  @Override
  public UserVo findUserById(int userId) {
    return userMangerMapper.findUserById(userId);
  }

  @Override
  public int updateUser(UserVo userVo) {
    userVo.setUpdateTime(new Date());
    return userMangerMapper.updateUser(userVo);
  }

  @Override
  public int addUser(UserVo userVo) {
    userVo.setCreateTime(new Date());
    return userMangerMapper.addUser(userVo);
  }

  @Override
  public UserVo findUserAndRolesByUserId(int userId) {
    UserVo userVo = userMangerMapper.findUserById(userId);
    return userVo;
  }


}
