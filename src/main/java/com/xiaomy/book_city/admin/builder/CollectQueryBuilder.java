package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;

public class CollectQueryBuilder extends QueryPaging {

  @ApiModelProperty("所属用户")
  private int userId;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
