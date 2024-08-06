package com.study.work2.factory;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    static Map<String,Object> map = new HashMap<>();

    private static final BeanFactory factory = new BeanFactory();

    private BeanFactory(){

    }

    /**
     * 感觉没啥用,直接用静态方法就行了
     * @return
     */
    public static BeanFactory getFactory(){
        return factory;
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        BeanFactory.map = map;
    }

    public static Object getBean(String beanId) {
        return map.get(beanId);
    }

}
