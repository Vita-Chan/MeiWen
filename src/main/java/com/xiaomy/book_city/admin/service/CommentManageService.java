package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.CommentQueryBuilder;
import com.xiaomy.book_city.admin.entity.Comment;

public interface CommentManageService {
  PageInfo<Comment> queryComments(CommentQueryBuilder commentQueryBuilder);

  int updateComments(int commentId, int state);

  int removeComments(Integer[] commentId);
}
