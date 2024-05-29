package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name="appuser")
public record AppUser(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        Date created_at,
        String lastname,
        String firstname,
        String email,
        String gender,
        String phone,
        String address,
        String city,
        String country,
        String postalCode) {
}
