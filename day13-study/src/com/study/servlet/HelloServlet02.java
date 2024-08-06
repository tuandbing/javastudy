package com.study.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;


public class HelloServlet02 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        //获取初始化的参数信息
        String name = servletConfig.getInitParameter("name");
        System.out.println(name);

        //域对象
        //ServletContext servletContext = servletConfig.getServletContext();
        //
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);//获取当前servlet资源的别名

        //获取所有配置信息的name的值
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        System.out.println("-----------------------------------------------------");
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s +"===>"+servletConfig.getInitParameter(s));
        }


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
