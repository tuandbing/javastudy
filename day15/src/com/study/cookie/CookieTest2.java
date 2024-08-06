package com.study.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie2")
public class CookieTest2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String method = request.getParameter("method");

        if(method != null && method.equals("login")){
            login(request,response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        response.addCookie(new Cookie("username",username));

        response.addCookie(new Cookie("password",password));

        request.getRequestDispatcher("/jsp/main.jsp").forward(request,response);

    }
}
