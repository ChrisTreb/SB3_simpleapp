package com.ctrl.simpleapp.records;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="user")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,
        String name,
        String firstname,
        String email,
        String gender,
        String phone,
        String address,
        String city,
        String country,
        String postalCode) {
}
