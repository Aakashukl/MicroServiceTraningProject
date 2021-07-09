package com.microservices.bookService.service;

import com.microservices.bookService.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();

    Book save(Book book);

    Optional<Book> findById(long id);

    Book deleteBook(long id);

  Optional<Book> updateAvailableCopies(long bookId, int incrementCount);
}
