package com.xiaomy.book_city.service.impl;

import com.xiaomy.book_city.entity.Book;
import com.xiaomy.book_city.entity.Comment;
import com.xiaomy.book_city.mapper.BookMapper;
import com.xiaomy.book_city.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookMapper bookMapper;

  @Override
  public List<Book> queryBooks() {
    return bookMapper.queryBook();
  }

  @Override
  public boolean isByBook(int userId, int bookId) {
    return bookMapper.isByBook(userId,bookId);
  }

  @Override
  public List<Comment> queryComment(int bookId) {
    return bookMapper.queryComment(bookId);
  }

}
