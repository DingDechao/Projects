package org.example.java11.dao;

import org.example.java11.entity.Book2;
import org.example.java11.entity.Press;
import org.example.java11.jdbc.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookDAO2 {

    public String pressname(String bookname) {
        String pressname = null;
        Book2 bd2 = new Book2();
        Press pd = new Press();

        String sql = "select p.pressname from book as b,bookpress as p where p.pressid=b.pressid and b.bookname=?";
        try {
            PreparedStatement ps = new DBManager().getConnection().prepareStatement(sql);
            ps.setString(1, bookname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pressname = rs.getString("bookname");
                System.out.println(pressname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pressname;
    }

    public static void main(String[] args) {
        Book2 bd = new Book2();
        Press pd = new Press();
        pd.setPressname("清华大学出版社");
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();

            String sql2 = "select * from bookpress where pressname=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, pd.getPressname());
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            int pid = rs2.getInt("pressid");
            String pressname = rs2.getString("pressname");
            String pressaddr = rs2.getString("pressaddr");
            int presstel = rs2.getInt("presstel");
            System.out.println(pid);
            pd = new Press(pid, pressname, pressaddr, presstel);
            bd.setPdto(pd);
            //---------------------------------------------------------
            String sql = "select * from book where pressid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bd.getPdto().getPressid());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String bookname = rs.getString("bookname");
                System.out.println(bookname);
            }
            System.out.println(bd.getPdto().getPressname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

