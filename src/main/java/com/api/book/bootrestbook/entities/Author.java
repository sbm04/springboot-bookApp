package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int authorId;
    private String firstName;
    private String lastName;
    private String langauge;

  @OneToOne(mappedBy = "author")
  @JsonBackReference
   private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, String langauge) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.langauge = langauge;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLangauge() {
        return langauge;
    }

    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }
}