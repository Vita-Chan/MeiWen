package com.xiaomy.book_city.author.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;

public class AuthorBookQueryBuilder extends QueryPaging {
  @ApiModelProperty("图书Id")
  private int bookId;

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
}
