package com.study.file;

import java.io.File;
import java.io.IOException;

public class file01 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        if(file.exists()){
            boolean delete = file.delete();
            System.out.println(delete ?"删除成功":"删除失败");
        }else{
            try {
                boolean newFile = file.createNewFile();
                System.out.println(newFile ?"创建成功":"创建失败");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        File file1 = new File("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io");

        System.out.println(file1.isFile()); // false
        System.out.println(file1.isDirectory()); // true
        File[] files = file1.listFiles(pathname -> pathname.getPath().endsWith(".java"));
        System.out.println("--------------------------");
        if (files != null) {
            for (File file2 : files) {
                System.out.println(file2.getName());
            }
        }

    }
}
