package com.study.cookie;

import com.study.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        response.addCookie(new Cookie("name","tom"));

/*        Cookie[] cookies = request.getCookies();

        for (Cookie cookie1 : cookies) {

            System.out.println(cookie1.getName());
            System.out.println(cookie1.getValue());

        }*/

        Cookie nameCookie = CookieUtils.findCookie("name", request.getCookies());

        System.out.println(nameCookie.getName() + "==>" + nameCookie.getValue());

        // 修改value的值
        nameCookie.setValue("jack");

        response.addCookie(nameCookie);

        System.out.println(nameCookie.getName() + "==>" + nameCookie.getValue());


    }
}
