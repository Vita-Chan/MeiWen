package com.xiaomy.book_city.admin.controller;

import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/items")
public class ItemManageController {

  @Autowired
  private ItemManageService itemManageService;

  @ApiOperation("查询所有章节")
  @GetMapping
  public PageInfo<Item> queryItem(ItemQueryBuilder itemQueryBuilder){
    return itemManageService.queryItems(itemQueryBuilder);
  }

  @ApiOperation("添加章节")
  @PostMapping()
  public Result addItem(@RequestBody Item item){
    System.out.println(item.toString());
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
