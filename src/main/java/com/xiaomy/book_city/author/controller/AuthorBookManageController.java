package com.xiaomy.book_city.author.controller;

import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.admin.service.BookManageService;
import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.common.result.Result;
import com.xiaomy.book_city.common.service.UtilService;
import io.swagger.annotations.ApiOperation;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/author/books")
public class AuthorBookManageController {

  @Autowired
  private BookManageService bookManageService;

  @Autowired
  private UtilService utilService;

  @ApiOperation("查询自己的所有图书")
  @GetMapping("/{operator}")
  public Result queryBooks(@PathVariable("operator")int operator, BookQueryBuilder bookQueryBuilder){
    bookQueryBuilder.setUserId(operator);
    return Result.data(bookManageService.queryBooks(bookQueryBuilder));
  }

  @ApiOperation("修改图书")
  @PutMapping("/{bookId}")
  public Result updateBook(@PathVariable("bookId")int bookId, Book book){
    book.setId(bookId);
    return Result.of(bookManageService.updateBook(book))
        .success("修改图书成功")
        .fail("修改图书失败");
  }

  @ApiOperation("删除图书 - 逻辑删除")
  @DeleteMapping("/{bookId}/{operator}")
  public Result removeBookById(@PathVariable("bookId")int bookId, @PathVariable("operator")int operator){
    return Result.of(bookManageService.removeBookById(bookId,operator))
        .success("删除图书成功")
        .fail("删除图书失败");
  }

  @ApiOperation("添加图书")
  @PostMapping("/{operator}")
  public Result addBook(@PathVariable("operator")int operator, Book book){
    book.setAuthor(operator);
    return Result.of(bookManageService.addBook(book))
        .success("添加图书成功")
        .fail("添加图书失败");
  }

  @ApiOperation("上传图书图片")
  @PutMapping("/upload")
  public Result uploadBookCover(@RequestParam("file") MultipartFile multipartFile) throws IOException {
    return  Result.data(utilService.uploadImg(
        (FileInputStream) multipartFile.getInputStream(), "img" + new Date().getTime()));
  }
}
