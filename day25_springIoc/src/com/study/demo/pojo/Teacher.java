package com.study.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private Integer id;

    private String name;

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher() {
    }

    public void init(){

        System.out.println("对象初始化成功");

    }

    public void destroy(){

        System.out.println("对象销毁成功");

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
