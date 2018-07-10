package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description 文章serviceImpl层
 *@Time  2018/7/4 12:30
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao ad;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryAllArticle(Integer nowPage, Integer pageSize) {
        int start = (nowPage -1)*pageSize;
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = ad.count();
        List<Article> articles = ad.selectAllArticle(start,pageSize);
        map.put("total",count);
        map.put("rows",articles);
        return map;
    }

    @Override
    public int addArticle(Article a) {
        return ad.insertOne(a);
    }

    @Override
    public int modifyArticle(Article a) {
        return ad.updateOne(a);
    }
}
