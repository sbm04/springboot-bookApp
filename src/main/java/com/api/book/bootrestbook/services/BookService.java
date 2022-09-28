package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12,"Java Complete Reference " , "XYZ "));
        list.add(new Book(36,"Head First to java " , "ABC"));
        list.add(new Book(48,"Thing in java  " , "LMN "));
    }
    //get all books
    public List<Book> getAllBooks(){

        return list;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return  book;
    }
    //add book
    public Book addBook(Book book){
        list.add(book);
        return book;

    }
    //update book
    public void upDate(Book book,int bookid){
        list= list.stream().map(b->{
             if(b.getId()==bookid){
                 b.setTitle(book.getTitle());
                 b.setAuther(book.getAuther());

             }
             return b;
         }).collect(Collectors.toList());
    }

    //delete book
    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }
}
