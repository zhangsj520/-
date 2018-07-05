package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 *@Author  zhangshaojie
 *@Description 管理员dao层
 *@Time  2018/7/4 12:28
 */
public interface ManagerDao {

    /**
    *@Author zhangshaojie
    *@Description 通过名字查找管理员
    *@Time  2018/7/4 13:52
    *@Param  参数一：管理员的姓名
    *@Exception
    */
    public Manager  selectManager(@Param("mName") String mName);

    /**
     *@Author zhangshaojie
     *@Description 插入一条数据
     *@Time  2018/7/4 14:27
     *@Param  参数一：管理员的所有信息
     *@Exception
     */
    public int insertManager(Manager m);
}
