package com.xiaomy.book_city.admin.entity.vo;

import com.xiaomy.book_city.admin.entity.Role;
import com.xiaomy.book_city.admin.entity.part.RolePart;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;

public class UserVo {
  @ApiModelProperty("用户id")
  private int id;
  @ApiModelProperty("住址")
  private String address;
  @ApiModelProperty("创建时间")
  private Date createTime;
  @ApiModelProperty("描述")
  private String description;
  @ApiModelProperty("email")
  private String email;
  @ApiModelProperty("用户锁定")
  private int locked;
  @ApiModelProperty("用户昵称")
  private String nickName;
  @ApiModelProperty("性别")
  private int sex;
  @ApiModelProperty("手机号")
  private String telephone;
  @ApiModelProperty("修改时间")
  private Date updateTime;
  @ApiModelProperty("账号")
  private String userName;
  @ApiModelProperty("密码")
  private String password;
  @ApiModelProperty("等级")
  private String level;

  // -------------------------------------- 冗余字段 -----------------------------------
  @ApiModelProperty("所属等级: 1-超级管理员 2-普通管理员 3-作者 4-读者")
  private String grade;

  private int state = 1;
  // -------------------------------------- 冗余字段 -----------------------------------


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getLocked() {
    return locked;
  }

  public void setLocked(int locked) {
    this.locked = locked;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}
