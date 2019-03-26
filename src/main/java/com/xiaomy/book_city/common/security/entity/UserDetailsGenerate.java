package com.xiaomy.book_city.common.security.entity;

import java.util.Date;
import java.util.List;

/**
 * 通过 UserDetailsFactory 创建UserDetails
 */
public class UserDetailsGenerate {
  private int id;

  private String username;

  private String passwrod;

  private String token;

  private List<String> roles;

  private Date lastPasswordResetDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswrod() {
    return passwrod;
  }

  public void setPasswrod(String passwrod) {
    this.passwrod = passwrod;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public Date getLastPasswordResetDate() {
    return lastPasswordResetDate;
  }

  public void setLastPasswordResetDate(Date lastPasswordResetDate) {
    this.lastPasswordResetDate = lastPasswordResetDate;
  }
}
