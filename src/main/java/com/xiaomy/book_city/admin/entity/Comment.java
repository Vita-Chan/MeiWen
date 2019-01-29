package com.xiaomy.book_city.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Comment {
  @ApiModelProperty("评论id")
  private int id;

  @ApiModelProperty("书的Id")
  private int bookId;

  @ApiModelProperty("常量: 1-正常(待审批) 0-删除 2-通过后给用户显示 3-审批未通过")
  private int state;

  @ApiModelProperty("用户id")
  private int userId;

  @ApiModelProperty("评论时间")
  private Date creatTime;

  @ApiModelProperty("评论内容")
  private String content;

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

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
