package com.eagles.spring.ioc.account.servlet;

import com.eagles.spring.ioc.account.service.AccountService;
import com.eagles.spring.ioc.annotation.Autowired;
import com.eagles.spring.ioc.annotation.Controller;

@Controller
public class AccountServlet {

    @Autowired
    private AccountService accountService;

    public void save(){
        accountService.save();
    }

}
