package com.baizhi.cmfz.dao;
import  com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
*@Author  zsj
*@Description 菜单层
*@Time 2018/7/5 13:53
*/
public interface MenuDao {
    /**
    *@Author  zsj
    *@Description  查找一级菜单
    *@Time  2018/7/5 13:54
    */
    public List<Menu> selectAll();
    /**
    *@Author zsj
    *@Description  通过父类id查找二级菜单
    *@Time  2018/7/5  13:54
    *@Param 父类id
    *@Exception
    */
    public List<Menu> selectByParentId(@Param("menuParentId")String menuParentId);
}
