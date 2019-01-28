package com.xiaomy.book_city.admin.queryBuilder;

import com.xiaomy.book_city.common.entiy.QueryPaging;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserQueryBuilder extends QueryPaging {
  @ApiModelProperty("用户等级, 默认查询全部")
  private List<Integer> grade = Arrays.asList(1,2,3,4);

  @ApiModelProperty("创建开始时间")
  private Date createStart;

  @ApiModelProperty("创建结束时间")
  private Date createEnd;

  @ApiModelProperty("默认查询正常的")
  private int state = 1;

  public List<Integer> getGrade() {
    return grade;
  }

  public void setGrade(List<Integer> grade) {
    this.grade = grade;
  }

  public Date getCreateStart() {
    return createStart;
  }

  public void setCreateStart(Date createStart) {
    this.createStart = createStart;
  }

  public Date getCreateEnd() {
    return createEnd;
  }

  public void setCreateEnd(Date createEnd) {
    this.createEnd = createEnd;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
}
