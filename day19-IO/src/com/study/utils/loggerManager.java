package com.study.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loggerManager {


    /**
     * 记录日志的方法
     * @param message 日志信息
     */
    public static void printLogger(String message){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream("./logger.txt",true));

            // 更改输出路径
            System.setOut(printStream);

            // 获取系统当前时间
            Date date = new Date();

            // 创建日期格式化对象
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            // 获取格式化之后的时间
            String time = simpleDateFormat.format(date);

            //记录日志
            System.out.println(time + " : " + message);

            // 刷新
            printStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            // 关闭
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
