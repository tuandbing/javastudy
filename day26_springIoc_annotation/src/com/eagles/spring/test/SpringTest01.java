package com.eagles.spring.test;

import com.eagles.spring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");

        User user = (User) context.getBean("user");

        System.out.println(user);

        context.close();

    }

}
