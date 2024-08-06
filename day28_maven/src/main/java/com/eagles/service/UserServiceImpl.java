package com.eagles.service;

import com.eagles.dao.UserDao;
import com.eagles.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
