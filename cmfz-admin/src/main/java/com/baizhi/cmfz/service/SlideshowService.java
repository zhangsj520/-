package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Slideshow;

import java.util.List;
import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description 轮播图service层
 *@Time  2018/7/4 12:30
 */
public interface SlideshowService {
    /**
     *@Author zsj
     *@Description 增加轮播图
     *@Time  2018/7/5 18:52
     */
    public int addSlideshow(Slideshow s);
    /**
     *@Author  zsj
     *@Description 修改轮播图
     *@Time  2018/7/5 18:52
     *@Param
     *@Exception
     */
    public int modifySlideshow(Slideshow s);
    /**
     *@Author  zsj
     *@Description 查看所有轮播图
     *@Time  2018/7/5 18:52
     *@Param
     *@Exception
     */
    public Map<String,Object> queryAllSlideshowByPage(int nowPage, int pageSize);
    /**
     *@Author  zsj
     *@Description 根据id查询轮播图
     *@Time  2018/7/6 18:51
     *@Param
     *@Exception
     */
    public Slideshow querymodifySlideshow(String slideId);
}
