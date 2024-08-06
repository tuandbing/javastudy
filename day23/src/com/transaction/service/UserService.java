package com.transaction.service;

import com.transaction.User;

import java.util.List;

public interface UserService {

    Integer insert(User user);

    Integer delete(Integer uid);

    Integer update(User user);

    List<User> select();
}
