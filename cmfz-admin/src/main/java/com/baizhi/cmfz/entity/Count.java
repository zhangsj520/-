package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;
/**
 *@Author  zhangshaojie
 *@Description   实体类 计数器类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Count implements Serializable {
    private String couId;
    private String couName;
    private Integer couNum;
    private Date couDate;
    private String cId;
    private String userId;

    public Count() {
    }

    public Count(String couId, String couName, Integer couNum, Date couDate, String cId, String userId) {
        this.couId = couId;
        this.couName = couName;
        this.couNum = couNum;
        this.couDate = couDate;
        this.cId = cId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Count{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                ", couNum=" + couNum +
                ", couDate=" + couDate +
                ", cId='" + cId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public Integer getCouNum() {
        return couNum;
    }

    public void setCouNum(Integer couNum) {
        this.couNum = couNum;
    }

    public Date getCouDate() {
        return couDate;
    }

    public void setCouDate(Date couDate) {
        this.couDate = couDate;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
