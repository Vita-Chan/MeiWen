package com.xiaomy.book_city.author.controller;

import com.xiaomy.book_city.admin.builder.ItemQueryBuilder;
import com.xiaomy.book_city.admin.entity.Item;
import com.xiaomy.book_city.admin.service.ItemManageService;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/items")
public class AuthorItemManageController {

  @Autowired
  private ItemManageService itemManageService;

  @ApiOperation("查询属于当前这个书的所有章节")
  @GetMapping("/{bookId}/{operator}")
  public Result queryItems(
      @PathVariable("bookId")int bookId, @PathVariable("operator")int operator, ItemQueryBuilder itemQueryBuilder){
    itemQueryBuilder.setBookId(bookId);
    return Result.data(itemManageService.queryItems(itemQueryBuilder));
  }

  @ApiOperation("添加章节")
  @PostMapping("/{operator}")
  public Result addItem(Item item,@PathVariable("operator")int operator){
    return Result.of(itemManageService.addItem(item))
        .success("添加章节成功")
        .fail("添加章节失败");
  }

  @ApiOperation("修改章节")
  @PutMapping("/{itemId}/{operator}")
  public Result updateItem(Item item,@PathVariable("itemId")int itemId,@PathVariable("operator")int operator){
    return Result.of(itemManageService.updateItem(item))
        .success("修改章节成功")
        .fail("修改章节失败");
  }

  @ApiOperation("删除章节")
  @DeleteMapping("/{itemId}/{operator}")
  public Result deleteItemById(@PathVariable("itemId")int itemId,@PathVariable("operator")int operator){
    return Result.of(itemManageService.deleteItem(itemId,operator))
        .success("删除章节成功")
        .fail("删除章节失败");
  }
}
