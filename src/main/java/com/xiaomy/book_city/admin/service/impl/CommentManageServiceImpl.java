package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.CommentQueryBuilder;
import com.xiaomy.book_city.admin.entity.Comment;
import com.xiaomy.book_city.admin.mapper.CommentManageMapper;
import com.xiaomy.book_city.admin.service.CommentManageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentManageServiceImpl implements CommentManageService {

  @Autowired
  private CommentManageMapper commentManageMapper;

  @Override
  public PageInfo<Comment> queryComments(CommentQueryBuilder commentQueryBuilder) {
    PageHelper.startPage(commentQueryBuilder.getPageNum(),commentQueryBuilder.getPageSize());
    List<Comment> comments = commentManageMapper.queryComments(commentQueryBuilder);
    return new PageInfo<Comment>(comments);
  }

  @Override
  public int updateComments(int commentId, int state) {
    return commentManageMapper.updateComment(commentId,state);
  }

  @Override
  public int removeComments(Integer[] commentId) {
    return commentManageMapper.removeComment(commentId);
  }
}
