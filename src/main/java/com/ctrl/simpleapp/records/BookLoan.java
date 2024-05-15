package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Entity
@Table(name="book_loan")
public record BookLoan(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        Timestamp createdAt,
        long bookId,
        long userId) {
}
