package com.xiaomy.book_city.common.security.service.impl;

import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.service.UserManageService;
import com.xiaomy.book_city.app.service.UserService;
import com.xiaomy.book_city.common.error.ConfCenterException;
import com.xiaomy.book_city.common.security.entity.UserDetailsImpl;
import com.xiaomy.book_city.common.security.service.AuthService;
import com.xiaomy.book_city.common.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 权限的要用到的功能
 */
@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserService userService;

  @Autowired
  private UserManageService userManageService;

  @Value("${jwt.tokenHead}")
  private String tokenHead;

  @Transactional
  @Override
  public int register(UserVo userVo) {

    String username = userVo.getUserName();
    if(userService.findUserByUsername(username) != null){
      throw new ConfCenterException("用户名已被使用");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String rawPassword = userVo.getPassword();
    userVo.setPassword(bCryptPasswordEncoder.encode(rawPassword));
    return userManageService.addUser(userVo);
  }

  /**
   * 登录成功后 也要存入token
   * @param username
   * @param password
   * @return
   */
  @Transactional
  @Override
  public UserVo login(String username, String password) {
    if(username.equals("") || username.equals(null) || password.equals("") || password.equals(null)){
      throw new ConfCenterException("用户名或密码不能为空");
    }
    if(userService.findUsernameAndPassword(username,password) != null){
      throw new ConfCenterException("账号或密码输入错误");
    }
    UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
    Authentication authentication = null;
    try {
      authentication = authenticationManager.authenticate(upToken);
    }catch (Exception e){
      e.printStackTrace();
    }
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    String token = jwtTokenUtil.generateToken(userDetails);
    UserVo userVo = userService.findUserVoByUsername(username);
    userService.updateByUserToken(userVo.getId(),token);
    UserVo userVo1 = userManageService.findUserAndRolesByUserId(userVo.getId());
    return userVo1;
  }

  @Transactional
  @Override
  public String refresh(String oldToken) {
    String token = oldToken.substring(tokenHead.length());
    String username = jwtTokenUtil.getUsernameFromToken(token);
    UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
    String refresh = jwtTokenUtil.refreshToken(token);    UserVo userVo = userService.findUserVoByUsername(username);
    userService.updateByUserToken(userVo.getId(),token);
    return null;
  }
}
