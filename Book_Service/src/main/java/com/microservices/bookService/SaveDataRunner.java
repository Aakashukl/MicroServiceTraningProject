package com.microservices.bookService;

import com.microservices.bookService.entity.Book;
import com.microservices.bookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class SaveDataRunner implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1,10).forEach(i -> {
            bookRepository.save(new Book(i,"CSE-"+i,"cse"+i,i,4*i));
        });
    }
}
