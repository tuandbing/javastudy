package com.study.servlet;

import com.study.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servlet")
public class test01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1,"张三",18));
        students.add(new Student(2,"李四",19));
        students.add(new Student(3,"王五",20));
        students.add(new Student(4,"赵六",22));
        students.add(new Student(5,"馒头",18));

        HttpSession session = request.getSession();
        session.setAttribute("students",students);

        request.getRequestDispatcher("/jsp/test05.jsp").forward(request,response);

    }
}
