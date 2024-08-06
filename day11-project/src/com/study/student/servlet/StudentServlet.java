package com.study.student.servlet;

import com.alibaba.fastjson.JSON;
import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;
import com.study.student.service.StudentService;
import com.study.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    //聚合业务层的实例
    private StudentService studentService = new StudentServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理中文乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //请求的分发处理，接收一个客户端的标识，然后 根据标识执行对应的方法
        String flag = request.getParameter("flag");

        if (flag != null && flag.equals("list")){
            getStudentList(request,response);
        }else if (flag != null && flag.equals("findClassAll")){
            findClassAll(request,response);
        }else if (flag != null && flag.equals("toAdd")){
            toAdd(request,response);
        }else if (flag != null && flag.equals("findStuById")){
            findStuById(request,response);
        }else if(flag != null && flag.equals("deleteById")){
            deleteById(request,response);
        }else if (flag != null && flag.equals("toUpdate")){
            toUpdate(request,response);
        }else if (flag != null && flag.equals("deleteStuBySids")){
            deleteStuBySids(request,response);
        }

    }

    //批量删除
    public void deleteStuBySids(HttpServletRequest request, HttpServletResponse response) {

        String sids = request.getParameter("sids");
        String flag = this.studentService.deleteStuBySids(sids);
        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteById(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("sid");
        String flag = studentService.deleteById(Integer.parseInt(sid));

        String msg = flag.equals("true") ? "操作成功" : "操作失败";

        request.setAttribute("msg",msg);

        try {
            request.getRequestDispatcher("/jsp/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //根据id修改学生的数据

    public void toUpdate(HttpServletRequest request, HttpServletResponse response) {


        //获取客户端的数据
        String sid = request.getParameter("sid");
        String studentName = request.getParameter("studentName");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String cid = request.getParameter("cid");

        //获取爱好数组
        String[] hobbyArray = request.getParameterValues("hobby");

        String hobbies = "";

        //遍历爱好数组
        for (String hobby : hobbyArray) {

            hobbies += ","+hobby;

        }

        hobbies = hobbies.substring(1);

        //创建一个student对象
        Student student = new Student();
        //将数据存入对象中
        student.setSid(Integer.parseInt(sid));
        student.setStudentName(studentName);
        student.setBirthday(birthday);
        student.setSex(Integer.parseInt(sex));
        student.setCid(Integer.parseInt(cid));
        student.setHobby(hobbies);
        student.setAddress(address);


        String flag = this.studentService.toUpdate(student);

        try {
            response.getWriter().print(flag);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //根据id查询学生记录

    public void findStuById(HttpServletRequest request, HttpServletResponse response) {

        String sid = request.getParameter("sid");
        Student student = studentService.findStuById(Integer.parseInt(sid));
        List<Clazz> classList = studentService.findClassAll();

        //将查询出来的学生对象存储到域中
        request.setAttribute("student",student);
        request.setAttribute("classList",classList);
        //请求转发
        try {
            request.getRequestDispatcher("/jsp/update.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) {

        //获取客户端的数据
        String studentName = request.getParameter("studentName");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String cid = request.getParameter("cid");

        //获取爱好数组
        String[] hobbyArray = request.getParameterValues("hobby");

        String hobbies = "";

        //遍历爱好数组
        for (String hobby : hobbyArray) {

            hobbies += ","+hobby;

        }

        hobbies = hobbies.substring(1);

        //创建一个student对象
        Student student = new Student();
        //将数据存入对象中
        student.setStudentName(studentName);
        student.setBirthday(birthday);
        student.setSex(Integer.parseInt(sex));
        student.setCid(Integer.parseInt(cid));
        student.setHobby(hobbies);
        student.setAddress(address);

        //调用业务层
        String flag = studentService.toAdd(student);

        try {
            response.getWriter().print(flag);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }

    //查询所有的班级信息

    public void findClassAll(HttpServletRequest request, HttpServletResponse response) {

        //获取所有的班级数据
        List<Clazz> clazzList = studentService.findClassAll();
        //将数据存储到域中
        request.setAttribute("clazzList",clazzList);
        //将java对象转成json数据格式
        String toJSONString = JSON.toJSONString(clazzList);
        //将数据推送给前端
        try {
            response.getWriter().print(toJSONString);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }

    //实现学生的列表

    public void getStudentList(HttpServletRequest request, HttpServletResponse response){

        String likeName = request.getParameter("likeName");
        //获取所有的学生记录
        List<Student> studentList = studentService.getStudentList(likeName);

        //将学生集合存储在 域 中
        request.setAttribute("studentList",studentList);

        try {
            //请求转发
            request.getRequestDispatcher("/jsp/list.jsp").forward(request,response);

        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}