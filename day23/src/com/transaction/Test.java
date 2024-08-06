package com.transaction;



import com.transaction.service.UserService;
import com.transaction.service.UserServiceImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        //创建目标对象
        UserService userService = new UserServiceImpl();
        //创建代理对象
        UserService service = new UserServiceProxy(userService).getProxy();


//        Integer insert = service.insert(new User("jack02", "21", "北京市"));
//        System.out.println(insert == 1 ? "添加成功":"添加失败");

//        Integer delete = service.delete(9);
//        System.out.println(delete == 1 ? "成功":"失败");

//        Integer update = service.update(new User(8,"zs222", "21", "北京市"));
//        System.out.println(update == 1 ? "成功":"失败");

        List<User> select = service.select();
        for (User user : select) {
            System.out.println(user);
        }


    }

}
