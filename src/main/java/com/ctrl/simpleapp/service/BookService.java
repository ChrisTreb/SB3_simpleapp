package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> fetchBookList();

    Book updateBook(Book book, Long bookId);

    void deleteBookById(Long bookId);
}
