package com.study.io;


import com.study.pojo.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOTest14 {
    public static void main(String[] args) throws Exception {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        User user = new User(10,"馒头","123456");
        User user1 = new User(11,"馒头1","123456");
        User user2 = new User(12,"馒头2","123456");
        User user3 = new User(13,"馒头3","123456");
        User user4 = new User(14,"馒头4","123456");

        List<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.add(user4);
        objectOutputStream.writeObject(arrayList);

        objectOutputStream.flush();

        objectOutputStream.close();


    }
}
