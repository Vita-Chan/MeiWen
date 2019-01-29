package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.CollectQueryBuilder;
import com.xiaomy.book_city.admin.entity.Collect;
import com.xiaomy.book_city.admin.mapper.CollectManageMapper;
import com.xiaomy.book_city.admin.service.CollectManageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectManageServiceImpl implements CollectManageService {

  @Autowired
  private CollectManageMapper collectManageMapper;

  @Override
  public PageInfo<Collect> queryCollects(CollectQueryBuilder collectQueryBuilder) {
    PageHelper.startPage(collectQueryBuilder.getPageNum(),collectQueryBuilder.getPageSize());
    List<Collect> collects = collectManageMapper.queryCollects(collectQueryBuilder);
    return new PageInfo<Collect>(collects);
  }

  @Override
  public int deleteCollect(int collectId, int operator) {
    return collectManageMapper.deleteCollectById(collectId);
  }
}
