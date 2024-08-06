package com.study.pojo;

public class Passenger {
    private Integer pid;

    private String name;

    private Integer sex;

    private String phone;

    private String birthday;

    private String idCard;

    private String signDate;

    private Integer tid;

    public Passenger() {
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idCard='" + idCard + '\'' +
                ", signDate='" + signDate + '\'' +
                ", tid=" + tid +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Passenger(Integer pid, String name, Integer sex, String phone, String birthday, String idCard, String signDate, Integer tid) {
        this.pid = pid;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.birthday = birthday;
        this.idCard = idCard;
        this.signDate = signDate;
        this.tid = tid;
    }
}
