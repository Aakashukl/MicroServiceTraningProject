package com.microservices.bookService.restController;

import com.microservices.bookService.entity.Book;
import com.microservices.bookService.service.BookService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id) {
        return bookService.findById(id).map(book -> new ResponseEntity<>(book, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/books/updateAvailability/{id}/{incrementCount}")
    public ResponseEntity<?> updateAvailableCopies(@PathVariable long id,@PathVariable int incrementCount) {
        Optional<Book> book = bookService.updateAvailableCopies(id, incrementCount);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
    }
}
