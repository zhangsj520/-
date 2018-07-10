package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*@Author    zsj
*@Description 日志dao层
*@Time  2018/7/9 20:51
*/
public interface LogDao {
    /**
    *@Author zsj
    *@Description  查询所有日志
    *@Time  2018/7/9 20:54
    *@Param 页码 每页条数
    *@Exception
    */
    public List<Log>  selectAllLogs(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
    *@Author    zsj
    *@Description   添加日志
    *@Time  2018/7/9 20:56
    */
    public int insertLog(Log l);
    /**
    *@Author  zsj
    *@Description 查询条数
    *@Time  2018/7/10 8:51
    */
    public int count();
}
