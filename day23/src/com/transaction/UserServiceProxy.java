package com.transaction;

import com.transaction.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy implements InvocationHandler {

    private final UserService userService;


    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取代理对象
     * @return
     */
    public UserService getProxy(){
        return (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = null;

        try {

            if (method.getName().contains("select")){
                //目标方法
                invoke = method.invoke(userService, args);

            }else {
                //开启事务
                TransactionManager.startTransaction();
                //目标方法
                invoke = method.invoke(userService, args);
                //提交事务
                TransactionManager.commitTransaction();
            }

        }catch (Exception e){
            //回滚事务
            TransactionManager.rollbackTransaction();
            e.printStackTrace();
        }

        return invoke;
    }
}
