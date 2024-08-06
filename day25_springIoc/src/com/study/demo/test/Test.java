package com.study.demo.test;

import com.study.demo.dao.AccountDao;
import com.study.demo.dao.AccountDaoImpl;
import com.study.demo.service.AccountService;
import com.study.demo.service.AccountServiceImpl;
import com.study.demo.servlet.AccountServlet;

public class Test {

    public static void main(String[] args) {

        AccountDao accountDao = new AccountDaoImpl();

        AccountServiceImpl accountService = new AccountServiceImpl();

        AccountServlet accountServlet = new AccountServlet();

        accountService.setAccountDao(accountDao);

        accountServlet.setAccountServlet(accountService);

        accountServlet.save();


    }

}
