package com.microservices.bookService.service;

import com.microservices.bookService.entity.Book;
import com.microservices.bookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book deleteBook(long id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> bookRepository.delete(b));
        return book.orElseGet(Book::new);
    }

    @Override
    public Optional<Book> updateAvailableCopies(long bookId, int incrementCount) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setAvailableCopies(book1.getAvailableCopies()+incrementCount);
            bookRepository.save(book1);
            return Optional.of(book1);
        }
        return Optional.empty();
    }
}
