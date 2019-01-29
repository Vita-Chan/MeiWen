package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.CommentQueryBuilder;
import com.xiaomy.book_city.admin.entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentManageMapper {
  List<Comment> queryComments(CommentQueryBuilder commentQueryBuilder);

  int updateComment(@Param("commentId")int commentId, @Param("state")int state);
}
