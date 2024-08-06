package com.study.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/hello3")
public class HelloServlet03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取全局的域对象
        ServletContext servletContext = getServletContext();

        //往域对象中存值
        servletContext.setAttribute("message1","hello servlet1!!!");
        servletContext.setAttribute("message2","hello servlet2!!!");
        servletContext.setAttribute("message3","hello servlet3!!!");

        //获取的是全局的配置参数
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println(username);
        System.out.println(password);

        System.out.println("------------------------------------");
        //获取全局配置数据的name
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        while (initParameterNames.hasMoreElements()){

            String name = initParameterNames.nextElement();

            System.out.println(name +" ==> "+ servletContext.getInitParameter(name));
        }

        System.out.println("---------------------------------------------");

        //获取web.xml页面信息，获取内部标签数据
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String key = attributeNames.nextElement();
            System.out.println(key +" ==> "+servletContext.getAttribute(key));
        }

        //工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

    }
}
