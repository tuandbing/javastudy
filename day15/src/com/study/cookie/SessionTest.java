package com.study.cookie;

import com.study.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        session.setAttribute("username","馒");
        session.setAttribute("password","123456");

        response.getWriter().print("sessionID : " + session.getId() + "<br/>");

        response.getWriter().print("session默认存活时间 : " + session.getMaxInactiveInterval() + "<br/>");

        response.getWriter().print("username : " + session.getAttribute("username") + "<br/>");
        response.getWriter().print("password : " + session.getAttribute("password") + "<br/>");

    }
}
