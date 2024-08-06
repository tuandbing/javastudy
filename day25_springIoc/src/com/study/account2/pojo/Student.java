package com.study.account2.pojo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Student {

    private String name;

    private Integer age;

    private List list;

    private Map map;

    private String[] strings;

    private Date date;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", map=" + map +
                ", strings=" + Arrays.toString(strings) +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student(String name, Integer age, List list, Map map, String[] strings, Date date) {
        this.name = name;
        this.age = age;
        this.list = list;
        this.map = map;
        this.strings = strings;
        this.date = date;
    }

    public Student() {
    }
}
