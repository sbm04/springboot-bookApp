package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
//    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(12,"Java Complete Reference " , "XYZ "));
//        list.add(new Book(36,"Head First to java " , "ABC"));
//        list.add(new Book(48,"Thing in java  " , "LMN "));
//    }
    @Autowired
    private BookRepository bookRepository;
    //get all books
    public List<Book> getAllBooks(){
        List<Book> list= ( List<Book>) this.bookRepository.findAll();
        return list ;
    }
    //get single book by id
    public Book getBookById(int id){
    //  Book book = null;
    //  book = list.stream().filter(e->e.getId()==id).findFirst().get();
        Book book =this.bookRepository.findById(id);
        return  book;
    }
    //add book
    public Book addBook(Book book){
        Book result = bookRepository.save(book);

        return result;

    }
    //update book
    public void upDate(Book book,int bookid){
//        list= list.stream().map(b->{
//             if(b.getId()==bookid){
//                 b.setTitle(book.getTitle());
//                 b.setAuther(book.getAuther());
//
//             }
//             return b;
//         }).collect(Collectors.toList());

        book.setId(bookid);
        bookRepository.save(book);
    }

    //delete book
    public void deleteBook(int bid){

       // list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }
}
