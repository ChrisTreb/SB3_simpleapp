package com.ctrl.simpleapp.records;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class PlaceTest {

    private final Date testDate = new Date();

    @Test
    void testRecordCreationAndGetters() {
        Place place = new Place(
                1L,
                testDate,
                "Le Grand Hôtel",
                "123 Avenue de France",
                "Paris",
                "France",
                "Un hôtel de luxe en plein centre-ville",
                "+33123456789",
                "contact@grandhotel.fr",
                5,
                "hotel.jpg"
        );

        assertAll("Vérification de tous les champs",
                () -> assertEquals(1L, place.id()),
                () -> assertEquals(testDate, place.created_at()),
                () -> assertEquals("Le Grand Hôtel", place.name()),
                () -> assertEquals("123 Avenue de France", place.address()),
                () -> assertEquals("Paris", place.city()),
                () -> assertEquals("France", place.country()),
                () -> assertEquals("Un hôtel de luxe en plein centre-ville", place.description()),
                () -> assertEquals("+33123456789", place.phone_number()),
                () -> assertEquals("contact@grandhotel.fr", place.email()),
                () -> assertEquals(5, place.rating()),
                () -> assertEquals("hotel.jpg", place.image())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        Place place1 = new Place(1L, testDate, "Nom", "Adresse", "Ville", "Pays", "Desc", "Tel", "Mail", 4, "img");
        Place place2 = new Place(1L, testDate, "Nom", "Adresse", "Ville", "Pays", "Desc", "Tel", "Mail", 4, "img");
        Place differentPlace = new Place(2L, testDate, "Autre", "Adresse", "Ville", "Pays", "Desc", "Tel", "Mail", 3, "img2");

        assertAll("Tests d'égalité",
                () -> assertEquals(place1, place2),
                () -> assertNotEquals(place1, differentPlace),
                () -> assertEquals(place1.hashCode(), place2.hashCode()),
                () -> assertNotEquals(place1.hashCode(), differentPlace.hashCode())
        );
    }

    @Test
    void testToString() {
        Place place = new Place(1L, testDate, "Nom", "Adresse", "Ville", "Pays", "Desc", "Tel", "Mail", 4, "img");
        String toString = place.toString();

        assertAll("Vérification toString()",
                () -> assertTrue(toString.contains("Nom")),
                () -> assertTrue(toString.contains("Adresse")),
                () -> assertTrue(toString.contains("Ville")),
                () -> assertTrue(toString.contains("img"))
        );
    }
}
