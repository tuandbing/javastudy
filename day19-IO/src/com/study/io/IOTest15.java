package com.study.io;


import com.study.pojo.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IOTest15 {
    public static void main(String[] args) throws Exception {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.txt"));

        Object o = objectInputStream.readObject();

        if(o instanceof User){
            User user = (User)o;
            System.out.println(user);
        }

        if(o instanceof List){
            List<User> users = (List<User>)o;
            for (User user : users) {
                System.out.println(user);
            }
        }

        objectInputStream.close();


    }
}
