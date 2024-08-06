package com.study.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest03 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\IOTest01.java");

            fileOutputStream = new FileOutputStream("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\IOTest04.java",true);

            byte[] bytes = new byte[648];

            int read = 0;

            while((read = fileInputStream.read(bytes)) != -1){

                // 将字节转换为字符
                fileOutputStream.write(bytes,0,read);
            }

            fileOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(fileInputStream != null){
                    fileInputStream.close();

                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
