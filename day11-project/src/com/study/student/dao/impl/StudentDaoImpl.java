package com.study.student.dao.impl;


import com.study.student.Util.JDBCUtils;
import com.study.student.dao.StudentDao;
import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public List<Student> getStudentList(String likeName) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        //创建一个集合对象
        List<Student> stuList = new ArrayList<>();

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();

            String sql = "select ts.*,tc.cname from tb_student ts inner join tb_class tc on ts.cid = tc.cid";

            if(likeName != null){
                sql = "select ts.*,tc.cname from tb_student ts inner join tb_class tc on ts.cid = tc.cid where stu_name like '%" + likeName +"%'";
            }
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement(sql);
            //执行sql
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            while (resultSet != null && resultSet.next()){
                int sid = resultSet.getInt("sid");
                String stuName = resultSet.getString("stu_name");
                int sex = resultSet.getInt("sex");
                String address = resultSet.getString("address");
                String birthday = resultSet.getString("birthday");
                String hobby = resultSet.getString("hobby");
                String className = resultSet.getString("cname");
                int cid = resultSet.getInt("cid");

                //创建student对象
                Student student = new Student();

                //创建一个班级对象
                Clazz clazz = new Clazz();
                clazz.setCid(cid);
                clazz.setClassName(className);

                //赋值
                student.setStudentName(stuName);
                student.setAddress(address);
                student.setCid(cid);
                student.setHobby(hobby);
                student.setSid(sid);
                student.setSex(sex);
                student.setBirthday(birthday);
                student.setClazz(clazz);
                //将学生对象存储到集合中
                stuList.add(student);
            }

            return stuList;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }

    @Override
    public List<Clazz> findClassAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        //创建一个集合对象
        List<Clazz> clazzList = new ArrayList<>();

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement("select * from tb_class");
            //执行sql
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            while (resultSet != null && resultSet.next()){
                int cid = resultSet.getInt("cid");
                String className = resultSet.getString("cname");

                //创建一个班级对象
                Clazz clazz = new Clazz();
                clazz.setCid(cid);
                clazz.setClassName(className);

                clazzList.add(clazz);

            }

            return clazzList;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public String toAdd(Student student) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;


        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();

            String sql = "insert into tb_student(stu_name,sex,address,birthday,hobby,cid)values(?,?,?,?,?,?)";

            //获取数据库操作对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getSex());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getBirthday());
            preparedStatement.setString(5,student.getHobby());
            preparedStatement.setInt(6,student.getCid());

            //执行sql
            int num = preparedStatement.executeUpdate();

            return num == 1 ? "true" : "false";

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

    }
    @Override
    public Student findStuById(int sid) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement("select * from tb_student where sid = ?");
            preparedStatement.setInt(1,sid);
            //执行sql
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            if (resultSet != null && resultSet.next()){
                String stuName = resultSet.getString("stu_name");
                int sex = resultSet.getInt("sex");
                String address = resultSet.getString("address");
                String birthday = resultSet.getString("birthday");
                String hobby = resultSet.getString("hobby");
                int cid = resultSet.getInt("cid");

                //创建student对象
                Student student = new Student();

                //赋值
                student.setStudentName(stuName);
                student.setAddress(address);
                student.setCid(cid);
                student.setHobby(hobby);
                student.setSid(sid);
                student.setSex(sex);
                student.setBirthday(birthday);

                return student;
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

        return null;
    }
    @Override
    public String toUpdate(Student student) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;


        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();

            String sql = "update tb_student set stu_name = ?,sex = ?,address = ?,birthday = ?,hobby = ?,cid = ? where sid = ?";

            //获取数据库操作对象
            preparedStatement = connection.prepareStatement(sql);

            //给占位符赋值
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getSex());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getBirthday());
            preparedStatement.setString(5,student.getHobby());
            preparedStatement.setInt(6,student.getCid());
            preparedStatement.setInt(7,student.getSid());

            //执行sql
            int num = preparedStatement.executeUpdate();

            return num == 1 ? "true" : "false";

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public String deleteById(int sid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        Integer row;

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();

            String sql = "delete from tb_student where sid = ?";

            //获取数据库操作对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setInt(1,sid);

            //执行sql
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

        return row == 1 ? "true" : "false";
    }
    @Override
    public String deleteStuBySids(String sids) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement("delete from tb_student where sid in("+sids+")");
            //执行sql
            int num = preparedStatement.executeUpdate();

            return num > 0 ? "true" : "false";

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }
}
