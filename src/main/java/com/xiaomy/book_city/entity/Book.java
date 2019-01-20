package com.xiaomy.book_city.entity;

import java.util.Date;

public class Book {
  private int id;
  private String bookname;
  private int author; //作者id 外键
  private Date createtime;
  private Date updatetime;
  private String synopsis;
  private int classify; //所属外键分类
  private String price;
  private String cover;
  private int orderBy;
  private int readNum;
  private int state;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }

  public int getAuthor() {
    return author;
  }

  public void setAuthor(int author) {
    this.author = author;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Date getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(Date updatetime) {
    this.updatetime = updatetime;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public int getClassify() {
    return classify;
  }

  public void setClassify(int classify) {
    this.classify = classify;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(int orderBy) {
    this.orderBy = orderBy;
  }

  public int getReadNum() {
    return readNum;
  }

  public void setReadNum(int readNum) {
    this.readNum = readNum;
  }
}
