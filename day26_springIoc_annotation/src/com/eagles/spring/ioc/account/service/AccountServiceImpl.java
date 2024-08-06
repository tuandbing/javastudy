package com.eagles.spring.ioc.account.service;

import com.eagles.spring.ioc.account.dao.AccountDao;
import com.eagles.spring.ioc.annotation.Autowired;
import com.eagles.spring.ioc.annotation.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
    }
}
