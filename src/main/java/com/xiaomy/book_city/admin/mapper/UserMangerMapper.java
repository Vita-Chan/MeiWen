package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.builder.UserQueryBuilder;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMangerMapper {
  List<UserVo> queryUserVo(UserQueryBuilder userQueryBuilder);

  int removeUser(@Param("userId")int userId, @Param("deleteTime")Date deleteTime);

  UserVo findUserById(@Param("userId")int userId);
}
