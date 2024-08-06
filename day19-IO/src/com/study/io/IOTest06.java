package com.study.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest06 {
    public static void main(String[] args) {

        FileReader fileReader = null;

        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("IOText.txt");

            fileWriter = new FileWriter("IOText2.txt");

            /*int read = fileReader.read();
            System.out.println(read);
            char c = (char) read;
            System.out.println(c);

            */
            /*

            char[] bytes = new char[4];

            // 返回的是获取到的字符个数
            int i = fileReader.read(bytes);
            System.out.println(i);

            for (byte b : bytes) {
                System.out.println((char)b);
            }

            // 返回的是剩余没有读的字符个数
            read = fileReader.read(bytes);
            System.out.println(read);*/

            char[] chars = new char[4];

            int read = 0;

            while((read = fileReader.read(chars)) != -1){

                // 将字节转换为字符
                String s = new String(chars,0,read);
                System.out.print(s + " ");
            }

            fileWriter.write("你好!java.",0,2);

            char[] c = {'h','e','l','l','o',' ','w','o','r','l','d'};
            fileWriter.write("\n");
            fileWriter.write(c);

            fileWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }
}
