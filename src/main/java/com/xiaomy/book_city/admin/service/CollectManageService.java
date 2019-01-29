package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.CollectQueryBuilder;
import com.xiaomy.book_city.admin.entity.Collect;


public interface CollectManageService {
  PageInfo<Collect> queryCollects(CollectQueryBuilder collectQueryBuilder);

  int deleteCollect(int collectId, int operator);
}
