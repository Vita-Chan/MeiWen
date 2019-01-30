package com.xiaomy.book_city.common.service;

import java.io.FileInputStream;

public interface UtilService {
  String uploadImg(FileInputStream inputStream, String key);
}
