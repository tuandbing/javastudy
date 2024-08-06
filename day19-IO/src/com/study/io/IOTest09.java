package com.study.io;

import com.study.utils.CopyUtil2;

import java.io.*;

public class IOTest09 {
    public static void main(String[] args) {

        try {

            // 创建缓冲流对象
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("IOTest06.java")));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("IOText.txt"));

            bufferedWriter.write("hello world");
            String str;

            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
