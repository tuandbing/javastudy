package com.study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class myLogger {
    private myLogger(){}
    public static void printLogger(String message){
        PrintStream printStream = null;

        try {
            printStream = new PrintStream(new FileOutputStream("logger.txt",true));

            Date date = new Date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

            String formatDate = simpleDateFormat.format(date);

            System.setOut(printStream);

            System.out.println(formatDate + " : " + message);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(printStream != null){
                printStream.flush();
                printStream.close();
            }
        }


    }

}
