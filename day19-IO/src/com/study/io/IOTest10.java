package com.study.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest10 {
    public static void main(String[] args) {

        // 创建数据流对象
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("IOText.txt"));

            dataOutputStream.writeInt(10);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeDouble(20.0);
            dataOutputStream.writeChar('s');
            dataOutputStream.writeChar('b');
            dataOutputStream.writeChar('佩');
            dataOutputStream.writeChar('奇');

            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
