package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
/**
 *@Author  zhangshaojie
 *@Description   实体类 上师类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Guru implements Serializable {
    private String guruId;
    @Excel(name="上师法名")
    private String guruReligionName;
    @Excel(name="上师头像")
    private String guruPicture;
    @Excel(name="上师简介")
    private String guruDescription;

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruReligionName='" + guruReligionName + '\'' +
                ", guruPicture='" + guruPicture + '\'' +
                ", guruDescription='" + guruDescription + '\'' +
                '}';
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruReligionName() {
        return guruReligionName;
    }

    public void setGuruReligionName(String guruReligionName) {
        this.guruReligionName = guruReligionName;
    }

    public String getGuruPicture() {
        return guruPicture;
    }

    public void setGuruPicture(String guruPicture) {
        this.guruPicture = guruPicture;
    }

    public String getGuruDescription() {
        return guruDescription;
    }

    public void setGuruDescription(String guruDescription) {
        this.guruDescription = guruDescription;
    }

    public Guru() {
    }

    public Guru(String guruId, String guruReligionName, String guruPicture, String guruDescription) {
        this.guruId = guruId;
        this.guruReligionName = guruReligionName;
        this.guruPicture = guruPicture;
        this.guruDescription = guruDescription;
    }
}
