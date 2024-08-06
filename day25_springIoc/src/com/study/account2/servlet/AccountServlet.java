package com.study.account2.servlet;


import com.study.account2.service.AccountService;

public class AccountServlet {

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
