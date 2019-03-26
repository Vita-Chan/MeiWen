package com.xiaomy.book_city.app.service;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.vo.BuyVo;
import com.xiaomy.book_city.app.entity.vo.UserVo;
import com.xiaomy.book_city.app.entity.portion.Collect;
import com.xiaomy.book_city.common.security.entity.UserDetailsGenerate;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

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

  int deleteCollect(int userId, int collectId);

  String findUserByUsername(String username);

  com.xiaomy.book_city.admin.entity.vo.UserVo findUsernameAndPassword(String username,String password);

  UserDetailsGenerate findUserDetailsByUsername(String username);

  List<String> findRolesByUserId(int userId);

  com.xiaomy.book_city.admin.entity.vo.UserVo findUserVoByUsername(String username);

  int updateByUserToken(@Param("id") int id, @Param("token") String token);
}
