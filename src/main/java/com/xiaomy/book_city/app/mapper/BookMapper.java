package com.xiaomy.book_city.app.mapper;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {

  List<Book> queryBook();

  /**是否购买了这个图书*/
  boolean isByBook(@Param("userId") int userId,@Param("bookId") int bookId);

  /**查看评论列表*/
  List<Comment> queryComment(@Param("bookId")int bookId);
 }
