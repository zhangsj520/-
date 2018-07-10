package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 *@Author  zhangshaojie
 *@Description   实体类  轮播图类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Slideshow implements Serializable {
    private String slideId;
    private String slidePath;
    @JSONField(format = "yy-MM-dd HH:mm:ss")   //相应的日期格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")  //请求的日期格式
    private Date slideDate;
    private String slideDescription;
    private String slideStatus;

    public Slideshow() {
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "slideId='" + slideId + '\'' +
                ", slidePath='" + slidePath + '\'' +
                ", slideDate=" + slideDate +
                ", slideDescription='" + slideDescription + '\'' +
                ", slideStatus='" + slideStatus + '\'' +
                '}';
    }

    public String getSlideId() {
        return slideId;
    }

    public void setSlideId(String slideId) {
        this.slideId = slideId;
    }

    public String getSlidePath() {
        return slidePath;
    }

    public void setSlidePath(String slidePath) {
        this.slidePath = slidePath;
    }

    public Date getSlideDate() {
        return slideDate;
    }

    public void setSlideDate(Date slideDate) {
        this.slideDate = slideDate;
    }

    public String getSlideDescription() {
        return slideDescription;
    }

    public void setSlideDescription(String slideDescription) {
        this.slideDescription = slideDescription;
    }

    public String getSlideStatus() {
        return slideStatus;
    }

    public void setSlideStatus(String slideStatus) {
        this.slideStatus = slideStatus;
    }

    public Slideshow(String slideId, String slidePath, Date slideDate, String slideDescription, String slideStatus) {
        this.slideId = slideId;
        this.slidePath = slidePath;
        this.slideDate = slideDate;
        this.slideDescription = slideDescription;
        this.slideStatus = slideStatus;
    }
}
