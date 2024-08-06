package com.eagles.spring.work02.test;

import com.eagles.spring.work02.account.servlet.AccountServlet;
import com.eagles.spring.work02.config.SpringConfig;
import com.eagles.spring.work02.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AccountTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountServlet servlet = (AccountServlet) context.getBean("servlet");

        List<User> userList = servlet.select();

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
