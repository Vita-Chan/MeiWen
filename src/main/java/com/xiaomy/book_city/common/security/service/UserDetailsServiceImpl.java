package com.xiaomy.book_city.common.security.service;

import com.xiaomy.book_city.app.service.UserService;
import com.xiaomy.book_city.common.security.entity.UserDetailsGenerate;
import com.xiaomy.book_city.common.security.factory.UserDetailsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

  /**
   * 重写 UserDetailsService的加载 UserDetails的类
   * @param username
   * @return
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDetailsGenerate userDetailsGenerate = userService.findUserDetailsByUsername(username);
    userDetailsGenerate.setRoles(userService.findRolesByUserId(userDetailsGenerate.getId()));
    if(userDetailsGenerate == null){
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    }else{
      return UserDetailsFactory.create(userDetailsGenerate);
    }
  }
}
