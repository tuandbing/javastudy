package com.study.student.pojo;

public class Student {

    private Integer sid;

    private String studentName;

    private Integer sex;

    private String address;

    private String birthday;

    private String hobby;

    private Integer cid;

    private Clazz clazz;//聚合班级的引用

    public Student(Integer sid, String studentName, Integer sex, String address, String birthday, String hobby, Integer cid) {
        this.sid = sid;
        this.studentName = studentName;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.hobby = hobby;
        this.cid = cid;
    }

    public Student(Integer sid, String studentName, Integer sex, String address, String birthday, String hobby, Integer cid, Clazz clazz) {
        this.sid = sid;
        this.studentName = studentName;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.hobby = hobby;
        this.cid = cid;
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
                ", studentName='" + studentName + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                ", cid=" + cid +
                ", clazz=" + clazz +
                '}';
    }
}

