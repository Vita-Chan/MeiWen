package com.xiaomy.book_city.admin.builder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class RoleQueryBuilder extends QueryPaging {

  @ApiModelProperty("角色名称")
  private String name;

  @ApiModelProperty("开始创建时间")
  private Date startTime;

  @ApiModelProperty("结束创建时间")
  private Date endTime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}
