package com.ddc.projects.java8.jdbc;

public class Sql {
    public static final String QUARY_ALL_BOOK = "select * from book";
    public static final String QUARY_BYID_BOOK = "select * from book where bookid=?";
    public static final String INSERT_BOOK = "insert into book values(?,?,?,?,?,?,?,?)";
    public static final String UPDATE_NAME_BOOK = "update book set bookname=? where bookid=?";
    public static final String DELETE_BYID_BOOK = "delete from book where bookid=?";
}
