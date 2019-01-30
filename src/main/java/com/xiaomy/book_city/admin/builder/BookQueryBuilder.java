package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;


public class BookQueryBuilder extends QueryPaging {
  @ApiModelProperty("图书名称")
  private String bookname;

  @ApiModelProperty("作者的Id - 作者管理后台查询使用的")
  private int userId;

  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
