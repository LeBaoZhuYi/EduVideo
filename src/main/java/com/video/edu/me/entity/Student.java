package com.video.edu.me.entity;

import java.util.Date;

public class Student {
    private Integer id;

    private Integer userId;

    private String studyId;

    private String stuName;

    private Byte status;

    private Date ctime;

    private Date utime;

    private String stuIntro;

    private String remark;

    private String parentWords;

    private String phone;

    private String birthday;

    private String food;

    private String interest;

    private String disagree;

    private String ideal;

    private String imgUrls;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId == null ? null : studyId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
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

    public String getStuIntro() {
        return stuIntro;
    }

    public void setStuIntro(String stuIntro) {
        this.stuIntro = stuIntro == null ? null : stuIntro.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParentWords() {
        return parentWords;
    }

    public void setParentWords(String parentWords) {
        this.parentWords = parentWords == null ? null : parentWords.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getDisagree() {
        return disagree;
    }

    public void setDisagree(String disagree) {
        this.disagree = disagree == null ? null : disagree.trim();
    }

    public String getIdeal() {
        return ideal;
    }

    public void setIdeal(String ideal) {
        this.ideal = ideal == null ? null : ideal.trim();
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls == null ? null : imgUrls.trim();
    }
}