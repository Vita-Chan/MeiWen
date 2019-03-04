package com.xiaomy.book_city.admin.entity.part;

import io.swagger.annotations.ApiModelProperty;

public class RolePart {
  @ApiModelProperty("角色id")
  private int id;

  @ApiModelProperty("角色名称")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
