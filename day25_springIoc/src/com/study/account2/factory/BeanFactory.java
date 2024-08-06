package com.study.account2.factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BeanFactory {

    private static Map<String, Object> beanMap;



    static {

        // 创建集合对象
        beanMap = new HashMap<>();

        // 创建properties对象
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {

            fileReader = new FileReader("account.properties");

            properties.load(fileReader);

            Enumeration keys = properties.propertyNames();

            while (keys.hasMoreElements()){

                String key = keys.nextElement().toString();

                String value = properties.getProperty(key);

                // 根据反射创建实例
                Object instance = Class.forName(value).newInstance();

                // 将实例存入map集合
                beanMap.put(key, instance);

            }

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 根据唯一标识来获取实例
    public static Object getBean(String id){
        return beanMap.get(id);
    }
}
