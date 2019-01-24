package com.xiaomy.book_city.app.controller;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Comment;
import com.xiaomy.book_city.common.result.Result;
import com.xiaomy.book_city.app.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Books")
public class BookController {

  @Autowired
  private BookService bookService;

  @ApiOperation(value = "图书列表",response = Book.class)
  @GetMapping
  public Result queryBooks(){
    return Result.data(bookService.queryBooks());
  }

  @ApiOperation("点击图书查看是否购买")
  @GetMapping("/{userId}/{bookId}")
  public Result isBuyBook(@PathVariable("userId")int userId,@PathVariable("bookId")int bookId){
    return Result.data(bookService.isByBook(userId,bookId));
  }

  @ApiOperation(value = "评论列表显示",response = Comment.class)
  @GetMapping("/comment/{bookId}/{userId}")
  public Result queryComment(@PathVariable("bookId")int bookId, @PathVariable("userId")int userId){
    return Result.data(bookService.queryComment(bookId));
  }

  @ApiOperation("发送评论, 需要后台管理审核")
  @PostMapping("/comment")
  public Result addComment(Comment comment){
    return Result.of(bookService.addComment(comment))
        .success("{添加评论成功}")
        .fail("{添加评论失败}");
  }

  @ApiOperation("删除评论")
  @DeleteMapping("/comment/{commentId}/{userId}")
  public Result removeComment(@PathVariable("commentId")int commentId, @PathVariable("userId")int userId){
    return Result.of(bookService.removeComment(commentId,userId));
  }
}
