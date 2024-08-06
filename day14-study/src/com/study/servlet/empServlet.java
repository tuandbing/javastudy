package com.study.servlet;

import com.study.Util.CookieUtils;
import com.study.Util.JDBCUtils;
import com.study.pojo.Emp;
import com.study.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/emp")
public class empServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String flag = request.getParameter("flag");
        if(flag != null && flag.equals("list")){
            listAll(request,response);
        }else if(flag != null && flag.equals("add")){
            add(request,response);
        } else if (flag != null && flag.equals("findEmpById")) {
            findEmpById(request,response);
        }else if (flag != null && flag.equals("update")) {
            updateEmp(request,response);
        }else if (flag != null && flag.equals("delete")) {
            deleteEmp(request,response);
        }else if (flag != null && flag.equals("findEmpByName")) {
            findEmpByName(request,response);
        }else if(flag != null && flag.equals("login")){
            login(request,response);
        }else if(flag != null && flag.equals("logOut")){
            logOut(request,response);
        }


    }

    public void logOut(HttpServletRequest request, HttpServletResponse response) {

        //获取session
        HttpSession session = request.getSession();
        session.invalidate();//销毁session
        //重定向
        try {
            response.sendRedirect("http://localhost:8087/web/emp?flag=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void login(HttpServletRequest request, HttpServletResponse response) {

        //获取用户名和密码的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库连接对象
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_user where username = ? and password = ?";
            //获取数据库操作对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()){
                //查询客户端的cookie
                Cookie cookieUsername = CookieUtils.findCookie("username", request.getCookies());
                Cookie cookiePassword = CookieUtils.findCookie("password", request.getCookies());


                // 将数据存储到cookie中,实现回显
                if (cookieUsername == null && cookiePassword == null){
                    cookieUsername = new Cookie("username",username);
                    cookiePassword = new Cookie("password",password);

                    //设定有效期
                    cookieUsername.setMaxAge(60 * 60 * 24 * 7);
                    cookiePassword.setMaxAge(60 * 60 * 24 * 7);

                    //通知浏览器保存cookie
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                }

                //创建用户对象
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                //创建session对象
                HttpSession session = request.getSession();
                //将数据存到session域中
                session.setAttribute("user",user);
                //重定向
                response.sendRedirect("http://localhost:8080/web/emp?flag=list");
            }else {
                response.getWriter().print("登录失败！");
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }


    }

    private void findEmpByName(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String likeName = request.getParameter("likeName");
        ArrayList<Emp> emps = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_emp where ename like '%" + likeName +"%'";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Emp emp = new Emp();
                emp.setEid(resultSet.getInt("eid"));
                emp.setEname(resultSet.getString("ename"));
                emp.setAge(resultSet.getInt("age"));
                emp.setSex(resultSet.getString("sex"));
                emp.setAddress(resultSet.getString("address"));
                emp.setBirthday(resultSet.getString("birthday"));
                emp.setSalary(resultSet.getDouble("salary"));
                emp.setDid(resultSet.getInt("did"));

                emps.add(emp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

        request.setAttribute("emps",emps);
        try {
            request.getRequestDispatcher("jsp/emp.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response) {
        String eid = request.getParameter("eid");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from tb_emp where eid = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(eid));

            int num = preparedStatement.executeUpdate();

            if(num == 1){
                response.sendRedirect("emp?flag=list");
            }else{
                response.getWriter().print("删除失败");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    public void updateEmp(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "update tb_emp set ename = ?,age = ?,sex = ?,address = ?,birthday = ?,salary = ?,did = ? where eid = ?";

            preparedStatement = connection.prepareStatement(sql);
            String eid = request.getParameter("eid");
            String ename = request.getParameter("ename");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            String salary = request.getParameter("salary");
            String did = request.getParameter("did");

            preparedStatement.setString(1,ename);
            preparedStatement.setInt(2,Integer.parseInt(age));
            preparedStatement.setString(3,sex);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,birthday);
            preparedStatement.setString(6,salary);
            preparedStatement.setString(7,did);
            preparedStatement.setInt(8,Integer.parseInt(eid));

            int num = preparedStatement.executeUpdate();

            if(num == 1){
                response.sendRedirect("emp?flag=list");
            }else{
                response.getWriter().print("修改失败");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    public void findEmpById(HttpServletRequest request, HttpServletResponse response) {

        String eid = request.getParameter("eid");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Emp emp = new Emp();
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_emp where eid = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(eid));

            resultSet = preparedStatement.executeQuery();

            if(resultSet != null && resultSet.next()){
                String ename = resultSet.getString("ename");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                String birthday = resultSet.getString("birthday");
                double salary = resultSet.getDouble("salary");
                int did = resultSet.getInt("did");

                emp.setEid(Integer.parseInt(eid));
                emp.setEname(ename);
                emp.setAge(age);
                emp.setSex(sex);
                emp.setAddress(address);
                emp.setBirthday(birthday);
                emp.setSalary(salary);
                emp.setDid(did);

                request.setAttribute("emp",emp);
                request.getRequestDispatcher("/jsp/update.jsp").forward(request,response);

            }else{
                response.getWriter().print("查询失败");
            }


        } catch (SQLException | IOException | ServletException e) {
            throw new RuntimeException(e);
        }  finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }


    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into tb_emp(ename,age,sex,address,birthday,salary,did)values (?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            String ename = request.getParameter("ename");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String birthday = request.getParameter("birthday");
            String salary = request.getParameter("salary");
            String did = request.getParameter("did");

            preparedStatement.setString(1,ename);
            preparedStatement.setInt(2,Integer.parseInt(age));
            preparedStatement.setString(3,sex);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,birthday);
            preparedStatement.setString(6,salary);
            preparedStatement.setString(7,did);

            int num = preparedStatement.executeUpdate();

            if(num == 1){
                response.sendRedirect("emp?flag=list");
            }else{
                response.getWriter().print("添加失败");
            }


        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }  finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
    }

    public void listAll(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Emp> emps = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_emp";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Emp emp = new Emp();
                emp.setEid(resultSet.getInt("eid"));
                emp.setEname(resultSet.getString("ename"));
                emp.setAge(resultSet.getInt("age"));
                emp.setSex(resultSet.getString("sex"));
                emp.setAddress(resultSet.getString("address"));
                emp.setBirthday(resultSet.getString("birthday"));
                emp.setSalary(resultSet.getDouble("salary"));
                emp.setDid(resultSet.getInt("did"));

                emps.add(emp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }

        HttpSession session = request.getSession();
        session.setAttribute("emps",emps);

        try {
            request.getRequestDispatcher("jsp/emp.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
