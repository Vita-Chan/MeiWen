package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;


public class BookQueryBuilder extends QueryPaging {
  @ApiModelProperty("图书名称")
  private String bookname;

  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }
}
