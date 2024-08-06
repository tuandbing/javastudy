package com.eagles.spring.work02.account.servlet;

import com.eagles.spring.work02.pojo.User;
import com.eagles.spring.work02.account.service.AccountService;

import java.util.List;


public class AccountServlet {


    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void save(){
        accountService.save();
    }

    public List<User> select(){
        return accountService.select();
    }

    public Integer insert(User user) {
        return accountService.insert(user);
    }

    public Integer delete(Integer id) {
        return accountService.delete(id);
    }

    public Integer update(User user) {
        return accountService.update(user);
    }

    public User findUserById(Integer id){
        return accountService.findUserById(id);
    }

}
