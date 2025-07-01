package org.example.java11.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    //获得我们连接数据库所需要的字符串，并且都定义成全局的final类型的，以方便调用
    //驱动字符串
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //连接url
    private static final String URL = "jdbc:mysql://localhost:3306/ddc?serverTimezone=UTC";
    //用户名
    private static final String USERNAME = "root";
    //密码
    private static final String USERPASS = "root";

    //使用静态块实现驱动加载，可以保证只要调用当前类，驱动就被加载
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得一个连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, USERPASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭一个连接
    public static void closeconn(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBManager.getConnection();
    }
}

