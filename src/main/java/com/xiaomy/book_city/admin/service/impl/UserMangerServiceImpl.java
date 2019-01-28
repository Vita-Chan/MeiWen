package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.mapper.UserMangerMapper;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.admin.service.UserMangerService;
import com.xiaomy.book_city.common.error.ConfCenterException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserMangerServiceImpl implements UserMangerService {

  @Autowired
  private UserMangerMapper userMangerMapper;

  @Override
  public PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilder) {
    Assert.isTrue(true, "不好意思,您没有此权限");
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
    return 0;
  }
}
