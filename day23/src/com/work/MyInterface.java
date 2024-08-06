package com.work;

import com.work.pojo.User;

import java.util.List;

public interface MyInterface {

    List<User> select(Integer id);

    void update(User user);

    void insert(User user);

    void delete(Integer id);


}
