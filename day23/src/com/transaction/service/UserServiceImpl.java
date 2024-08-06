package com.transaction.service;
import com.transaction.User;
import com.transaction.dao.UserDao;
import com.transaction.dao.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Integer insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public Integer delete(Integer uid) {
        return userDao.delete(uid);
    }

    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> select() {
        return userDao.select();
    }
}
