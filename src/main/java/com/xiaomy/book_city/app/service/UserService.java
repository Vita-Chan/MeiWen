package com.xiaomy.book_city.app.service;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.vo.BuyVo;
import com.xiaomy.book_city.app.entity.UserVo;
import com.xiaomy.book_city.app.entity.portion.Collect;
import java.util.List;

public interface UserService {
  UserVo findUserById(int id);

  int updateUser(UserVo userVo);

  BuyVo queryBuys(int id);

  List<Book> queryBrowse(int userId);

  int addBrowse(Browse browse);

  int deleteBrowse(int userId, int buyId);

  List<Collect> queryCollect(int userId);

  int addCollect(Collect collect);

  int removeBuy(int userId, int buyId);

  int addBuy(Buy buy);

}
