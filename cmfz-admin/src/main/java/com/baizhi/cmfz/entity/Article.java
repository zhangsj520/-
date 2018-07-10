package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 *@Author  zhangshaojie
 *@Description   实体类 文章类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Article implements Serializable {
    private String articleId;
    private String articleTitle;
    private String articleIntroduce;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date articleDate;
    private String articleStatus;
    private String guruId;
    private Guru g = new Guru();

    public Article() {
    }

    public Article(String articleId, String articleTitle, String articleIntroduce, Date articleDate, String articleStatus, String guruId, Guru g) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleIntroduce = articleIntroduce;
        this.articleDate = articleDate;
        this.articleStatus = articleStatus;
        this.guruId = guruId;
        this.g = g;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleIntroduce() {
        return articleIntroduce;
    }

    public void setArticleIntroduce(String articleIntroduce) {
        this.articleIntroduce = articleIntroduce;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public Guru getG() {
        return g;
    }

    public void setG(Guru g) {
        this.g = g;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleIntroduce='" + articleIntroduce + '\'' +
                ", articleDate=" + articleDate +
                ", articleStatus='" + articleStatus + '\'' +
                ", guruId='" + guruId + '\'' +
                ", g=" + g +
                '}';
    }
}
