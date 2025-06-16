package com.ctrl.simpleapp.records;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class PaymentTest {

    private final Date testDate = new Date();

    @Test
    void testRecordCreationAndGetters() {
        Payment payment = new Payment(
                1L,
                100L,
                testDate,
                testDate
        );

        assertAll("Vérification de tous les champs",
                () -> assertEquals(1L, payment.id()),
                () -> assertEquals(100L, payment.booking_id()),
                () -> assertEquals(testDate, payment.created_at()),
                () -> assertEquals(testDate, payment.payment_date())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        Payment payment1 = new Payment(1L, 100L, testDate, testDate);
        Payment payment2 = new Payment(1L, 100L, testDate, testDate);
        Payment differentPayment = new Payment(2L, 200L, testDate, testDate);

        assertAll("Tests d'égalité",
                () -> assertEquals(payment1, payment2),
                () -> assertNotEquals(payment1, differentPayment),
                () -> assertEquals(payment1.hashCode(), payment2.hashCode()),
                () -> assertNotEquals(payment1.hashCode(), differentPayment.hashCode())
        );
    }

    @Test
    void testToString() {
        Payment payment = new Payment(1L, 100L, testDate, testDate);
        String toString = payment.toString();

        assertAll("Vérification toString()",
                () -> assertTrue(toString.contains("1")),
                () -> assertTrue(toString.contains("100")),
                () -> assertTrue(toString.contains("payment_date"))
        );
    }
}
