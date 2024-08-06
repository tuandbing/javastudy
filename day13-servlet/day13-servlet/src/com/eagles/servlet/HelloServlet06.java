package com.eagles.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello6")
public class HelloServlet06 extends HttpServlet {


    /**
     *
     * @param request 请求对象 域对象
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //往域中存储数据
        request.setAttribute("name","张三");
        request.setAttribute("age",20);

        //请求转发
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello7");
        requestDispatcher.forward(request,response);//资源跳转


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
