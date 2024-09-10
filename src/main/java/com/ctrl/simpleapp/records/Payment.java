package com.ctrl.simpleapp.records;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Entity
@Table(name="payment", schema="public")
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        long bookingId,
        Date created_at,
        Date paymentDate) {
}

