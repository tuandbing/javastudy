package com.eagles.io.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest03 {
    public static void main(String[] args) {


        FileInputStream fileInputStream = null;


        try {
            //创建字节输入流对象
            fileInputStream = new FileInputStream("C:\\temp\\test\\test.txt");

            //创建一个字节数组，存储每个字符对应的ascll
            byte[] bytes = new byte[4];

            int read = 0;
            while ((read = fileInputStream.read(bytes)) != -1){
                //将字符的ascll转换成对应的字符串
                String str = new String(bytes, 0, read);
                System.out.print(str);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源回收
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
