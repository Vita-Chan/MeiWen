package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import com.xiaomy.book_city.common.entiy.QueryPaging;

public interface UserManageService {
  PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilder);

  int removeUser(Integer[] users);

  UserVo findUserById(int userId);

  int updateUser(UserVo userVo);

  int addUser(UserVo userVo);

  UserVo findUserAndRolesByUserId(int userId);
}
