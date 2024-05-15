package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Book;
import com.ctrl.simpleapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> fetchBooksList() {
        return bookService.fetchBookList();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long bookId) {
        return bookService.updateBook(book, bookId);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return "Book deleted successfully - id : " + bookId;
    }
}
