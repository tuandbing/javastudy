package com.study.demo.test;

import com.study.demo.pojo.Student;
import com.study.demo.pojo.User;
import com.study.demo.servlet.AccountServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");

        AccountServlet accountServlet = context.getBean("accountServlet", AccountServlet.class);

        accountServlet.save();
    }

}
