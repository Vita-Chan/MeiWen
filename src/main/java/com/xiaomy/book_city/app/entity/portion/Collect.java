package com.xiaomy.book_city.app.entity.portion;

import com.xiaomy.book_city.app.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Collect extends Book {
  @ApiModelProperty(value = "收藏时间",hidden = true)
  private Date collectTime;

  @ApiModelProperty("用户id")
  private int userId;

  public Date getCollectTime() {
    return collectTime;
  }

  public void setCollectTime(Date collectTime) {
    this.collectTime = collectTime;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
