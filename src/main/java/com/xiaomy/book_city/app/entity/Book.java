package com.xiaomy.book_city.app.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Book {
  @ApiModelProperty("图书id")
  private int id;

  @ApiModelProperty("图书名称")
  private String bookname;

  @ApiModelProperty("作者名称")
  private String author; //作者名称

  @ApiModelProperty("创建时间")
  private Date createtime;

  @ApiModelProperty("修改时间")
  private Date updatetime;

  @ApiModelProperty("简介")
  private String synopsis;

  @ApiModelProperty("分类id")
  private int classify; //所属外键分类

  @ApiModelProperty("价格, 为空则免费")
  private String price;

  @ApiModelProperty("封面")
  private String cover;

  @ApiModelProperty("排序")
  private int orderBy;

  @ApiModelProperty("阅读数")
  private int readNum;

  @ApiModelProperty("状态")
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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
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

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", bookname='" + bookname + '\'' +
        ", author='" + author + '\'' +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", synopsis='" + synopsis + '\'' +
        ", classify=" + classify +
        ", price='" + price + '\'' +
        ", cover='" + cover + '\'' +
        ", orderBy=" + orderBy +
        ", readNum=" + readNum +
        ", state=" + state +
        '}';
  }
}
