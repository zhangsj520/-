package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Slideshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author  zhangshaojie
 *@Description 轮播图dao层
 *@Time  2018/7/4 12:28
 */
public interface SlideshowDao {
    /**
    *@Author zsj
    *@Description 增加轮播图
    *@Time  2018/7/5 18:33
    */
    public int insertSlideshow(Slideshow s);
    /**
    *@Author  zsj
    *@Description 修改轮播图
    *@Time  2018/7/5 18:34
    */
    public int updateSlideshow(Slideshow s);
    /**
     *@Author  zsj
     *@Description 查看所有轮播图
     *@Time  2018/7/5 18:34
     */
    public List<Slideshow>  selectAllSlideshowByPage(@Param("start") int start,@Param("rows") int rows);
    /**
     *@Author  zsj
     *@Description 查看总记录条数
     *@Time  2018/7/5 19:38
     */
    public int selectCounts(); /**
     *@Author  zsj
     *@Description 根据id查询轮播图
     *@Time  2018/7/6 18:53
     */
    public Slideshow selectSlideById(@Param("slideId") String slideId);

}
