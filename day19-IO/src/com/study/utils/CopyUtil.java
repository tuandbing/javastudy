// 通过字节流进行拷贝
package com.study.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyUtil {
    private CopyUtil(){

    }

    public static void copy(String inputPath,String outputPath){

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(inputPath);

            fileOutputStream = new FileOutputStream(outputPath,true);

            byte[] bytes = new byte[1024 * 1024];

            int read;

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
