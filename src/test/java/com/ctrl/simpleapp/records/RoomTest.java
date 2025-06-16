package com.ctrl.simpleapp.records;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class RoomTest {

    private final Date testDate = new Date();

    @Test
    void testRecordCreationAndGetters() {
        Room room = new Room(
                1L,
                100L,
                testDate,
                305,
                "Deluxe Suite",
                250.0,
                4,
                true,
                "suite.jpg",
                "Chambre spacieuse avec vue mer"
        );

        assertAll("Vérification de tous les champs",
                () -> assertEquals(1L, room.id()),
                () -> assertEquals(100L, room.place_id()),
                () -> assertEquals(testDate, room.created_at()),
                () -> assertEquals(305, room.room_number()),
                () -> assertEquals("Deluxe Suite", room.room_type()),
                () -> assertEquals(250.0, room.price_per_night()),
                () -> assertEquals(4, room.guests_capacity()),
                () -> assertTrue(room.is_available()),
                () -> assertEquals("suite.jpg", room.image()),
                () -> assertEquals("Chambre spacieuse avec vue mer", room.description())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        Room room1 = new Room(1L, 100L, testDate, 101, "Standard", 100.0, 2, true, "img.jpg", "Desc");
        Room room2 = new Room(1L, 100L, testDate, 101, "Standard", 100.0, 2, true, "img.jpg", "Desc");
        Room differentRoom = new Room(2L, 200L, testDate, 201, "VIP", 500.0, 4, false, "vip.jpg", "Luxe");

        assertAll("Tests d'égalité",
                () -> assertEquals(room1, room2),
                () -> assertNotEquals(room1, differentRoom),
                () -> assertEquals(room1.hashCode(), room2.hashCode()),
                () -> assertNotEquals(room1.hashCode(), differentRoom.hashCode())
        );
    }

    @Test
    void testToString() {
        Room room = new Room(1L, 100L, testDate, 101, "Standard", 99.9, 2, true, "room.jpg", "Simple");
        String toString = room.toString();

        assertAll("Vérification toString()",
                () -> assertTrue(toString.contains("101")),
                () -> assertTrue(toString.contains("Standard")),
                () -> assertTrue(toString.contains("99.9")),
                () -> assertTrue(toString.contains("true")),
                () -> assertTrue(toString.contains("room.jpg"))
        );
    }

    @Test
    void testEdgeCases() {
        Room minValues = new Room(Long.MIN_VALUE, Long.MIN_VALUE, new Date(0),
                Integer.MIN_VALUE, "", 0.0, 0, false, "", "");
        Room maxValues = new Room(Long.MAX_VALUE, Long.MAX_VALUE, new Date(),
                Integer.MAX_VALUE, "VIP", Double.MAX_VALUE,
                Integer.MAX_VALUE, true, "max.jpg", "Max");

        assertAll("Valeurs limites",
                () -> assertNotNull(minValues),
                () -> assertNotNull(maxValues),
                () -> assertEquals(Integer.MIN_VALUE, minValues.room_number()),
                () -> assertEquals(Double.MAX_VALUE, maxValues.price_per_night())
        );
    }
}
