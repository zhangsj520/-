package com.baizhi.cmfz.entity;

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
    private String aId;
    private String aName;
    private String aIntroduce;
    private Date aDate;
    private String aPicture;
    private String gId;

    public Article() {
    }

    public Article(String aId, String aName, String aIntroduce, Date aDate, String aPicture, String gId) {
        this.aId = aId;
        this.aName = aName;
        this.aIntroduce = aIntroduce;
        this.aDate = aDate;
        this.aPicture = aPicture;
        this.gId = gId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaIntroduce() {
        return aIntroduce;
    }

    public void setaIntroduce(String aIntroduce) {
        this.aIntroduce = aIntroduce;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public String getaPicture() {
        return aPicture;
    }

    public void setaPicture(String aPicture) {
        this.aPicture = aPicture;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", aIntroduce='" + aIntroduce + '\'' +
                ", aDate=" + aDate +
                ", aPicture='" + aPicture + '\'' +
                ", gId='" + gId + '\'' +
                '}';
    }
}
