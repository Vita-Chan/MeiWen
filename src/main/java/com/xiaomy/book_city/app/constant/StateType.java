package com.xiaomy.book_city.app.constant;

/**
 * 修改数据库的状态,重点是否是逻辑删除 0-逻辑删除 1-正常
 */
public class StateType {
  public static final int REMOVE = 0;
  public static final int OK = 1;

  public static final int VISIBLE = 3; //用于评论 管理员审批后可设置为3即可见
}
