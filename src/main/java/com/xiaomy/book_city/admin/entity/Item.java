package com.xiaomy.book_city.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Item {
  @ApiModelProperty("章节id")
  private int id;

  @ApiModelProperty("所属书的id")
  private int bookid;

  @ApiModelProperty("第几章")
  private int num;

  @ApiModelProperty("创建时间")
  private Date createtime;

  @ApiModelProperty("章节名称")
  private String titleName;

  @ApiModelProperty("章节内容")
  private String content;

  @ApiModelProperty("是否收费")
  private int freeRead;

  @ApiModelProperty("文章部分图片")
  private String textImg;

  // ----------------------------------- 冗余字段 ---------------------------------------
  private String bookName;
  // ----------------------------------- 冗余字段 ---------------------------------------

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public String getTitleName() {
    return titleName;
  }

  public void setTitleName(String titleName) {
    this.titleName = titleName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getFreeRead() {
    return freeRead;
  }

  public void setFreeRead(int freeRead) {
    this.freeRead = freeRead;
  }

  public String getTextImg() {
    return textImg;
  }

  public void setTextImg(String textImg) {
    this.textImg = textImg;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", bookid=" + bookid +
        ", num=" + num +
        ", createtime=" + createtime +
        ", titleName='" + titleName + '\'' +
        ", content='" + content + '\'' +
        ", freeRead=" + freeRead +
        ", textImg='" + textImg + '\'' +
        ", bookName='" + bookName + '\'' +
        '}';
  }
}
