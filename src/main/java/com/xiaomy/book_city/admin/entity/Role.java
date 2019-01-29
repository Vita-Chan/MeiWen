package com.xiaomy.book_city.admin.entity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Role {
  @ApiModelProperty("角色id")
  private int id;

  @ApiModelProperty("角色名称")
  private String name;

  @ApiModelProperty("角色描述")
  private String description;

  @ApiModelProperty("角色创建时间")
  private Date createTime;

  @ApiModelProperty(value = "修改时间",hidden = true)
  private Date updateTime;

  @ApiModelProperty(value = "角色的Id")
  private Set<Integer> menuIds;

  // ----------------------------------- 冗余字段 --------------------------------------------
  @ApiModelProperty("这个角色所拥有的权限")
  private List<Menu> menus;
  // ----------------------------------- 冗余字段 --------------------------------------------

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public List<Menu> getMenus() {
    return menus;
  }

  public void setMenus(List<Menu> menus) {
    this.menus = menus;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Set<Integer> getMenuIds() {
    return menuIds;
  }

  public void setMenuIds(Set<Integer> menuIds) {
    this.menuIds = menuIds;
  }
}
