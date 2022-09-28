package com.api.book.bootrestbook.controller;


import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBooks(){

        return  this.bookService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getbookById(@PathVariable("id") int id){
      return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addbook(@RequestBody Book book){
      Book b  = this.bookService.addBook(book);
        return b;
    }

    //delete book
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }


}
