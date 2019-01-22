package com.xiaomy.book_city.app.entity.portion;

import com.xiaomy.book_city.app.entity.Book;
import java.util.Date;

public class Collect extends Book {
  private Date collectTime;

  public Date getCollectTime() {
    return collectTime;
  }

  public void setCollectTime(Date collectTime) {
    this.collectTime = collectTime;
  }
}
