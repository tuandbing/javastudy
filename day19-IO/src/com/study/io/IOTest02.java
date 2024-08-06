package com.study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest02 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\IOText2.txt",true);

            /*byte[] bytes = new byte[5];
            for (int i = 0; i < 5; i++) {
                bytes[i] = (byte)(i + 65);
            }*/

            byte[] bytes = {65,66,67,68,69};

            fileOutputStream.write(bytes);

            fileOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
