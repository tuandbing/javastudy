package com.study.account.servlet;


import com.study.account.service.AccountService;

public class AccountServlet {

    private AccountService accountService;

    public AccountServlet() {
    }

    public AccountServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void save() {
        accountService.save();
    }
}
