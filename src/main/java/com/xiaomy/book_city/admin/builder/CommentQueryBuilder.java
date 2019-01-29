package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;

public class CommentQueryBuilder extends QueryPaging {

  @ApiModelProperty("常量: 1-正常(待审批) 0-删除 2-通过后给用户显示 3-审批未通过")
  private int state = -1; //默认等于-1 查询全部

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
}
