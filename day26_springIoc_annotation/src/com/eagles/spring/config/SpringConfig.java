package com.eagles.spring.config;

import com.eagles.spring.pojo.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Configuration : 声明当前类为核心配置类
 * @Bean: 修饰方法,可以将方法的返回值作为一份实例装载进spring的核心容器
 * @ComponentScan: 基于核心配置类,开启扫描包
 * @Import: 引入别的核心配置类
 */

@Configuration
@ComponentScan("com.eagles.spring.ioc")
public class SpringConfig {

    @Bean("teacher")
    public Teacher getTeacher(@Qualifier("date1") Date date){
        Teacher teacher = new Teacher();
        teacher.setId(10);
        teacher.setName("佩奇");
        teacher.setDate(date);
        return teacher;
    }

    @Bean("date1")
    public Date getDate1(){

        return new Date();
    }

    @Bean("date2")
    public Date getDate2(){

        return new Date();
    }

}
