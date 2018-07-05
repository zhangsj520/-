package com.baizhi.cmfz.entity;

import java.io.Serializable;
/**
 *@Author  zhangshaojie
 *@Description   实体类 分类类别类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Classify implements Serializable {
    private String cId;
    private String cName;
    private String cDifferent;
    private String userId;

    public Classify() {
    }

    public Classify(String cId, String cName, String cDifferent, String userId) {
        this.cId = cId;
        this.cName = cName;
        this.cDifferent = cDifferent;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cDifferent='" + cDifferent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDifferent() {
        return cDifferent;
    }

    public void setcDifferent(String cDifferent) {
        this.cDifferent = cDifferent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
