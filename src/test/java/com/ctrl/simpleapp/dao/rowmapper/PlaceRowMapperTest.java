package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.Place;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceRowMapperTest {

    @Test
    void mapRow_shouldMapResultSetToPlace() throws Exception {
        // Arrange
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("id")).thenReturn(10L);
        Timestamp createdAt = Timestamp.valueOf("2024-06-17 12:00:00");
        when(rs.getTimestamp("created_at")).thenReturn(createdAt);
        when(rs.getString("name")).thenReturn("Salle Polyvalente");
        when(rs.getString("address")).thenReturn("10 rue des Lilas");
        when(rs.getString("city")).thenReturn("Lyon");
        when(rs.getString("country")).thenReturn("France");
        when(rs.getString("description")).thenReturn("Grande salle pour événements");
        when(rs.getString("phone_number")).thenReturn("0102030405");
        when(rs.getString("email")).thenReturn("contact@sallepoly.fr");
        when(rs.getInt("rating")).thenReturn(5);
        when(rs.getString("image")).thenReturn("salle.png");

        PlaceRowMapper rowMapper = new PlaceRowMapper();

        // Act
        Place place = rowMapper.mapRow(rs, 1);

        // Assert
        assertNotNull(place);
        assertEquals(10L, place.id());
        assertEquals(createdAt, place.created_at());
        assertEquals("Salle Polyvalente", place.name());
        assertEquals("10 rue des Lilas", place.address());
        assertEquals("Lyon", place.city());
        assertEquals("France", place.country());
        assertEquals("Grande salle pour événements", place.description());
        assertEquals("0102030405", place.phone_number());
        assertEquals("contact@sallepoly.fr", place.email());
        assertEquals(5, place.rating());
        assertEquals("salle.png", place.image());
    }
}