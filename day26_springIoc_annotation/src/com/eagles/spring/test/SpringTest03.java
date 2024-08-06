package com.eagles.spring.test;

import com.eagles.spring.config.JdbcConfig;
import com.eagles.spring.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest03 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        Object jdbc = context.getBean("jdbc");

        System.out.println(jdbc);

    }

}
