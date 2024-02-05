package com.ctrl.simpleapp.rest.api.repository;

import com.ctrl.simpleapp.records.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
