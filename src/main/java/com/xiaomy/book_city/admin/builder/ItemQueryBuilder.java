package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;

public class ItemQueryBuilder extends QueryPaging {
  @ApiModelProperty("外键: 书的id")
  private int bookId;

  @ApiModelProperty("章节名称")
  private String titleName;

  @ApiModelProperty("第几章")
  private int num;

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getTitleName() {
    return titleName;
  }

  public void setTitleName(String titleName) {
    this.titleName = titleName;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
