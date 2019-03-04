package com.xiaomy.book_city.admin.controller;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.admin.entity.vo.UserVo;
import com.xiaomy.book_city.admin.service.BookManageService;
import com.xiaomy.book_city.app.entity.Book;
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
@RequestMapping("/admin/books")
public class BookManageController {

  @Autowired
  private BookManageService bookManageService;

  @ApiOperation("查询书本书列表 - 分页")
  @GetMapping
  public PageInfo<Book> queryBooks(BookQueryBuilder bookQueryBuilder){
    return bookManageService.queryBooks(bookQueryBuilder);
  }

  @ApiOperation("删除书本")
  @DeleteMapping("/{bookId}")
  public Result removeBookById(@PathVariable("bookId")Integer[] bookId){
    System.out.println("bookId:"+bookId.toString());
    return Result.of(bookManageService.removeBookById(bookId))
        .success("删除书本成功")
        .fail("删除书本失败");
  }

  @ApiOperation("修改书本")
  @PutMapping("/{bookId}")
  public Result updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId){
    book.setId(bookId);
    return Result.of(bookManageService.updateBook(book))
        .success("修改书本成功")
        .fail("修改书本失败");
  }
  @ApiOperation("获取分类列表")
  @GetMapping("/class")
  public Result listBookClass(){
    return Result.data(bookManageService.listBookClass());
  }

  @ApiOperation("添加图书")
  @PostMapping("/add")
  public Result addBook(@RequestBody Book book){
    return Result.of(bookManageService.addBook(book))
        .success("添加图书成功")
        .fail("添加图书失败");
  }
}
