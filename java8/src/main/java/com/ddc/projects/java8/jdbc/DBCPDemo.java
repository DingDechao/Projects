//package com.ddc.projects.java8.jdbc;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.apache.commons.dbcp.BasicDataSource;
//
//public class DBCPDemo {
//    //准备创建粗要的字符串
//    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String URL = "jdbc:sqlserver://192.168.17.217:1433;databaseName=booksys";
//    private static final String USERNAME = "sa";
//    private static final String USERPASS = "admin123";
//    private static final int MAX = 30;
//    private static BasicDataSource dbs = null;
//
//    static {
//        //保证每次加载都能获得一个最新的dbs，并且都设置好每一项参数
//        dbs = new BasicDataSource();
//        dbs.setMaxActive(MAX);
//        dbs.setDriverClassName(DRIVER);
//        dbs.setUrl(URL);
//        dbs.setUsername(USERNAME);
//        dbs.setPassword(USERPASS);
//    }
//
//    //取得连接
//    public Connection getconn() {
//        Connection conn = null;
//        try {
//            conn = dbs.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    //关闭连接，以节省系统资源
//    public void closeconn(Connection conn, ResultSet rs, Statement st) {
//        try {
//            conn.close();
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
////	public static void main(String[] args) {
////
////		System.out.println(new DBCPDemo().getconn());
////
////	}
//}
