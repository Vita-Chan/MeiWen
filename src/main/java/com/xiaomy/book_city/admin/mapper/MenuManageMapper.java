package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.MenuQueryBuilder;
import com.xiaomy.book_city.admin.entity.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuManageMapper {
  List<Menu> queryMenu(MenuQueryBuilder menuQueryBuilder);

  int deleteMenuById(@Param("menuId")int menuId);

  int updateMenuById(Menu menu);

  int addMenu(Menu menu);

  boolean isMenu(@Param("name") String name);
}
