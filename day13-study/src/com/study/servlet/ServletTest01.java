package com.study.servlet;

import com.study.pojo.Student;
import com.study.service.impl.serviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/servlet")
public class ServletTest01 extends HttpServlet {

    private final serviceImpl service = new serviceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String method = request.getParameter("method");

        if(method != null && method.equals("findAll")){
            findAll(request,response);
        } else if (method != null && method.equals("login")) {
            login(request,response);
        }


    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String flag = service.login(username,password);

        if(flag.equals("true")){
            try {
                response.sendRedirect("servlet?method=findAll");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                response.sendRedirect("jsp/login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {

        ArrayList<Student>students = service.findAll();

        request.setAttribute("students",students);

        try {
            request.getRequestDispatcher("/jsp/showStu.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }


}
