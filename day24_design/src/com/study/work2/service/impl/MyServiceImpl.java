package com.study.work2.service.impl;

import com.study.work2.annotation.Autowired;
import com.study.work2.annotation.Service;
import com.study.work2.dao.MyDao;
import com.study.work2.service.MyService;

@Service("service")
public class MyServiceImpl implements MyService {

    @Autowired
    private MyDao myDao;

    @Override
    public void save() {
        myDao.save();
    }
}
