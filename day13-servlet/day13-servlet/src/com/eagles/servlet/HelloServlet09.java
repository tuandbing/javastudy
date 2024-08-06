package com.eagles.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello9")
public class HelloServlet09 extends HttpServlet {


    /**
     *
     * @param request 请求对象 域对象
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理中文乱码
        response.setContentType("text/html;charset=utf-8");
        //request.setAttribute("message","hello");
        getServletContext().setAttribute("message","hello");

        System.out.println(getServletContext());

        //重定向
        //response.sendRedirect("https://www.baidu.com");//外部资源
        response.sendRedirect("http://localhost:8085/web/hello10");//内部资源


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
