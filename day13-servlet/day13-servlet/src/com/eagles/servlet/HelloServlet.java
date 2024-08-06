package com.eagles.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("HelloServlet实例被创建！！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet的初始化方法init()!!!");
        System.out.println(servletConfig);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法，无论如何都会被执行！");
    }

    @Override
    public String getServletInfo() {

        return null;
    }

    @Override
    public void destroy() {

        System.out.println("destroy销毁的方法！！！");

    }
}
