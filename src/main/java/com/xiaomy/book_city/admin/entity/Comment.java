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

  // ---------------------- 冗余字段 --------------------------
  @ApiModelProperty("图书名称")
  private String bookName;

  @ApiModelProperty("用户名")
  private String userName;

  @ApiModelProperty("审核结果-中文显示")
  private String stateName;
  // ---------------------- 冗余字段 --------------------------

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
    if(state == 1){
      this.stateName = "未审核";
    }
    if(state == 2){
      this.stateName = "审核通过";
    }
    if(state == 3){
      this.stateName = "未通过";
    }
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

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }
}
