package com.xiaomy.book_city.app.service.impl;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Browse;
import com.xiaomy.book_city.app.entity.Buy;
import com.xiaomy.book_city.app.entity.vo.BuyVo;
import com.xiaomy.book_city.app.entity.vo.UserVo;
import com.xiaomy.book_city.app.entity.portion.Collect;
import com.xiaomy.book_city.app.mapper.UserMapper;
import com.xiaomy.book_city.app.service.UserService;
import com.xiaomy.book_city.common.security.entity.UserDetailsGenerate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserVo findUserById(int id) {
    return userMapper.findUserById(id);
  }

  @Override
  public int updateUser(UserVo user) {
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
  public int addCollect(Collect collect) {
    collect.setCollectTime(new Date());
    return userMapper.addCollect(collect);
  }

  @Override
  public int removeBuy(int userId, int buyId) {
    return userMapper.removeBuy(userId,buyId);
  }

  @Override
  public int addBuy(Buy buy) {
    return userMapper.addBuy(buy);
  }

  @Override
  public int deleteCollect(int userId, int collectId) {
    return userMapper.deleteBrowse(userId,collectId);
  }

  @Override
  public String findUserByUsername(String username) {
    return userMapper.findUserByUsername(username);
  }

  @Override
  public com.xiaomy.book_city.admin.entity.vo.UserVo findUsernameAndPassword(String username, String password) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String encodePassword = bCryptPasswordEncoder.encode(password);
    return userMapper.findUsernameAndPassword(username,encodePassword);
  }

  @Override
  public UserDetailsGenerate findUserDetailsByUsername(String username) {
    return userMapper.findUserUserDetailsGenerateByUsername(username);
  }

  @Override
  public List<String> findRolesByUserId(int userId) {
    return userMapper.findRolesByUserId(userId);
  }

  @Override
  public com.xiaomy.book_city.admin.entity.vo.UserVo findUserVoByUsername(String username) {
    return userMapper.findUserVoByUsername(username);
  }

  @Override
  public int updateByUserToken(int id, String token) {
    return userMapper.updateUserToken(id,token);
  }

}
