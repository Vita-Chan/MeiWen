package com.xiaomy.book_city.app.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Buy {
  @ApiModelProperty("交易id")
  private int id;
  @ApiModelProperty("用户id")
  private int userId;
  @ApiModelProperty("book id")
  private int bookId;
  @ApiModelProperty("交易时间")
  private Date creatTime;
  @ApiModelProperty("价钱")
  private double price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
