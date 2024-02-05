package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.Book;
import com.ctrl.simpleapp.rest.api.repository.BookRepository;
import com.ctrl.simpleapp.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);


    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book, Long bookId) {

        if (bookRepository.findById(bookId).isPresent()) {
            Book bookDB = bookRepository.findById(bookId).get();
            return bookRepository.save(bookDB);
        } else {
            LOGGER.error("Book not found in our database - id : {}", book.id());
            return null;
        }
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.findById(bookId);
        LOGGER.info("Book deleted - id : {}", bookId);
    }
}
