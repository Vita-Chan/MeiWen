package com.xiaomy.book_city.mapper;

import com.xiaomy.book_city.entity.Book;
import com.xiaomy.book_city.entity.Buy;
import com.xiaomy.book_city.entity.User;
import com.xiaomy.book_city.entity.portion.Collect;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  User findUserById(@Param("id")int id);

  int updateUser(User user);

  Buy queryBuys(@Param("userId") int userId);

  List<Book> queryBrowse(@Param("userId") int userId);

  List<Collect> queryCollect(@Param("userId") int userId);
}
