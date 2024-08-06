package com.transaction;
import java.sql.SQLException;

public class TransactionManager {

    /**
     * 开启事务
     */
    public static void startTransaction(){
        try {
            System.out.println("开启事务~~");
            JDBCUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction(){
        try {
            System.out.println("提交事务~~");
            JDBCUtils.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction(){
        try {
            System.out.println("回滚事务~~");
            JDBCUtils.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
