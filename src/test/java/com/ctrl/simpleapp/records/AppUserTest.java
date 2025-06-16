package com.ctrl.simpleapp.records;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppUserTest {

    private final Date testDate = new Date();

    @Test
    void testRecordCreationAndGetters() {
        AppUser user = new AppUser(
                1L,
                testDate,
                "Doe",
                "John",
                "john.doe@example.com",
                "M",
                testDate,
                "123 Main St",
                "Paris",
                "France",
                "USER",
                "profile.jpg",
                "johndoe",
                "encryptedPassword"
        );

        System.out.println(user);

        assertAll("Vérification de tous les champs",
                () -> assertEquals(1L, user.id()),
                () -> assertEquals(testDate, user.created_at()),
                () -> assertEquals("Doe", user.lastname()),
                () -> assertEquals("John", user.firstname()),
                () -> assertEquals("john.doe@example.com", user.email()),
                () -> assertEquals("M", user.gender()),
                () -> assertEquals(testDate, user.date_of_birth()),
                () -> assertEquals("123 Main St", user.address()),
                () -> assertEquals("Paris", user.city()),
                () -> assertEquals("France", user.country()),
                () -> assertEquals("USER", user.role()),
                () -> assertEquals("profile.jpg", user.image()),
                () -> assertEquals("johndoe", user.login()),
                () -> assertEquals("encryptedPassword", user.password())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        AppUser user1 = new AppUser(1L, testDate, "Doe", "John", "email",
                "M", testDate, "addr", "Paris", "FR",
                "USER", "img", "login", "pass");

        AppUser user2 = new AppUser(1L, testDate, "Doe", "John", "email",
                "M", testDate, "addr", "Paris", "FR",
                "USER", "img", "login", "pass");

        AppUser differentUser = new AppUser(2L, testDate, "Smith", "Jane",
                "email", "F", testDate, "addr",
                "Lyon", "FR", "ADMIN", "img",
                "login", "pass");

        assertAll("Tests d'égalité",
                () -> assertEquals(user1, user2),
                () -> assertNotEquals(user1, differentUser),
                () -> assertEquals(user1.hashCode(), user2.hashCode()),
                () -> assertNotEquals(user1.hashCode(), differentUser.hashCode())
        );
    }

    @Test
    void testToString() {
        AppUser user = new AppUser(1L, testDate, "Doe", "John", "email",
                "M", testDate, "addr", "Paris", "FR",
                "USER", "img", "login", "pass");

        String toString = user.toString();

        assertAll("Vérification toString()",
                () -> assertTrue(toString.contains("Doe")),
                () -> assertTrue(toString.contains("John")),
                () -> assertTrue(toString.contains("email")),
                () -> assertTrue(toString.contains("USER"))
        );
    }
}
