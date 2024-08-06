package com.study.demo.test;

import com.study.account2.dao.AccountDao;
import com.study.account2.dao.AccountDaoImpl;
import com.study.account2.factory.BeanFactory;
import com.study.account2.service.AccountService;
import com.study.account2.service.AccountServiceImpl;
import com.study.account2.servlet.AccountServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest05 {

    public static void main(String[] args) {

        AccountServlet accountServlet = (AccountServlet) BeanFactory.getBean("accountServlet");
        AccountServiceImpl accountService = (AccountServiceImpl) BeanFactory.getBean("accountService");
        AccountDaoImpl accountDao = (AccountDaoImpl) BeanFactory.getBean("accountDao");

        accountService.setAccountDao(accountDao);
        accountServlet.setAccountService(accountService);
        accountServlet.save();
    }


}
