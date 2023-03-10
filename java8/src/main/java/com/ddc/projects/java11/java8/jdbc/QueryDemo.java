package com.ddc.projects.java11.java8.jdbc;

import com.ddc.projects.java11.java8.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDemo {
    private DBManager dbm=new DBManager();
    private Connection conn=null;

    public void quaryAll(){
        try {
            conn=dbm.getConnection();
            String sql="select * from book";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int bookid=rs.getInt("bookid");
                String bookname=rs.getString("bookname");
                int pressid=rs.getInt("pressid");
                String author=rs.getString("author");
                float price=rs.getFloat("price");
                int booksur=rs.getInt("booksur");
                System.out.println(bookid+"/"+bookname+"/"+pressid+"/"+author+"/"+"/"+price+"/"+booksur);
            }
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void quaryById(int id){
        try {
            conn=dbm.getConnection();
            //使用占位符，有效地防止了SQL注入
            String sql="select * from book where bookid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int bookid=rs.getInt("bookid");
            String bookname=rs.getString("bookname");
            int pressid=rs.getInt("pressid");
            String author=rs.getString("author");
            float price=rs.getFloat("price");
            int booksur=rs.getInt("booksur");
            System.out.println(bookid+"/"+bookname+"/"+pressid+"/"+author+"/"+"/"+price+"/"+booksur);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modify(int id, String name){
        try {
            conn=dbm.getConnection();
            String sql="update book set bookname=? where bookid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            //PreparedStatement 预编译之后需要给预留的占位符设值，要求setXX(此处是表示需要设值的占位符是第几个,需要设置的具体值)。
            ps.setInt(2, id);
            ps.setString(1, name);
            int aa=ps.executeUpdate();
            System.out.println(aa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Book bd){
        try {
            conn=dbm.getConnection();
            String sql="insert into book values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, bd.getBookname());
            ps.setInt(2, bd.getPressid());
            ps.setString(3, bd.getAuthor());
            ps.setString(4, bd.getPressdate());
            ps.setFloat(5, bd.getPrice());
            ps.setString(6, bd.getIndate());
            ps.setInt(7, bd.getBookcount());
            ps.setInt(8, bd.getBooksur());
            int aa =ps.executeUpdate();
            System.out.println(aa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QueryDemo pt=new QueryDemo();
//		pt.quaryAll();
//		pt.quaryById(6);
        pt.modify(9, "哈哈哲学");
        Book bd=new Book(0,"线性代数",4,"wnb","20111001",145f,"20121001", 20, 20);
        pt.add(bd);
    }
}

