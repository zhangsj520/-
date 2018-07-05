package com.baizhi.cmfz.entity;

import java.io.Serializable;
/**
*@Author  zhangshaojie
*@Description   实体类 专辑类
*@Time      2018/7/4 11:42
*@Param
*@Exception
*/
public class Album implements Serializable {
    private String albumId;
    private String albumName;
    private String albumAuthor;
    private String albumCv;
    private String albumCount;
    private String albumScore;
    private String albumSrc;
    private String albumPublishTime;
    private String albumContent;

    public Album() {
    }

    public Album(String albumId, String albumName, String albumAuthor, String albumCv, String albumCount, String albumScore, String albumSrc, String albumPublishTime, String albumContent) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumAuthor = albumAuthor;
        this.albumCv = albumCv;
        this.albumCount = albumCount;
        this.albumScore = albumScore;
        this.albumSrc = albumSrc;
        this.albumPublishTime = albumPublishTime;
        this.albumContent = albumContent;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumCv() {
        return albumCv;
    }

    public void setAlbumCv(String albumCv) {
        this.albumCv = albumCv;
    }

    public String getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(String albumCount) {
        this.albumCount = albumCount;
    }

    public String getAlbumScore() {
        return albumScore;
    }

    public void setAlbumScore(String albumScore) {
        this.albumScore = albumScore;
    }

    public String getAlbumSrc() {
        return albumSrc;
    }

    public void setAlbumSrc(String albumSrc) {
        this.albumSrc = albumSrc;
    }

    public String getAlbumPublishTime() {
        return albumPublishTime;
    }

    public void setAlbumPublishTime(String albumPublishTime) {
        this.albumPublishTime = albumPublishTime;
    }

    public String getAlbumContent() {
        return albumContent;
    }

    public void setAlbumContent(String albumContent) {
        this.albumContent = albumContent;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumAuthor='" + albumAuthor + '\'' +
                ", albumCv='" + albumCv + '\'' +
                ", albumCount='" + albumCount + '\'' +
                ", albumScore='" + albumScore + '\'' +
                ", albumSrc='" + albumSrc + '\'' +
                ", albumPublishTime='" + albumPublishTime + '\'' +
                ", albumContent='" + albumContent + '\'' +
                '}';
    }
}
