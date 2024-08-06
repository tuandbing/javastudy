package com.eagles.spring.work.account.service;

import com.eagles.spring.work.account.dao.AccountDao;
import com.eagles.spring.work.account.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        accountDao.save();
    }

    @Override
    public List<User> select() {
        return accountDao.select();
    }

    @Override
    public Integer insert(User user) {
        return accountDao.insert(user);
    }

    @Override
    public Integer delete(Integer id) {
        return accountDao.delete(id);
    }

    @Override
    public Integer update(User user) {
        return accountDao.update(user);
    }

    @Override
    public User findUserById(Integer id) {
        return accountDao.findUserById(id);
    }
}
