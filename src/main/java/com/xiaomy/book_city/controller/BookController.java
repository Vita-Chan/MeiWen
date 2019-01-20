package com.xiaomy.book_city.controller;

import com.xiaomy.book_city.result.Result;
import com.xiaomy.book_city.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Books")
public class BookController {

  @Autowired
  private BookService bookService;

  @ApiOperation("图书列表")
  @GetMapping
  public Result queryBooks(){
    return Result.data(bookService.queryBooks());
  }

  @ApiOperation("点击图书查看是否购买")
  @GetMapping("/{userId}/{bookId}")
  public Result isBuyBook(@PathVariable("userId")int userId,@PathVariable("bookId")int bookId){
    return Result.data(bookService.isByBook(userId,bookId));
  }

  @ApiOperation("评论列表显示")
  @GetMapping("/comment/{bookId}/{userId}")
  public Result queryComment(@PathVariable("bookId")int bookId, @PathVariable("userId")int userId){
    return Result.data(bookService.queryComment(bookId));
  }
}
