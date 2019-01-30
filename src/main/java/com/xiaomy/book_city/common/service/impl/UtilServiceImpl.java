package com.xiaomy.book_city.common.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.xiaomy.book_city.common.constant.QiniuConfig;
import com.xiaomy.book_city.common.error.ConfCenterException;
import com.xiaomy.book_city.common.service.UtilService;
import java.io.FileInputStream;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {
  @Override
  public String uploadImg(FileInputStream inputStream, String key) {
    UploadManager uploadManager = new UploadManager(new Configuration(Zone.zone2()));

    try {
      Auth auth = Auth.create(QiniuConfig.ACCESS_KEY, QiniuConfig.SECRET_KEY);
      String upToken = auth.uploadToken(QiniuConfig.BUCKET);
      try {
        Response response = uploadManager.put(inputStream,key,upToken,null,null);
        DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        String imgpath = QiniuConfig.PATH+"/"+defaultPutRet.key;
        return imgpath;
      } catch (QiniuException ex) {
        Response r = ex.response;
      }
    } catch (Exception e) {
      throw new ConfCenterException(QiniuConfig.UPLOAD_ERROR);
    }
    return "";
  }
}
