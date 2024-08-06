package com.study.utils;

import java.io.File;

public class FindJava {
    private FindJava(){}

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
