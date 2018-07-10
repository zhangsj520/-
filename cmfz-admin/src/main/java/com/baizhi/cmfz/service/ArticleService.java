package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description  文章service层
 *@Time  2018/7/4 12:30
 */
public interface ArticleService {
    /**
     *@Author    zsj
     *@Description 根据page查询所有文章
     *@Time      2018/7/8  21:29
     */
    public Map<String ,Object> queryAllArticle(Integer nowPage, Integer pageSize);
    /**
     *@Author zsj
     *@Description 添加一个文章信息
     *@Time  2018/7/8 21:29
     */
    public int addArticle(Article a);
    /**
     *@Author zsj
     *@Description 修改一个文章信息
     *@Time  2018/7/8 21:30
     */
    public int modifyArticle(Article a);
}
