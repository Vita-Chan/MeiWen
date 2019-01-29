package com.xiaomy.book_city.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class Menu {
  @ApiModelProperty("权限id")
  private int id;

  @ApiModelProperty("创建权限时间")
  private Date createTime;

  @ApiModelProperty("权限描述")
  private String description;

  @ApiModelProperty("权限名称")
  private String name;

  private Date updateTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
