package com.study.demo.test;

import com.study.account.servlet.AccountServlet;
import com.study.demo.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest04 {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xml/beans.xml"));
//        User accountServlet = context.getBean("user", User.class);
        User user = beanFactory.getBean("user", User.class);

    }

}
