package com.ddc.projects.java11.entity;

//DTO data transmission object 数据传输对象，是用来连接java代码和数据库之间的数据交互的
//DTO的好处，可以封装一张数据库基本表中的所有信息，可以保证数据的完整性，安全性
//传递起来比较方便
public class Book2 {
    //数据库表中的所有字段
    private int bookid;
    private String bookname;
    //外键pressid，是我们pressdto表中的主键，一个id就代表了一条dto对象
    private Press pdto;
    private String author;
    private String pressdate;
    private float price;
    private String indate;
    private int bookcount;
    private int booksur;

    public Book2() {
    }

    public Book2(int bookid, String bookname, Press pdto, String author,
                 String pressdate, float price, String indate, int bookcount,
                 int booksur) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.pdto = pdto;
        this.author = author;
        this.pressdate = pressdate;
        this.price = price;
        this.indate = indate;
        this.bookcount = bookcount;
        this.booksur = booksur;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Press getPdto() {
        return pdto;
    }

    public void setPdto(Press pdto) {
        this.pdto = pdto;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressdate() {
        return pressdate;
    }

    public void setPressdate(String pressdate) {
        this.pressdate = pressdate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public int getBookcount() {
        return bookcount;
    }

    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }

    public int getBooksur() {
        return booksur;
    }

    public void setBooksur(int booksur) {
        this.booksur = booksur;
    }
}

