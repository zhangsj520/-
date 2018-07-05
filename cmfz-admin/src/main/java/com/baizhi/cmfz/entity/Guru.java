package com.baizhi.cmfz.entity;

import java.io.Serializable;
/**
 *@Author  zhangshaojie
 *@Description   实体类 上师类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Guru implements Serializable {
    private String gId;
    private String gReligionName;
    private String gPicture;
    private String gDescription;

    public Guru() {
    }

    public Guru(String gId, String gReligionName, String gPicture, String gDescription) {
        this.gId = gId;
        this.gReligionName = gReligionName;
        this.gPicture = gPicture;
        this.gDescription = gDescription;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "gId='" + gId + '\'' +
                ", gReligionName='" + gReligionName + '\'' +
                ", gPicture='" + gPicture + '\'' +
                ", gDescription='" + gDescription + '\'' +
                '}';
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgReligionName() {
        return gReligionName;
    }

    public void setgReligionName(String gReligionName) {
        this.gReligionName = gReligionName;
    }

    public String getgPicture() {
        return gPicture;
    }

    public void setgPicture(String gPicture) {
        this.gPicture = gPicture;
    }

    public String getgDescription() {
        return gDescription;
    }

    public void setgDescription(String gDescription) {
        this.gDescription = gDescription;
    }
}
