package com.study.file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


public class fileTest {

    public static void main(String[] args) {

        File file = new File("data");

         find(file);

    }
    public static void find(File file){
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                find(listFile);
            } else if (listFile.getPath().endsWith(".java")) {
                System.out.println(listFile.getName());
            }
        }
    }
}
