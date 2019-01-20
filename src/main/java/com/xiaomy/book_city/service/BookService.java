package com.xiaomy.book_city.service;

import com.xiaomy.book_city.entity.Book;
import com.xiaomy.book_city.entity.Comment;
import java.util.List;

public interface BookService {
  List<Book> queryBooks();

  /**是否购买了这个图书*/
  boolean isByBook(int userId,int bookId);

  List<Comment> queryComment(int bookId);
}
