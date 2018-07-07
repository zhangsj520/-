package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.SlideshowDao;
import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description 轮播图serviceImpl层
 *@Time  2018/7/4 12:30
 */
@Service
@Transactional
public class SlideshowServiceImpl implements SlideshowService {
    @Autowired
    private SlideshowDao sd;
    /**
     *@Author zsj
     *@Description 增加轮播图
     *@Time  2018/7/5 18:52
     */
    @Override
    public int addSlideshow(Slideshow s) {
        return sd.insertSlideshow(s);
    }

    /**
     *@Author zsj
     *@Description 修改轮播图
     *@Time  2018/7/5 18:55
     */
    @Override
    public int modifySlideshow(Slideshow s) {
        return sd.updateSlideshow(s);
    }
    /**
     *@Author zsj
     *@Description 查找所有轮播图
     *@Time  2018/7/5 18:52
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String,Object> queryAllSlideshowByPage(int nowPage, int pageSize) {
        int start = (nowPage -1)*pageSize;
        List<Slideshow> list = sd.selectAllSlideshowByPage(start, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        int i = sd.selectCounts();
        map.put("total",i);
        map.put("rows",list);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Slideshow querymodifySlideshow(String slideId) {
        return sd.selectSlideById(slideId);
    }
}
