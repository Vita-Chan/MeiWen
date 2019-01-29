package com.xiaomy.book_city.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Collect {
  @ApiModelProperty("收藏的id")
  private int id;

  @ApiModelProperty("book的id")
  private int bookId;

  @ApiModelProperty("收藏人的id")
  private int userId;

  @ApiModelProperty("创建时间")
  private Date createTime;

  // ------------------------------ 冗余字段 --------------------------------
  @ApiModelProperty("用户姓名")
  private String userName;

  @ApiModelProperty("书的名称")
  private String bookName;
  // ------------------------------ 冗余字段 --------------------------------


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
}
