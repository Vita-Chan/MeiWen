package com.xiaomy.book_city.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomy.book_city.admin.builder.MenuQueryBuilder;
import com.xiaomy.book_city.admin.entity.Menu;
import com.xiaomy.book_city.admin.error.AdminError;
import com.xiaomy.book_city.admin.mapper.MenuManageMapper;
import com.xiaomy.book_city.admin.service.MenuManageService;
import com.xiaomy.book_city.common.error.ConfCenterException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuManageServiceImpl implements MenuManageService {

  @Autowired
  private MenuManageMapper menuManageMapper;

  @Override
  public PageInfo<Menu> queryMenu(MenuQueryBuilder menuQueryBuilder) {
    PageHelper.startPage(menuQueryBuilder.getPageNum(),menuQueryBuilder.getPageSize());
    List<Menu> menus = menuManageMapper.queryMenu(menuQueryBuilder);
    return new PageInfo<Menu>(menus);
  }

  @Override
  public int deleteMenu(int menuId, int operator) {
    return menuManageMapper.deleteMenuById(menuId);
  }

  @Override
  public int updateMenu(Menu menu) {
    menu.setUpdateTime(new Date());
    return menuManageMapper.updateMenuById(menu);
  }

  @Override
  public int addMenu(Menu menu) {
    if(menuManageMapper.isMenu(menu.getName())){
      throw new ConfCenterException(AdminError.THE_MENU_ALREADY_EXIST);
    }
    return menuManageMapper.addMenu(menu);
  }
}
