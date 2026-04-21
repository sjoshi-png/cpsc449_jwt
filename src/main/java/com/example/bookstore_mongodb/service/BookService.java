package com.example.bookstore_mongodb.service;

import com.example.bookstore_mongodb.entity.Book;
import com.example.bookstore_mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // create a book
    public Book createBook(Book book) {
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    // get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // diljit a book by id
    public void deleteBook(String id) {
    if (!bookRepository.existsById(id)) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found bruh");
    }
    bookRepository.deleteById(id);
    }

}
