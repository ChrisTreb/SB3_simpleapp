package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Entity
@Table(name="book")
public record Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        Timestamp created_at,
        String book_title,
        String author,
        String isbn,
        boolean available) {
}
