package com.example.springboottest.controller;

import com.example.springboottest.entity.Book;
import com.example.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page,
                              @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return bookRepository.findAll(pageRequest);
    }
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book book1=bookRepository.save(book);
        if(book!=null){
            return "success";
        }else {
            return "error";
        }

    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }
    @GetMapping("/del/{id}")
    public void del(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
    @PostMapping("/update")
    public String update(@RequestBody Book book){
        Book book1=bookRepository.save(book);
        if(book!=null){
            return "success";
        }else {
            return "error";
        }

    }
}
