package com.ddc.projects.java11.java8.dao;

import com.ddc.projects.java11.java8.entity.Book;
import com.ddc.projects.java11.java8.jdbc.DBManager;
import com.ddc.projects.java11.java8.jdbc.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO是我们的数据传输对象，负责我们对数据的具体操作
public class BookDAO {
    //查询book表中的所有信息
    public List<Book> quaryAll() {
        List<Book> list = new ArrayList<Book>();
        Book bd = null;
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(Sql.QUARY_ALL_BOOK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String bookname = rs.getString("bookname");
                int pressid = rs.getInt("pressid");
                String author = rs.getString("author");
                String pressdate = rs.getString("pressdate");
                float price = rs.getFloat("price");
                String indate = rs.getString("indate");
                int bookcount = rs.getInt("bookcount");
                int booksur = rs.getInt("booksur");
                bd = new Book(bookid, bookname, pressid, author, pressdate, price, indate, bookcount, booksur);
                list.add(bd);
            }
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据id查询信息
    public Book quaryById(Book bd) {
        int id = bd.getBookid();
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(Sql.QUARY_BYID_BOOK);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int bookid = rs.getInt("bookid");
            String bookname = rs.getString("bookname");
            int pressid = rs.getInt("pressid");
            String author = rs.getString("author");
            String pressdate = rs.getString("pressdate");
            float price = rs.getFloat("price");
            String indate = rs.getString("indate");
            int bookcount = rs.getInt("bookcount");
            int booksur = rs.getInt("booksur");
            bd = new Book(bookid, bookname, pressid, author, pressdate, price, indate, bookcount, booksur);
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bd;
    }

    //添加信息
    public int add(Book bd) {
        int flag = 0;
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(Sql.INSERT_BOOK);
            ps.setString(1, bd.getBookname());
            ps.setInt(2, bd.getPressid());
            ps.setString(3, bd.getAuthor());
            ps.setString(4, bd.getPressdate());
            ps.setFloat(5, bd.getPrice());
            ps.setString(6, bd.getIndate());
            ps.setInt(7, bd.getBookcount());
            ps.setInt(8, bd.getBooksur());
            flag = ps.executeUpdate();
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //修改信息
    public int midify(Book bd) {
        int flag = 0;
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(Sql.UPDATE_NAME_BOOK);
            ps.setString(1, bd.getBookname());
            ps.setInt(2, bd.getBookid());
            flag = ps.executeUpdate();
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //删除信息
    public int delete(Book bd) {
        int flag = 0;
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            PreparedStatement ps = conn.prepareStatement(Sql.DELETE_BYID_BOOK);
            ps.setInt(1, bd.getBookid());
            flag = ps.executeUpdate();
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

