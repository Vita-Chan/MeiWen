package com.xiaomy.book_city.admin.controller;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.CommentQueryBuilder;
import com.xiaomy.book_city.admin.entity.Comment;
import com.xiaomy.book_city.admin.service.CommentManageService;
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
@RequestMapping("/admin/comments")
public class CommentMangerController {

  @Autowired
  private CommentManageService commentManageService;

  @ApiOperation("列表查询评论以便管理 - 分页")
  @GetMapping
  public PageInfo<Comment> queryComments(CommentQueryBuilder commentQueryBuilder){
    return commentManageService.queryComments(commentQueryBuilder);
  }

  @ApiOperation("审批后修改状态")
  @PutMapping("/{commentId}/{state}")
  public Result updateComment(@PathVariable("commentId")int commentId
  ,@PathVariable("state")int state){
    return Result.of(commentManageService.updateComments(commentId,state))
        .success("审批成功")
        .fail("审批失败");
  }

  @ApiOperation("批量删除评论")
  @DeleteMapping("/{commentId}")
  public Result removeComment(@PathVariable("commentId")Integer[] commentId){
    return Result.of(commentManageService.removeComments(commentId))
        .success("删除成功")
        .fail("删除失败");
  }
}
