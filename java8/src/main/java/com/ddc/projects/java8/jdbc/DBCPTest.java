//package com.ddc.projects.java8.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DBCPTest {
//
//    public static void main(String[] args) {
//        Connection conn = new DBCPDemo().getconn();
//        try {
//            String sql = "select * from book";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int bookid = rs.getInt("bookid");
//                String bookname = rs.getString("bookname");
//                int pressid = rs.getInt("pressid");
//                String author = rs.getString("author");
//                String pressdate = rs.getString("pressdate");
//                float price = rs.getFloat("price");
//                String indate = rs.getString("indate");
//                int bookcount = rs.getInt("bookcount");
//                int booksur = rs.getInt("booksur");
//                System.out.println(bookid + "/" + bookname + "/" + pressid + "/" + author + "/" + "/" + price + "/" + booksur);
//            }
//            new DBCPDemo().closeconn(conn, rs, ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//}