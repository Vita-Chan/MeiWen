package com.xiaomy.book_city.admin.controller;

import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.admin.service.BookManageService;
import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/books")
public class BookManageController {

  @Autowired
  private BookManageService bookManageService;

  @ApiOperation("查询书本书列表 - 分页")
  @GetMapping
  public Result queryBooks(BookQueryBuilder bookQueryBuilder){
    return Result.data(bookManageService.queryBooks(bookQueryBuilder));
  }

  @ApiOperation("删除书本")
  @DeleteMapping("/{bookId}/{operator}")
  public Result removeBookById(@PathVariable("bookId")int bookId, @PathVariable("operator")int operator){
    return Result.of(bookManageService.removeBookById(bookId,operator))
        .success("删除书本成功")
        .fail("删除书本失败");
  }

  @ApiOperation("修改书本")
  @PutMapping("/{bookId}/{operator}")
  public Result updateBook(Book book,@PathVariable("bookId")int bookId, @PathVariable("operator")int operator){
    book.setId(bookId);
    return Result.of(bookManageService.updateBook(book))
        .success("修改书本成功")
        .fail("修改书本失败");
  }
}
