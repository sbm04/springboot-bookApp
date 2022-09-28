package com.api.book.bootrestbook.entities;


public class Book {



    private int id;
    private String title;
    private String auther;

    public Book() {

    }

    public Book(int id, String title, String auther) {
        this.id = id;
        this.title = title;
        this.auther = auther;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
