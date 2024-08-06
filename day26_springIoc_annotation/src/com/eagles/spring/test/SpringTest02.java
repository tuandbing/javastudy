package com.eagles.spring.test;

import com.eagles.spring.config.SpringConfig;
import com.eagles.spring.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Object teacher = context.getBean("teacher");

        System.out.println(teacher);

    }

}
