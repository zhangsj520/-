package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 *@Author  zhangshaojie
 *@Description 管理员service层
 *@Time  2018/7/4 12:30
 */
public interface ManagerService {
    /**
    *@Author zhangshaojie
    *@Description 登录
    *@Time  2018/7/4 14:42
    *@Param 参数一：用户姓名 参数二：密码
    *@Exception
    */
    public Manager  login(String mName,String mPassword);

    /**
    *@Author  zhangshaojie
    *@Description 注册成为管理员
    *@Time  2018/7/4 14:45
    *@Param 参数1：管理员的信息
    *@Exception
    */
    public int registManager(Manager m);
}
