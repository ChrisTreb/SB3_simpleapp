package com.ctrl.simpleapp.records;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name="place", schema="public")
public record Place(@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    long id,
                    Date created_at,
                    String address,
                    String city,
                    String country,
                    String postalCode,
                    int free_rooms) {
}
