package com.eagles.spring.work.account.dao;

import com.eagles.spring.work.account.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save() {

        System.out.println("账户保存成功");

    }

    @Override
    public List<User> select(){
        return jdbcTemplate.query("select * from tb_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {



                    int id = resultSet.getInt("id");

                    String username = resultSet.getString("username");

                    String password = resultSet.getString("password");


                return new User(id,username,password);
            }
        });
    }

    @Override
    public Integer insert(User user) {
        return jdbcTemplate.update("insert into tb_user(username,password) values (?,?)",user.getUsername(),user.getPassword());
    }

    @Override
    public Integer delete(Integer id) {
        return jdbcTemplate.update("delete from tb_user where id = ?",id);
    }

    @Override
    public Integer update(User user) {
        return jdbcTemplate.update("update tb_user set username = ?,password = ? where id = ?",user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public User findUserById(Integer id) {
        return jdbcTemplate.queryForObject("select * from tb_user where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                int id = resultSet.getInt("id");

                String username = resultSet.getString("username");

                String password = resultSet.getString("password");


                return new User(id,username,password);
            }
        },id);
    }
}
