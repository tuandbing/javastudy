package com.work;


import com.work.pojo.User;
import com.work.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyClassProxy implements MyInterface {

    /**
     * 设置成单例模式
     */
    private static final MyClassProxy myClassProxy = new MyClassProxy();

    private MyClassProxy(){

    }

    public static MyClassProxy getMyClassProxy(){
        return myClassProxy;
    }
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<User> select(Integer id) {

        List<User> users = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from tb_user where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet!= null && resultSet.next()){

                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.getClose(resultSet,preparedStatement,connection);
        }
        return users;
    }

    @Override
    public void update(User user) {
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update tb_user set username = ?, password = ? where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void insert(User user) {
        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into tb_user values (?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from tb_user where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
