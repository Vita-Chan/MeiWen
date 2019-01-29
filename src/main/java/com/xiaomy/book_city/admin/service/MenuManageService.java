package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.MenuQueryBuilder;
import com.xiaomy.book_city.admin.entity.Menu;
import org.apache.ibatis.annotations.Param;


public interface MenuManageService {
  PageInfo<Menu> queryMenu(MenuQueryBuilder menuQueryBuilder);

  int deleteMenu(int menuId, int operator);

  int updateMenu(Menu menu);

  int addMenu(Menu menu);
}
