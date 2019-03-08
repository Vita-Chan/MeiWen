package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.ItemQueryBuilder;
import com.xiaomy.book_city.admin.entity.Item;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemManageMapper {
  List<Item> queryItems(ItemQueryBuilder itemQueryBuilder);

  int deleteItemById(@Param("itemId")Integer[] itemId);

  int updateItem(Item item);

  int addItem(Item item);

  boolean isItem(@Param("num") int num,@Param("bookId")int bookId,@Param("titleName")String titleName);

  Item findItemById(@Param("itemId")int itemId);
}
