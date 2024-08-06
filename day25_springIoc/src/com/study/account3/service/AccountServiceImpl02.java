package com.study.account3.service;

import com.study.account3.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service02")
public class AccountServiceImpl02 implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public AccountServiceImpl02() {
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        accountDao.save();
    }
}
