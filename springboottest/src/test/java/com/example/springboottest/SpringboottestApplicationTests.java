package com.example.springboottest;

import com.example.springboottest.entity.Book;
import com.example.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class SpringboottestApplicationTests {
    @Autowired
    private BookRepository bookRepository;
//    @Test
//    void findall() {
//        System.out.println(bookRepository.findAll());
//    }
//    @Test
//    void find(){
//        PageRequest pageRequest=PageRequest.of(0,3);
//        Page<Book> page= bookRepository.findAll(pageRequest);
//        System.out.println(page);
//    }
    @Test
    void save()
    {
        Book book=new Book();
        book.setAuthor("刘大姐");
        book.setName("Java高级");
        Book b=bookRepository.save(book);
        System.out.println(b);
    }

}
