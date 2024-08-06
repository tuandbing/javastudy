package com.study.demo.dao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("保存账户成功");
    }
}
