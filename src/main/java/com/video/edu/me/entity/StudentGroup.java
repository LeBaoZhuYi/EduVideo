package com.video.edu.me.entity;

import java.util.Date;

public class StudentGroup {
    private Integer id;

    private Byte status;

    private Date ctime;

    private Date utime;

    private String name;

    private String studentIdList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(String studentIdList) {
        this.studentIdList = studentIdList == null ? null : studentIdList.trim();
    }
}