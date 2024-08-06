package com.transaction.dao;
import com.transaction.JDBCUtils;
import com.transaction.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Integer insert(User user) {
        String sql = "insert into tb_user(name,age,address)values(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = JDBCUtils.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getAge());
            preparedStatement.setString(3,user.getAddress());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer delete(Integer uid) {
        String sql = "delete from tb_user where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = JDBCUtils.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,uid);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer update(User user) {
        String sql = "update tb_user set name = ?,age=?,address=? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = JDBCUtils.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getAge());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setInt(4,user.getId());
            int executeUpdate = preparedStatement.executeUpdate();

            int i = 1 / 0;

            return executeUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> select() {

        String sql = "select * from tb_user";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = JDBCUtils.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (resultSet != null && resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                User user = new User();
                user.setName(name);
                user.setAddress(address);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
