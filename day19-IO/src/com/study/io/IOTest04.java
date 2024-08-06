package com.study.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest04 {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\IOText.txt");

            /*int read = fileInputStream.read();
            System.out.println(read);
            char c = (char) read;
            System.out.println(c);

            *//*for (byte b : fileInputStream.readAllBytes()) {
                System.out.println((char)b);
            }*//*

            byte[] bytes = new byte[4];

            // 返回的是获取到的字符个数
            int i = fileInputStream.read(bytes);
            System.out.println(i);

            for (byte b : bytes) {
                System.out.println((char)b);
            }

            // 返回的是剩余没有读的字符个数
            read = fileInputStream.read(bytes);
            System.out.println(read);*/

            byte[] bytes = new byte[4];

            int read = 0;

            while((read = fileInputStream.read(bytes)) != -1){

                // 将字节转换为字符
                String s = new String(bytes,0,read);
                System.out.print(s + " ");
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }
}
