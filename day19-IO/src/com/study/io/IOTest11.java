package com.study.io;

import java.io.*;

public class IOTest11 {
    public static void main(String[] args) {

        // 创建数据流对象
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("IOText.txt"));

            int i = dataInputStream.readInt();
            boolean readBoolean = dataInputStream.readBoolean();
            double readDouble = dataInputStream.readDouble();

            System.out.print(i + " " + readBoolean + " " + readDouble + " ");

            while(dataInputStream.available() != 0){
                System.out.print(dataInputStream.readChar());
            }

            dataInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
