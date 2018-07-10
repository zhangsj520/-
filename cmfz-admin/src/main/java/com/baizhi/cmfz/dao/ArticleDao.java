package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*@Author  zhangshaojie
*@Description 文章dao层
*@Time  2018/7/4 12:28
*/
public interface ArticleDao {
    /**
     * @Author zsj
     * @Description 查询所有文章
     * @Time 2018/7/8  21:17
     */
    public List<Article> selectAllArticle(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
     *@Author zsj
     *@Description 添加一条文章
     *@Time  2018/7/8 21:18
     */
    public int insertOne(Article a);
    /**
     *@Author zsj
     *@Description 修改一条文章信息
     *@Time  2018/7/8 21:19
     */
    public int updateOne(Article a);
    /**
     *@Author  zsj
     *@Description 查询所有行数
     *@Time  2018/7/8 21:19
     */
    public int count();
}
