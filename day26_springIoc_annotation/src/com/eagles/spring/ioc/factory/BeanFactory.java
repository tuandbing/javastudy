package com.eagles.spring.ioc.factory;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    private static Map<String,Object> map;

    static{
        map = new HashMap<>();
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        BeanFactory.map = map;
    }

    public static Object getBean(String beanId){
        return map.get(beanId);
    }
}
