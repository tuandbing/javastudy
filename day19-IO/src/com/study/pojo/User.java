package com.study.pojo;

import java.io.Serial;
import java.io.Serializable;

/**
 * transient: 修饰属性的关键字,被修饰的属性将不会参与序列化
 */

// 需要实现Serializable接口才可以实现序列化(标志)
public class User implements Serializable {

    // 写死这个uid,在序列化后如果修改该文件内容,读取时不会出现问题
    @Serial
    private static final long serialVersionUID = 1231238723623487L;
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
