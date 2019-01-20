package com.xiaomy.book_city.entity;

import java.util.List;

/**
 * 消费记录表
 * date: 2019/1/20
 */
public class Buy {
  private int amount;

  private int buyNum;

  private List<Book> books;

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getBuyNum() {
    return buyNum;
  }

  public void setBuyNum(int buyNum) {
    this.buyNum = buyNum;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
