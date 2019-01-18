package com.xiaomy.book_city.service.impl;

import com.xiaomy.book_city.entity.User;
import com.xiaomy.book_city.mapper.UserMapper;
import com.xiaomy.book_city.service.UserService;
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
}
