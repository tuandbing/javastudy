package com.study.account2.service;

import com.study.account2.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        accountDao.save();
    }
}
