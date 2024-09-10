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
        long placeId,
        Date created_at,
        int roomNumber,
        String roomType,
        double pricePerNight,
        int guestsCapacity,
        boolean isAvailable) {
}

