package com.ctrl.simpleapp.records;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Entity
@Table(name="room", schema="public")
public record Room(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        long place_id,
        Date created_at,
        int room_number,
        String room_type,
        double price_per_night,
        int guests_capacity,
        boolean is_available,
        String image) {
}

