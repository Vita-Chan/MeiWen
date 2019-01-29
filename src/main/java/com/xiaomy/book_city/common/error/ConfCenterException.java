package com.xiaomy.book_city.common.error;

/**
 * 自定义异常信息
 */
public class ConfCenterException extends RuntimeException {

  private static final long serialVersionUID = 8037891447646609768L;

  private int code = -1;
  private boolean status = false;

  public ConfCenterException() { }

  /**
   *  定义异常信息
   */
  public ConfCenterException(String errMsg) {
    super(errMsg);
  }

  /**
   * 原始的异常信息
   */
  public ConfCenterException(Throwable cause) {
    super(cause);
  }

  /**
   * 定义异常信息 和 原始的异常信息
   * @param errMsg 异常消息
   * @param cause 原始异常
   */
  public ConfCenterException(String errMsg, Throwable cause) {
    super(errMsg, cause);
  }
}
