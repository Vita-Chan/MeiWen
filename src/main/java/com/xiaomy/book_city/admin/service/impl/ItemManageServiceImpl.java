package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.ItemQueryBuilder;
import com.xiaomy.book_city.admin.entity.Item;
import com.xiaomy.book_city.admin.error.AdminError;
import com.xiaomy.book_city.admin.mapper.BookManageMapper;
import com.xiaomy.book_city.admin.mapper.ItemManageMapper;
import com.xiaomy.book_city.admin.service.ItemManageService;
import com.xiaomy.book_city.common.error.ConfCenterException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemManageServiceImpl implements ItemManageService {

  @Autowired
  private ItemManageMapper itemManageMapper;

  @Autowired
  private BookManageMapper bookManageMapper;

  @Override
  public PageInfo<Item> queryItems(ItemQueryBuilder itemQueryBuilder) {
    PageHelper.startPage(itemQueryBuilder.getPageNum(),itemQueryBuilder.getPageSize());
    List<Item> items = itemManageMapper.queryItems(itemQueryBuilder);
    return new PageInfo<Item>(items);
  }

  @Override
  public int updateItem(Item item) {
    if(itemManageMapper.isItem(item.getNum(),item.getBookid(),item.getTitleName())){
      throw new ConfCenterException(AdminError.THE_ITEM_ALREADY_EXIST);
    }
    return itemManageMapper.updateItem(item);
  }

  @Override
  public int deleteItem(Integer[] itemId) {
    return itemManageMapper.deleteItemById(itemId);
  }

  @Override
  public int addItem(Item item) {
    int bookid = bookManageMapper.findBookByBookName(item.getBookName());
    System.out.println(bookid);
    item.setBookid(bookid);
    if(itemManageMapper.isItem(item.getNum(),item.getBookid(),item.getTitleName())){
      throw new ConfCenterException(AdminError.THE_ITEM_ALREADY_EXIST);
    }
    item.setCreatetime(new Date());
    return itemManageMapper.addItem(item);
  }

  @Override
  public Item findItemById(int itemId) {
    return itemManageMapper.findItemById(itemId);
  }
}
