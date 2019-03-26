package com.xiaomy.book_city.common.security.service;


import com.xiaomy.book_city.admin.entity.vo.UserVo;

public interface AuthService {

  /**
   * 注册
   * @return
   */
  int register(UserVo userVo);

  /**
   * 登录
   * @param username
   * @param password
   * @return
   */
  UserVo login(String username, String password);

  /**
   * 刷新token
   * @param oldToken
   * @return
   */
  String refresh(String oldToken);
}
