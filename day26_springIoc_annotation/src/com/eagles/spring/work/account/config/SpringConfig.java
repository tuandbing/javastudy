package com.eagles.spring.work.account.config;

import com.eagles.spring.work.account.dao.AccountDao;
import com.eagles.spring.work.account.dao.AccountDaoImpl;
import com.eagles.spring.work.account.service.AccountService;
import com.eagles.spring.work.account.service.AccountServiceImpl;
import com.eagles.spring.work.account.servlet.AccountServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
@ComponentScan("com.eagles.spring.work")
public class SpringConfig {

    @Bean("dao")
    public AccountDao getAccountDao(){
        return new AccountDaoImpl();
    }

    @Bean("service")
    public AccountService getAccountService(AccountDao dao){
        AccountServiceImpl service = new AccountServiceImpl();

        service.setAccountDao(dao);

        return service;
    }

    @Bean("servlet")
    public AccountServlet getAccountServlet(AccountService service){

        AccountServlet servlet = new AccountServlet();

        servlet.setAccountService(service);

        return servlet;
    }

}
