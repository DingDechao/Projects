package org.example.java11.jdbc;

import org.example.java11.entity.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDDemo {
    public void add(Book bd) {
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            Statement st = conn.createStatement();
            //获取数据使用get方法
            String sql = "insert into book values(" + bd.getBookid() + ",'" +  bd.getBookname() + "'," + bd.getPressid() + ",'" + bd.getAuthor() + "','" + bd.getPressdate() + "'," + bd.getPrice() + ",'" + bd.getIndate() + "'," + bd.getBookcount() + "," + bd.getBooksur() + ")";
            //如果插入成功则返回一个大于0的数，课根据其返回的值是否大于0来判断该条更新语句是否执行成功
            int count = st.executeUpdate(sql);
            System.out.println(count);
            dbm.closeconn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void midify(Book bd) {
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            Statement st = conn.createStatement();
            System.out.println(bd.getBookname() + "/" + bd.getBookid());
            String sql = "update book set bookname='" + bd.getBookname() + "' where bookid=" + bd.getBookid();
            int count = st.executeUpdate(sql);
            System.out.println(count);
            dbm.closeconn(conn);
        } catch (SQLException e) {
        }
    }

    public void delete(int id) {
        try {
//			PreparedStatement
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();
            Statement st = conn.createStatement();
            String sql = "delete from book where bookid=" + id;
            int count = st.executeUpdate(sql);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Book book = new Book(1, "大学物理3", 4, "www", "20111001", 145f, "20121001", 20, 20);
        //修改数据使用set方法
        book.setAuthor("xiaoqiang");

        CRUDDemo insertDemo = new CRUDDemo();
        //insertDemo.add(book);
        book.setBookname("大学物理");
		insertDemo.midify(book);
        //insertDemo.delete(14);
    }
}

