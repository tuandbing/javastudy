package com.eagles.pojo;

public class Student {

    private Integer sid;

    private String stuName;

    private Integer sex;

    private String address;

    private String birthday;

    private String hobby;

    private Integer cid;

    public Student(Integer sid, String stuName, Integer sex, String address, String birthday, String hobby, Integer cid) {
        this.sid = sid;
        this.stuName = stuName;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.hobby = hobby;

        this.cid = cid;
    }

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", stuName='" + stuName + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                ", cid=" + cid +
                '}';
    }
}
