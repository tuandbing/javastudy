package com.study.demo.test;

import com.study.demo.pojo.Student;
import com.study.demo.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");

        User user = context.getBean("user", User.class);

        Student student = context.getBean("student", Student.class);
        System.out.println(user);
        System.out.println(student);
    }

}
