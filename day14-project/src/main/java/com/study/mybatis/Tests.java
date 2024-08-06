package com.study.mybatis;

import com.study.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Tests {
    private final String resource = "mybatis-config.xml";

    InputStream in = Resources.getResourceAsStream(resource);

    // 创建SqlSessionFactory对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

    // 创建SqlSession对象
    SqlSession sqlSession = factory.openSession();


    public Tests() throws IOException {
    }

    public List<Emp> findAllEmp() {

        return sqlSession.selectList("emp.findAllEmp");

    }

}
