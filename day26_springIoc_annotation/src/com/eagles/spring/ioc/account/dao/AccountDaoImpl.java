package com.eagles.spring.ioc.account.dao;

import com.eagles.spring.ioc.annotation.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("账户保存成功");
    }
}
