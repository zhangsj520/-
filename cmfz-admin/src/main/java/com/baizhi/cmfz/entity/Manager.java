package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
/**
 *@Author  zhangshaojie
 *@Description   实体类 管理员类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class Manager implements Serializable {
    private String mId;
    private String mName;
    private String mSalt;
    private String mStatus;
    private String mPassword;

    public Manager() {
    }

    public Manager(String mId, String mName, String mSalt, String mStatus, String mPassword) {
        this.mId = mId;
        this.mName = mName;
        this.mSalt = mSalt;
        this.mStatus = mStatus;
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mSalt='" + mSalt + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSalt() {
        return mSalt;
    }

    public void setmSalt(String mSalt) {
        this.mSalt = mSalt;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
