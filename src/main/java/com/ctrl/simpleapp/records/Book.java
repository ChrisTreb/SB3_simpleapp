package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name="book", schema="public")
public record Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        Date created_at,
        String book_title,
        String author,
        String isbn,
        boolean available) {
}
