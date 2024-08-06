package com.study.pojo;

public class Student {
    private Integer sid;
    private String sname;

    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer sid, String sname, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
    }

    public Student() {
    }
}
