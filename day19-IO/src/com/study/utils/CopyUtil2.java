// 通过字符流进行文本的拷贝
package com.study.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyUtil2 {
    private CopyUtil2(){}

    public static void copy(String inputPath,String outputPath){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(inputPath);

            fileWriter = new FileWriter(outputPath);

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
