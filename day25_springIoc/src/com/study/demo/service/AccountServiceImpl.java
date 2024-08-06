package com.study.demo.service;

import com.study.demo.dao.AccountDao;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        accountDao.save();
    }
}
