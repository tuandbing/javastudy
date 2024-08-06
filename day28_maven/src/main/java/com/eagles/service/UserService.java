package com.eagles.service;

import com.eagles.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User login(String username,String password);
}
