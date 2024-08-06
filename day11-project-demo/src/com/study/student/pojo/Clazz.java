package com.study.student.pojo;

public class Clazz {

    private Integer cid;

    private String className;

    public Clazz(Integer cid, String className) {
        this.cid = cid;
        this.className = className;
    }

    public Clazz() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", className='" + className + '\'' +
                '}';
    }
}
