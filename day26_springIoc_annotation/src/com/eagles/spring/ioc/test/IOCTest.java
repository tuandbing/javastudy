package com.eagles.spring.ioc.test;

import com.eagles.spring.ioc.account.service.AccountService;
import com.eagles.spring.ioc.account.servlet.AccountServlet;
import com.eagles.spring.ioc.component.ComponentScan;
import com.eagles.spring.ioc.factory.BeanFactory;

import java.util.Map;
import java.util.Set;

public class IOCTest {
    public static void main(String[] args) {

        // 开启扫描包
        ComponentScan.componentScan("com.eagles");

        /* Map<String, Object> map = BeanFactory.getMap();

        map.forEach((String k,Object v) -> System.out.println(k + "==>" + v));

        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + "==>" + entry.getValue());
        }*/

        AccountServlet accountServlet = (AccountServlet) BeanFactory.getBean("accountServlet");

        accountServlet.save();
    }
}
