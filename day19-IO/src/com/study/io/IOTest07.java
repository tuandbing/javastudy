package com.study.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest07 {
    public static void main(String[] args) {

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("团员列表.xlsx");

            fileWriter = new FileWriter("团员列表_copy.xlsx");

            char[] c = new char[648];

            int read;

            while((read = fileReader.read(c)) != -1){

                // 将字节转换为字符
                fileWriter.write(c,0,read);
            }

            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(fileReader != null){
                    fileReader.close();

                }
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
