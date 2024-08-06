package com.study.pojo;

public class Emp {
    private Integer eid;
    private String ename;
    private Integer age;
    private String sex;
    private String address;
    private String birthday;
    private Double salary;
    private Integer did;

    public Emp(Integer eid, String ename, Integer age, String sex, String address, String birthday, Double salary, Integer did) {
        this.eid = eid;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.salary = salary;
        this.did = did;
    }

    public Emp() {
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", salary=" + salary +
                ", did=" + did +
                '}';
    }
}
