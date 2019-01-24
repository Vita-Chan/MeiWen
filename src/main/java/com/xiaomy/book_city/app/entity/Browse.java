package com.xiaomy.book_city.app.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.util.Date;

public class Browse {
  @ApiModelProperty("历史记录id")
  private int id;
  @ApiModelProperty("书的id")
  private int bookId;
  @ApiModelProperty("用户id")
  private int userId;
  @ApiModelProperty("创建时间")
  private Date creatTime;

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

  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }
}
