package com.video.edu.me.entity;

import java.util.Date;

public class Video {
    private Integer id;

    private String title;

    private String comment;

    private Byte status;

    private Integer watchedTimes;

    private Date ctime;

    private Date utime;

    private String fileName;

    private String od;

    private String sd;

    private String hd;

    private String fileId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getWatchedTimes() {
        return watchedTimes;
    }

    public void setWatchedTimes(Integer watchedTimes) {
        this.watchedTimes = watchedTimes;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od == null ? null : od.trim();
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd == null ? null : sd.trim();
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd == null ? null : hd.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }
}