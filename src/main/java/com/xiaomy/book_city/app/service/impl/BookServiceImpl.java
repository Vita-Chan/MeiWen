package com.xiaomy.book_city.app.service.impl;

import com.xiaomy.book_city.app.entity.Book;
import com.xiaomy.book_city.app.entity.Comment;
import com.xiaomy.book_city.app.mapper.BookMapper;
import com.xiaomy.book_city.app.service.BookService;
import java.util.Date;
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

  @Override
  public int addComment(Comment comment) {
    comment.setCreatTime(new Date());
    return bookMapper.addComment(comment);
  }

  @Override
  public int removeComment(int commentId, int userId) {
    return 0;
  }

}
