package com.xiaomy.book_city.admin.service;

import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.app.entity.Book;

public interface BookManageService {
  PageInfo<Book> queryBooks(BookQueryBuilder bookQueryBuilder);

  int removeBookById(int bookId, int operator);

  int updateBook(Book book);

  int addBook(Book book);
}
