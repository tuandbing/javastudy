package com.study.account3.servlet;


import com.study.account3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("servlet")
public class AccountServlet {

    /*@Autowired
    @Qualifier("service02")*/
    @Resource(name = "service")
    private AccountService accountService;

    public AccountServlet() {
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void save() {
        accountService.save();
    }
}
