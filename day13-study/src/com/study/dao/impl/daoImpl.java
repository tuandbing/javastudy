package com.study.dao.impl;

import com.study.dao.dao;
import com.study.pojo.Student;
import com.study.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoImpl implements dao {

    @Override
    public ArrayList<Student> findAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Student> students = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from student";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSex(resultSet.getString("sex"));
                student.setBirth(resultSet.getString("birth"));
                student.setDepartment(resultSet.getString("department"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

        return students;
    }

    @Override
    public String login(String username, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_user where username = ? and password = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            return resultSet.next() ? "true" : "false";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }
}
