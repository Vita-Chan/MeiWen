package com.xiaomy.book_city.mapper;

import com.xiaomy.book_city.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  User findUserById(@Param("id")int id);
}
