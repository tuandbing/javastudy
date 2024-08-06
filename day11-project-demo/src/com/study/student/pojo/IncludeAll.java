package com.study.student.pojo;

public class IncludeAll {
    private Integer sid;

    private String stu_name;

    private Integer sex;

    private String address;

    private String birthday;

    private String hobby;

    private Integer cid;
    private String cName;

    public Integer getSid() {
        return sid;
    }

    @Override
    public String toString() {
        return "IncludeAll{" +
                "sid=" + sid +
                ", studentName='" + stu_name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                ", cid=" + cid +
                ", className='" + cName + '\'' +
                '}';
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public IncludeAll() {
    }

    public IncludeAll(Integer sid, String stu_name, Integer sex, String address, String birthday, String hobby, Integer cid, String cName) {
        this.sid = sid;
        this.stu_name = stu_name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.hobby = hobby;
        this.cid = cid;
        this.cName = cName;
    }
}
