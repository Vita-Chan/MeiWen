package com.xiaomy.book_city.service.impl;

import com.xiaomy.book_city.entity.Book;
import com.xiaomy.book_city.entity.Buy;
import com.xiaomy.book_city.entity.User;
import com.xiaomy.book_city.entity.portion.Collect;
import com.xiaomy.book_city.mapper.UserMapper;
import com.xiaomy.book_city.service.UserService;
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
  public Buy queryBuys(int id) {
    return userMapper.queryBuys(id);
  }

  @Override
  public List<Book> queryBrowse(int userId) {
    return userMapper.queryBrowse(userId);
  }

  @Override
  public List<Collect> queryCollect(int userId) {
    return userMapper.queryCollect(userId);
  }
}
