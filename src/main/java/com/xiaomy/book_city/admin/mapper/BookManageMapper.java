package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.app.entity.Book;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookManageMapper {

  List<Book> queryBooks(BookQueryBuilder bookQueryBuilder);

  int removeBookById(@Param("bookId") int bookId);

  int updateBook(Book book);

  int addBook(Book book);
}
