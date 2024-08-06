package com.eagles.spring.test;

import com.eagles.spring.config.JdbcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest04 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        Object jdbc = context.getBean("jdbc");

        System.out.println(jdbc);

        Object teacher = context.getBean("teacher");

        System.out.println(teacher);
    }

}
