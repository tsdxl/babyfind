package org.babyfind.po;

public class VolunteerInfo {
    private Integer vid;

    private Integer lid;

    private String name;

    private String idcard;

    private Integer sex;

    private String place;

    private String profession;

    private String email;

    private String picurl;
    //political address age qq experience
    private String political;

    private String address;

    private int age;

    private int qq;

    private String experience;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}