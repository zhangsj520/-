package com.baizhi.cmfz.entity;

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
    private String sId;
    private String sPath;
    private Date sDate;
    private String sDescription;
    private String sStatus;

    public Slideshow() {
    }

    public Slideshow(String sId, String sPath, Date sDate, String sDescription, String sStatus) {
        this.sId = sId;
        this.sPath = sPath;
        this.sDate = sDate;
        this.sDescription = sDescription;
        this.sStatus = sStatus;
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "sId='" + sId + '\'' +
                ", sPath='" + sPath + '\'' +
                ", sDate=" + sDate +
                ", sDescription='" + sDescription + '\'' +
                ", sStatus='" + sStatus + '\'' +
                '}';
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPath() {
        return sPath;
    }

    public void setsPath(String sPath) {
        this.sPath = sPath;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus;
    }
}
