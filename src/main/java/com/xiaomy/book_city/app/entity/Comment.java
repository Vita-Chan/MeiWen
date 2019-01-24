package com.xiaomy.book_city.app.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Comment {
  @ApiModelProperty("评论id")
  private int id;
  @ApiModelProperty("bookid")
  private int bookId;
  @ApiModelProperty("状态")
  private int state;
  @ApiModelProperty("用户id")
  private int userId;
  @ApiModelProperty("创建时间")
  private Date creatTime;
  @ApiModelProperty("品论内容")
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
