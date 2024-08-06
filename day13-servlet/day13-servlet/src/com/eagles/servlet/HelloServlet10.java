package com.eagles.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello10")
public class HelloServlet10 extends HttpServlet {


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

        System.out.println(getServletContext().getAttribute("message"));
        System.out.println(getServletContext());

        //重定向
        //response.sendRedirect("https://www.baidu.com");//外部资源
        response.getWriter().print("资源跳转成功！！！");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
