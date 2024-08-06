package com.study.service.impl;

import com.study.dao.impl.daoImpl;
import com.study.pojo.Student;
import com.study.service.service;

import java.util.ArrayList;

public class serviceImpl implements service {

    private final daoImpl dao= new daoImpl();
    @Override
    public ArrayList<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public String login(String username, String password) {
        return dao.login(username,password);
    }
}
