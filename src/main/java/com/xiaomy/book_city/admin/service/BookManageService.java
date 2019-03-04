package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.admin.entity.BookClass;
import com.xiaomy.book_city.app.entity.Book;
import java.util.List;

public interface BookManageService {
  PageInfo<Book> queryBooks(BookQueryBuilder bookQueryBuilder);

  int removeBookById(Integer[] bookId);

  int updateBook(Book book);

  int addBook(Book book);

  List<BookClass> listBookClass();
}
