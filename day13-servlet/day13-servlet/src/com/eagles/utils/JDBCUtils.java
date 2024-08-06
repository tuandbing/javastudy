package com.eagles.utils;

import java.sql.*;

public class JDBCUtils {

    public static final String DATABASE = "db_eagles117(2)";

    private JDBCUtils(){

    }

    static {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE+"?characterEncoding=utf8&serverTimezone=GMT%2B8",
                "root","password");
    }

    /**
     * 关闭资源
     * @return
     */
    public static void getClose(ResultSet resultSet,Statement statement,Connection connection){

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
