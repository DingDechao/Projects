package org.example.java11.dao;

import org.example.java11.entity.Book;

import java.util.List;

public class BookSYS {
    public static void main(String[] args) {
        BookDAO bdao = new BookDAO();
        List<Book> list = bdao.quaryAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getBookname());
        }
    }
}

