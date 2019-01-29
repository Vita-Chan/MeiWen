package com.xiaomy.book_city.admin.mapper;

import com.xiaomy.book_city.admin.builder.CollectQueryBuilder;
import com.xiaomy.book_city.admin.entity.Collect;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectManageMapper {
  List<Collect> queryCollects(CollectQueryBuilder collectQueryBuilder);

  int deleteCollectById(@Param("collectId")int collectId);
}
