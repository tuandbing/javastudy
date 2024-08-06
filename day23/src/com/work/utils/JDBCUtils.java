package com.work.utils;

import java.sql.*;

public class JDBCUtils {
    private JDBCUtils(){

    }
    private static final Connection connection;

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tests?characterEncoding=utf8&serverTimezone=GMT%2B8","root","pyw040212");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static Connection getConnection() throws SQLException {
        return connection;
    }

    public static void getClose(ResultSet resultSet, Statement statement, Connection connection){

        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
