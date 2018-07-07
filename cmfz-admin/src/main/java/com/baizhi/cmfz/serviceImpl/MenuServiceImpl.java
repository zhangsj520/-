package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
*@Author  zsj
*@Description 查找菜单的业务层
*@Time 2018/7/5 13:57
*@Param
*@Exception
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> queryMenu() {
           return  menuDao.selectAll();
    }
}
