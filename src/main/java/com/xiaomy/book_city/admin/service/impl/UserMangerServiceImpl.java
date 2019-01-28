package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.mapper.UserMangerMapper;
import com.xiaomy.book_city.admin.queryBuilder.UserQueryBuilder;
import com.xiaomy.book_city.admin.service.UserMangerService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMangerServiceImpl implements UserMangerService {

  @Autowired
  private UserMangerMapper userMangerMapper;

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
}
