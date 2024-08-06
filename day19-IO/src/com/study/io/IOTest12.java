package com.study.io;

import java.io.*;

public class IOTest12 {
    public static void main(String[] args) throws Exception {

        PrintStream printStream = new PrintStream("IOText5.txt");

        System.setOut(printStream);

        System.out.println(1);

        printStream.flush();
        printStream.close();

    }
}
