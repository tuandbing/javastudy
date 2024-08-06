package com.transaction.dao;

import com.transaction.User;

import java.util.List;

public interface UserDao {

    Integer insert(User user);
    Integer delete(Integer uid);
    Integer update(User user);
    List<User> select();

}
