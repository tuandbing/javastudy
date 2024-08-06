package com.study.service;

import com.study.pojo.Student;

import java.util.ArrayList;

public interface service {
    ArrayList<Student> findAll();

    String login(String username, String password);
}

