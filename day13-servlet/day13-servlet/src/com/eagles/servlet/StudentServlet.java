package com.eagles.servlet;

import com.alibaba.fastjson.JSON;
import com.eagles.pojo.Student;
import com.eagles.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Student> students = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from tb_student");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int sid = resultSet.getInt("sid");
                int sex = resultSet.getInt("sex");
                String stuName = resultSet.getString("stu_name");
                String address = resultSet.getString("address");
                String birthday = resultSet.getString("birthday");
                String hobby = resultSet.getString("hobby");
                //创建java对象
                Student student = new Student();
                student.setAddress(address);
                student.setBirthday(birthday);
                student.setSex(sex);
                student.setSid(sid);
                student.setStuName(stuName);
                student.setHobby(hobby);
                //将java对象添加到集合中
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //将java集合转成json字符串
        String stuJson = JSON.toJSONString(students);

        //将集合数据退给前端
        response.getWriter().print(stuJson);


    }
}
