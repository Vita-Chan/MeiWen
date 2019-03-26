package com.xiaomy.book_city.common.security.factory;

import com.xiaomy.book_city.common.security.entity.UserDetailsGenerate;
import com.xiaomy.book_city.common.security.entity.UserDetailsImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * 生成UserDetails的工厂类
 */
public class UserDetailsFactory {
  private UserDetailsFactory(){}

  public static UserDetailsImpl create(UserDetailsGenerate userDetailsGenerate){
    return new UserDetailsImpl(
        userDetailsGenerate.getId(),
        userDetailsGenerate.getUsername(),
        userDetailsGenerate.getPasswrod(),
        mapToGrantedAuthorities(userDetailsGenerate.getRoles()),
        userDetailsGenerate.getLastPasswordResetDate()
    );
  }

  /**
   * 转换list
   * @param authorities
   * @return
   */
  private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
    return authorities.stream()
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }
}
