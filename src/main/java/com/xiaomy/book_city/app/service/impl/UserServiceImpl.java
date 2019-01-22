package com.xiaomy.book_city.app.service.impl;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.vo.BuyVo;
import com.xiaomy.book_city.app.entity.User;
import com.xiaomy.book_city.app.entity.portion.Collect;
import com.xiaomy.book_city.app.mapper.UserMapper;
import com.xiaomy.book_city.app.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User findUserById(int id) {
    return userMapper.findUserById(id);
  }

  @Override
  public int updateUser(User user) {
    user.setUpdateTime(new Date());
    return userMapper.updateUser(user);
  }

  @Override
  public BuyVo queryBuys(int id) {
    return userMapper.queryBuys(id);
  }

  @Override
  public List<Book> queryBrowse(int userId) {
    return userMapper.queryBrowse(userId);
  }

  @Override
  public int addBrowse(Browse browse) {
    return userMapper.addBrowse(browse);
  }

  @Override
  public int deleteBrowse(int userId, int buyId) {
    return userMapper.deleteBrowse(userId,buyId);
  }

  @Override
  public List<Collect> queryCollect(int userId) {
    return userMapper.queryCollect(userId);
  }

  @Override
  public int removeBuy(int userId, int buyId) {
    return userMapper.removeBuy(userId,buyId);
  }

  @Override
  public int addBuy(Buy buy) {
    return userMapper.addBuy(buy);
  }
}
