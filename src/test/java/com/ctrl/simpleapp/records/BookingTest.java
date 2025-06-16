package com.ctrl.simpleapp.records;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class BookingTest {

    private final Date testDate = new Date();

    @Test
    void testRecordCreationAndGetters() {
        Booking booking = new Booking(
                1L,
                testDate,
                2L,
                3L,
                4L,
                5,
                testDate,
                testDate,
                100.0,
                "CONFIRMED"
        );

        assertAll("Vérification de tous les champs",
                () -> assertEquals(1L, booking.id()),
                () -> assertEquals(testDate, booking.created_at()),
                () -> assertEquals(2L, booking.user_id()),
                () -> assertEquals(3L, booking.place_id()),
                () -> assertEquals(4L, booking.room_id()),
                () -> assertEquals(5, booking.number_of_guests()),
                () -> assertEquals(testDate, booking.start_date()),
                () -> assertEquals(testDate, booking.end_date()),
                () -> assertEquals(100.0, booking.total_price()),
                () -> assertEquals("CONFIRMED", booking.status())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        Booking booking1 = new Booking(1L, testDate, 2L, 3L, 4L, 5, testDate, testDate, 100.0, "CONFIRMED");
        Booking booking2 = new Booking(1L, testDate, 2L, 3L, 4L, 5, testDate, testDate, 100.0, "CONFIRMED");
        Booking differentBooking = new Booking(2L, testDate, 2L, 3L, 4L, 5, testDate, testDate, 100.0, "CANCELLED");

        assertAll("Tests d'égalité",
                () -> assertEquals(booking1, booking2),
                () -> assertNotEquals(booking1, differentBooking),
                () -> assertEquals(booking1.hashCode(), booking2.hashCode()),
                () -> assertNotEquals(booking1.hashCode(), differentBooking.hashCode())
        );
    }

    @Test
    void testToString() {
        Booking booking = new Booking(1L, testDate, 2L, 3L, 4L, 5, testDate, testDate, 100.0, "CONFIRMED");
        String toString = booking.toString();

        assertAll("Vérification toString()",
                () -> assertTrue(toString.contains("CONFIRMED")),
                () -> assertTrue(toString.contains("100.0")),
                () -> assertTrue(toString.contains("1"))
        );
    }
}
