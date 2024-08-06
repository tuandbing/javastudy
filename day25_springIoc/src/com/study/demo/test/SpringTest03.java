package com.study.demo.test;

import com.study.account.servlet.AccountServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");

        AccountServlet accountServlet = context.getBean("servlet", AccountServlet.class);

        accountServlet.save();
    }

}
