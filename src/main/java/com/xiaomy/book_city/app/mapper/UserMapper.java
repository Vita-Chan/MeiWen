package com.xiaomy.book_city.app.mapper;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.vo.UserVo;
import com.xiaomy.book_city.app.entity.vo.BuyVo;
import com.xiaomy.book_city.app.entity.portion.Collect;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  UserVo findUserById(@Param("id")int id);

  int updateUser(UserVo userVo);

  BuyVo queryBuys(@Param("userId") int userId);

  List<Book> queryBrowse(@Param("userId") int userId);

  int addBrowse(Browse browse);

  List<Collect> queryCollect(@Param("userId") int userId);

  int removeBuy(@Param("userId") int userId,@Param("buyId") int buyId);

  int addBuy(Buy buy);

  int deleteBrowse(@Param("userId") int userId,@Param("browseId") int browseId);

  int addCollect(Collect collect);

  int removeCollect(@Param("userId") int userId, @Param("collectId") int collectId);
}
