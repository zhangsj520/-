package com.baizhi.cmfz.entity;

import java.io.Serializable;
/**
 *@Author  zhangshaojie
 *@Description   实体类 用户类
 *@Time      2018/7/4 11:42
 *@Param
 *@Exception
 */
public class User implements Serializable {
    private String userId;
    private String userName;
    private String userReligionName;
    private String userSalt;
    private String userPassword;
    private String userSex;
    private String userPicture;
    private String userAddress;
    private String userPhone;
    private String userStatus;
    private String userSignature;
    private String gId;

    public User() {
    }

    public User(String userId, String userName, String userReligionName, String userSalt, String userPassword, String userSex, String userPicture, String userAddress, String userPhone, String userStatus, String userSignature, String gId) {
        this.userId = userId;
        this.userName = userName;
        this.userReligionName = userReligionName;
        this.userSalt = userSalt;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userPicture = userPicture;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userStatus = userStatus;
        this.userSignature = userSignature;
        this.gId = gId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserReligionName() {
        return userReligionName;
    }

    public void setUserReligionName(String userReligionName) {
        this.userReligionName = userReligionName;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userReligionName='" + userReligionName + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", gId='" + gId + '\'' +
                '}';
    }
}
