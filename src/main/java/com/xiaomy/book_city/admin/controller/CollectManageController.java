package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.CollectQueryBuilder;
import com.xiaomy.book_city.admin.service.CollectManageService;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/collects")
public class CollectManageController {

  @Autowired
  private CollectManageService collectManageService;

  @ApiOperation("查询所有的收藏")
  @GetMapping
  public Result queryCollect(CollectQueryBuilder collectQueryBuilder){
    return Result.data(collectManageService.queryCollects(collectQueryBuilder));
  }

  @ApiOperation("删除收藏")
  @DeleteMapping("/{collectId}/{operator}")
  public Result deleteCollect(@PathVariable("collectId")int collectId, @PathVariable("operator")int operator){
    return Result.data(collectManageService.deleteCollect(collectId,operator))
        .success("删除收藏成功")
        .fail("删除收藏失败");
  }
}
