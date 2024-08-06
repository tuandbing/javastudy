package com.study.dao;

import com.study.pojo.Student;

import java.util.ArrayList;

public interface dao {
    ArrayList<Student> findAll();

    String login(String username, String password);

}
