package com.eagles.spring.work02.config;


import com.eagles.spring.work02.account.dao.AccountDao;
import com.eagles.spring.work02.account.dao.AccountDaoImpl;
import com.eagles.spring.work02.account.service.AccountService;
import com.eagles.spring.work02.account.service.AccountServiceImpl;
import com.eagles.spring.work02.account.servlet.AccountServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.eagles.spring.work02")
public class SpringConfig {

    @Bean("dataSource")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/tests?characterEncoding=utf8&serverTimezone=GMT%2B8");

        dataSource.setUsername("root");

        dataSource.setPassword("pyw040212");

        return dataSource;

    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean("userDao")
    public AccountDao getAccountDao(JdbcTemplate jdbcTemplate){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        accountDao.setJdbcTemplate(jdbcTemplate);
        return accountDao;
    }

    @Bean("userService")
    public AccountService getAccountService(@Qualifier("userDao") AccountDao dao){
        AccountServiceImpl service = new AccountServiceImpl();

        service.setAccountDao(dao);

        return service;
    }

    @Bean("servlet")
    public AccountServlet getAccountServlet(@Qualifier("userService") AccountService service){

        AccountServlet servlet = new AccountServlet();

        servlet.setAccountService(service);

        return servlet;
    }

}

