package com.study.io;

import com.study.utils.loggerManager;

import java.io.PrintStream;

public class IOTest13 {
    public static void main(String[] args) throws Exception {

        myLogger.printLogger("出现了空指针异常");
        myLogger.printLogger("出现了数组越界异常");
        myLogger.printLogger("出现了模块异常");

    }
}
