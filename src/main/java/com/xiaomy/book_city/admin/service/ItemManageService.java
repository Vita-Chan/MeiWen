package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.ItemQueryBuilder;
import com.xiaomy.book_city.admin.entity.Item;

public interface ItemManageService {
  PageInfo<Item> queryItems(ItemQueryBuilder itemQueryBuilder);

  int updateItem(Item item);

  int deleteItem(int itemId, int operator);

  int addItem(Item item);
}
