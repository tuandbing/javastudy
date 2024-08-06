package com.study.io;

import com.study.utils.CopyUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest05 {
    public static void main(String[] args) {

        CopyUtil.copy("D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\团员列表.xlsx","D:\\jwCode\\eagle_study\\day19-IO\\src\\com\\study\\io\\团员列表_copy.xlsx");

    }
}
