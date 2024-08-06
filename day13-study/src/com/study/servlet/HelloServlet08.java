package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello8")
public class HelloServlet08 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理中文乱码
        response.setContentType("text/html;charset=utf-8");

        //获取字符流对象
        PrintWriter writer = response.getWriter();
        //获取字节流对象
        //ServletOutputStream outputStream = response.getOutputStream();
        writer.print("hello world");
        writer.print("<br/>");
        writer.print("hello java");
        writer.print("<br/>");
        writer.print("<input type = 'text'>");
        writer.print("你好");
//        outputStream.print("hello");
//        outputStream.print("<br/>");
//        outputStream.print("servlet!");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
