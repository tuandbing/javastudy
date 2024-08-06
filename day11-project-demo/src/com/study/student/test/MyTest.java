package com.study.student.test;

import com.study.student.pojo.Clazz;
import com.study.student.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    private final String resource = "mybatis-config.xml";

    InputStream in = Resources.getResourceAsStream(resource);
    // 创建SqlSessionFactory对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

    // 创建SqlSession对象
    SqlSession sqlSession = factory.openSession();

    public MyTest() throws IOException {
    }

    public String toAddStudent(Student student) {

        // 调用SqlSession对象的insert方法执行查询
        int result = sqlSession.insert("student.addStudent", student);

        // 提交事务,不作提交数据库中没有对于的数据
        sqlSession.commit();

        return result > 0 ? "true" : "false";
    }

    public String deleteById(Integer id) {
        // 调用SqlSession对象的insert方法执行查询
        int result = sqlSession.delete("student.deleteStudent", id);

        // 提交事务
        sqlSession.commit();

        // 关闭session
        sqlSession.close();

        return result > 0 ? "true" : "false";

    }

    public List<Student> findStudent(String likeName) {
        // List<Student> students = new ArrayList<>();

        /*if (likeName != null) {
            students = sqlSession.selectList("student.findStudentByName", likeName);
        } else {
            students = sqlSession.selectList("student.findAllStudents");
        }*/

        //return students;
        return sqlSession.selectList("student.findStudentByName", likeName);
    }
    public List<Student> findStu(Student student) {
        return sqlSession.selectList("student.findStu", student);
    }
    public String UpdateStudent(Student student) {

        // 调用SqlSession对象的insert方法执行查询
        int result = sqlSession.update("student.updateStudent", student);

        // 提交事务,不作提交数据库中没有对于的数据
        sqlSession.commit();

        return result > 0 ? "true" : "false";

    }
    public List<Clazz> findClassAll(){

        return sqlSession.selectList("student.findStudentByName");
    }

    public Student findStuById(int id){

        return sqlSession.selectOne("student.findStuById", id);
    }

    public String deleteStuBySids(int id){
        int result = sqlSession.delete("student.deleteStuBySids", id);

        // 提交事务
        sqlSession.commit();

        // 关闭session
        sqlSession.close();

        return result > 0 ? "true" : "false";
    }
}
