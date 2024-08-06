package com.eagles.dao;

import com.eagles.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User login(String username,String password);

}
