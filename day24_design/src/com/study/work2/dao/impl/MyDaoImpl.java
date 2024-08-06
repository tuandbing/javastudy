package com.study.work2.dao.impl;

import com.study.work2.annotation.Repository;
import com.study.work2.dao.MyDao;

@Repository("dao")
public class MyDaoImpl implements MyDao {

    @Override
    public void save() {
        System.out.println("保存账户成功");
    }
}
