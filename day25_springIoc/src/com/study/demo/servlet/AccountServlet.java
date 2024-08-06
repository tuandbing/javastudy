package com.study.demo.servlet;


import com.study.demo.service.AccountService;

public class AccountServlet {


    private AccountService accountService;

    public void setAccountServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void save() {
        accountService.save();
    }
}
