package com.eagles.spring.work.account.service;

import com.eagles.spring.work.account.pojo.User;

import java.util.List;

public interface AccountService {

    void save();

    List<User> select();

    Integer insert(User user);

    Integer delete(Integer id);

    Integer update(User user);

    User findUserById(Integer id);

}
