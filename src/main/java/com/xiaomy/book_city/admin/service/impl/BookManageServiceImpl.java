package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.BookQueryBuilder;
import com.xiaomy.book_city.admin.entity.BookClass;
import com.xiaomy.book_city.admin.mapper.BookManageMapper;
import com.xiaomy.book_city.admin.service.BookManageService;
import com.xiaomy.book_city.app.entity.Book;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManageServiceImpl implements BookManageService {

  @Autowired
  private BookManageMapper bookManageMapper;

  @Override
  public PageInfo<Book> queryBooks(BookQueryBuilder bookQueryBuilder) {
    PageHelper.startPage(bookQueryBuilder.getPageNum(),bookQueryBuilder.getPageSize());
    List<Book> books = bookManageMapper.queryBooks(bookQueryBuilder);
    return new PageInfo<Book>(books);
  }

  @Override
  public int removeBookById(Integer[] bookId) {
    return bookManageMapper.removeBookById(bookId);
  }

  @Override
  public int updateBook(Book book) {
    book.setUpdatetime(new Date());
    return bookManageMapper.updateBook(book);
  }

  @Override
  public int addBook(Book book) {
    book.setCreatetime(new Date());
    return bookManageMapper.addBook(book);
  }

  @Override
  public List<BookClass> listBookClass() {
    return bookManageMapper.BookClass();
  }


}
