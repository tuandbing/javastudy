package com.study.work2.servlet;

import com.study.work2.annotation.Autowired;
import com.study.work2.annotation.Controller;
import com.study.work2.service.MyService;

@Controller("servlet")
public class MyServlet {

    @Autowired
    private MyService myService;

    public void save() {

        myService.save();

    }
}
