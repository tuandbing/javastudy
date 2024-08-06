package com.eagles.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello5")
public class HelloServlet05 extends HttpServlet {


    /**
     *
     * @param request 请求对象 域对象
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取客户端提交的参数
        String parameter = request.getParameter("name");
        //获取客户端的提交方式
        String method = request.getMethod();

        System.out.println(parameter);
        System.out.println(method);

        //获取请求头相关的数据
        String accept = request.getHeader("Accept");
        System.out.println(accept);//text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7

        System.out.println("----------------------------------------");

        String username = request.getParameter("username");
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        //处理中文乱码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        System.out.println(username);
       // String hobby = request.getParameter("hobby");
        String[] hobbies = request.getParameterValues("hobby");//可以获取客户端提交多个的值

        for (String hobby : hobbies) {

            System.out.println(hobby);
        }

    }
}
