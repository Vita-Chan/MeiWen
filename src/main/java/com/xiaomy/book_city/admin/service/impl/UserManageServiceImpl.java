package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.mapper.UserManageMapper;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.admin.service.UserManageService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements UserManageService {

  @Autowired
  private UserManageMapper userMangerMapper;

  @Override
  public PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilder) {
    PageHelper.startPage(userQueryBuilder.getPageNum(),userQueryBuilder.getPageSize());
    List<UserVo> userVos = userMangerMapper.queryUserVo(userQueryBuilder);
    return new PageInfo<UserVo>(userVos);
  }

  @Override
  public int removeUser(int userId, int operator) {
    return userMangerMapper.removeUser(userId,new Date());
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
}
