package com.study.demo.test;

import com.study.demo.pojo.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest06 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans02.xml");

        Teacher teacher = context.getBean("teacher", Teacher.class);

        System.out.println(teacher);


    }

}
