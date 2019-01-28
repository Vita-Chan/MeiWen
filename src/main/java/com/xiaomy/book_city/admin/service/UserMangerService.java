package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;

public interface UserMangerService {
  PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilde);

  int removeUser(int userId,int operator);

  UserVo findUserById(int userId);

  int updateUser(UserVo userVo);
}
