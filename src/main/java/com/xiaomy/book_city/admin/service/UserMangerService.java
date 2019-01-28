package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.queryBuilder.UserQueryBuilder;
import java.util.List;

public interface UserMangerService {
  PageInfo<UserVo> queryUsers(UserQueryBuilder userQueryBuilde);

  int removeUser(int userId,int operator);
}
