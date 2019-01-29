package com.xiaomy.book_city.author.controller;

import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/books")
public class AuthorManageController {

  @ApiOperation("查询自己的所有图书")
  public Result queryBooks(){
    return null;
  }
}
