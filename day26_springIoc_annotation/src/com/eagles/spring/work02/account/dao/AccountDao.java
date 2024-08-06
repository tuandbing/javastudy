package com.eagles.spring.work02.account.dao;

import com.eagles.spring.work02.pojo.User;

import java.util.List;

public interface AccountDao {

    void save();

    List<User> select();

    Integer insert(User user);

    Integer delete(Integer id);

    Integer update(User user);

    User findUserById(Integer id);
}
