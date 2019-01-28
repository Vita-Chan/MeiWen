package com.xiaomy.book_city.common.entiy;

import io.swagger.annotations.ApiModelProperty;

public class QueryPaging {
  @ApiModelProperty("从什么地方开始查")
  private int pageNum;

  @ApiModelProperty("查询多少条")
  private int pageSize;

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}
