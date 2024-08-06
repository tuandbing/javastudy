package com.study.account3.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("保存账户成功");
    }
}
