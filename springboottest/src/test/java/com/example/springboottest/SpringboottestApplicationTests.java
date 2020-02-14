package com.example.springboottest;

import com.example.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void findall() {
        System.out.println(bookRepository.findAll());
    }

}
