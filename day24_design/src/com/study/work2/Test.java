package com.study.work2;

import com.study.work2.factory.BeanFactory;
import com.study.work2.servlet.MyServlet;

public class Test {
    public static void main(String[] args) {
        Component.getComponent("com.study.work2");

        MyServlet servlet = (MyServlet) BeanFactory.getBean("servlet");

        servlet.save();

    }
}
