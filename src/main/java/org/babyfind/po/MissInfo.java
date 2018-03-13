package org.babyfind.po;

import java.util.Date;

public class MissInfo {
    private Integer mid;

    private Integer lid;

    private String missname;

    private Integer sex;

    private Date birth;

    private Date missdate;

    private String missplace;

    private String picurl;

    private String name;

    private String relationship;

    private String place;

    private String appearance;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getMissname() {
        return missname;
    }

    public void setMissname(String missname) {
        this.missname = missname == null ? null : missname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getMissdate() {
        return missdate;
    }

    public void setMissdate(Date missdate) {
        this.missdate = missdate;
    }

    public String getMissplace() {
        return missplace;
    }

    public void setMissplace(String missplace) {
        this.missplace = missplace == null ? null : missplace.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance == null ? null : appearance.trim();
    }
}