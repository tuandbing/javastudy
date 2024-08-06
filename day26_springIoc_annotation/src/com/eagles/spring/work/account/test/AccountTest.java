package com.eagles.spring.work.account.test;


import com.eagles.spring.work.account.pojo.User;
import com.eagles.spring.work.account.servlet.AccountServlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");
        AccountServlet servlet = (AccountServlet) context.getBean("accountServlet");

        List<User> userList = servlet.select();
        for (User user : userList) {

            System.out.println(user);

        }

        User userById = servlet.findUserById(3);

        System.out.println(userById);

/*        Integer num = servlet.insert(new User("张三", "040521"));

        System.out.println(num==1?"添加成功":"添加失败");*/

/*        Integer num = servlet.delete(19);
        System.out.println(num==1?"删除成功":"删除失败");*/
    }

}
