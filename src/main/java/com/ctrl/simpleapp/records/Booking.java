package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name="booking", schema="public")
public record Booking(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        Date created_at,
        long user_id,
        long place_id,
        int room_number,
        Date start_date,
        Date end_date) {
}
