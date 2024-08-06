package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello7")
public class HelloServlet07 extends HttpServlet {


    /**
     *
     * @param request 请求对象 域对象
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        Object name = request.getAttribute("name");
        Object age = request.getAttribute("age");

        System.out.println(name);
        System.out.println(age);

        response.getWriter().print(name);
        response.getWriter().print(age);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
