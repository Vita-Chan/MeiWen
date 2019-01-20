package com.xiaomy.book_city.service;

import com.xiaomy.book_city.entity.Book;
import com.xiaomy.book_city.entity.Buy;
import com.xiaomy.book_city.entity.User;
import com.xiaomy.book_city.entity.portion.Collect;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserService {
  User findUserById(int id);

  int updateUser(User user);

  Buy queryBuys(int id);

  List<Book> queryBrowse(int userId);

  List<Collect> queryCollect(int userId);
}
