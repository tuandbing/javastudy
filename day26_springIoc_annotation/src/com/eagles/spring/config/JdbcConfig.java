package com.eagles.spring.config;


import com.eagles.spring.pojo.Jdbc;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
@Import(SpringConfig.class)
public class JdbcConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.driver}")
    private String driver;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean("jdbc")
    public Jdbc getJdbc(){

        return new Jdbc(username,password,driver,url);

    }


}
