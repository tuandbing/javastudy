package com.study.servlet;

import com.study.mybatis.Tests;
import com.study.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class empServlet extends HttpServlet {

    Tests test = new Tests();

    public empServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String flag = request.getParameter("flag");
        if(flag != null && flag.equals("list")){
            listAll(request,response);
        }
    }

    public void listAll(HttpServletRequest request, HttpServletResponse response) {
        List<Emp> emps = test.findAllEmp();

        request.setAttribute("emps",emps);
        try {
            request.getRequestDispatcher("jsp/list.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
