package com.eagles.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello4")
public class HelloServlet04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取全局的域对象
        ServletContext servletContext = getServletContext();

        //往域对象中存值
        Object message = servletContext.getAttribute("message");

        System.out.println(message);

    }
}
