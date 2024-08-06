package com.work;



import com.work.utils.JDBCUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CreateProxy {

    private final Object obj;

    public CreateProxy(Object obj) {
        this.obj = obj;
    }



    public Object getProxy(){

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                if(method.getName().equals("select")){
                    invoke = method.invoke(obj,args);
                }else{

                    try{
                        System.out.println("开启事务");
                        JDBCUtils.getConnection().setAutoCommit(false);

                        invoke = method.invoke(obj,args);

                        System.out.println("提交事务");
                        JDBCUtils.getConnection().commit();
                    }catch (Exception e){
                        System.out.println("回滚事务");
                        JDBCUtils.getConnection().rollback();
                    }finally {
                        JDBCUtils.getClose(null,null,JDBCUtils.getConnection());
                    }
                }

                return invoke;

            }
        });

    }
}
