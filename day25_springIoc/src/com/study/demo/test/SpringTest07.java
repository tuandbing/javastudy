package com.study.demo.test;

import com.study.account3.servlet.AccountServlet;
import com.study.demo.pojo.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest07 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans02.xml");

        AccountServlet accountServlet = context.getBean("servlet", AccountServlet.class);

        accountServlet.save();

    }

}
