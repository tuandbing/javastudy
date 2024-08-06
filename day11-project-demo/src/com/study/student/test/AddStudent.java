package com.study.student.test;

import com.study.student.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AddStudent {

    public String toAddStudent(Student student){
        // 读取配置文件

        String resource = "mybatis-config.xml";

        try {

            // 获取配置文件的输入流
            InputStream in = Resources.getResourceAsStream(resource);

            // 创建SqlSessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            // 创建SqlSession对象
            SqlSession sqlSession = factory.openSession();

            // 调用SqlSession对象的insert方法执行查询
            int result = sqlSession.insert("student.addStudent", student);



            // 提交事务,不作提交数据库中没有对于的数据
            sqlSession.commit();

            // 关闭session
            sqlSession.close();

            return result > 0 ? "true" : "false";

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
