package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author  zhangshaojie
 *@Description 上师dao层
 *@Time  2018/7/4 12:28
 */
public interface GuruDao {
    /**
    *@Author    zsj
    *@Description 查询所有上师
    *@Time      2018/7/6  22:37
    */
    public List<Guru> selectAllGuru(@Param("start") int start,@Param("pageSize") int pageSize);
    /**
    *@Author zsj
    *@Description 添加一个上师信息
    *@Time  2018/7/6 22:38
    */
    public int insertOne(Guru g);
    /**
    *@Author zsj
    *@Description 修改一个上师信息
    *@Time  2018/7/6 22:38
    */
    public int updateOne(Guru g);
    /**
     *@Author zsj
     *@Description 模糊查询
     *@Time  2018/7/6 22:38
     */
    public List<Guru> selectByKey(@Param("key") String key,@Param("value") String value,@Param("start") int start,@Param("pageSize") int pageSize);

    /**
    *@Author  zsj
    *@Description 根据条件查询所有行数
    *@Time  2018/7/6/ 23:09
    */
    public int count(@Param("key") String Key,@Param("value") String value);

}
