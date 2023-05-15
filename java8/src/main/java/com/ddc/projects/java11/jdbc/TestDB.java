package com.ddc.projects.java11.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestDB {
    public static void main(String[] args) {
        try {
            //首先要想操作数据库要取得对数据库的连接
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            //准备好我们需要执行的sql语句
            String sql = "select * from book where price > 100";
            //得到我们statement对象，负责把我们的数据库语句（sql语句）传递到数据库中，其中可以为返回的结果集设置模式，默认的是typy_forword_only
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //执行我们的sql语句，并返回我们查询的结果集，存放在resultset中，以方便程序调用
            ResultSet rs = st.executeQuery(sql);
            //取出我们resultset中的每一条记录(根据字段名称获得当前字段的值)
            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String bookname = rs.getString("bookname");
                int pressid = rs.getInt("pressid");
                String author = rs.getString("author");
                Date pressdate = rs.getDate("pressdate");
                float price = rs.getFloat("price");
                int booksur = rs.getInt("booksur");
                System.out.println(bookid + "/" + bookname + "/" + pressid + "/" + author + "/" + pressdate + "/" + price + "/" + booksur);
            }
            System.out.println("----------------------------------------------------------------------------------------");
            while (rs.previous()) {
                int bookid = rs.getInt("bookid");
                String bookname = rs.getString("bookname");
                int pressid = rs.getInt("pressid");
                String author = rs.getString("author");
                Date pressdate = rs.getDate("pressdate");
                float price = rs.getFloat("price");
                int booksur = rs.getInt("booksur");
                System.out.println(bookid + "/" + bookname + "/" + pressid + "/" + author + "/" + pressdate + "/" + price + "/" + booksur);
            }
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

