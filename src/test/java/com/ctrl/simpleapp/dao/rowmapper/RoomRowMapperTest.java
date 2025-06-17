package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.Room;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomRowMapperTest {

    @Test
    void mapRow_shouldMapResultSetToRoom() throws Exception {
        // Arrange
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("id")).thenReturn(100L);
        when(rs.getLong("place_id")).thenReturn(10L);
        Timestamp createdAt = Timestamp.valueOf("2024-06-17 12:00:00");
        when(rs.getTimestamp("created_at")).thenReturn(createdAt);
        when(rs.getInt("room_number")).thenReturn(42);
        when(rs.getString("room_type")).thenReturn("Suite");
        when(rs.getDouble("price_per_night")).thenReturn(199.99);
        when(rs.getInt("guests_capacity")).thenReturn(4);
        when(rs.getBoolean("is_available")).thenReturn(true);
        when(rs.getString("image")).thenReturn("suite.png");
        when(rs.getString("description")).thenReturn("Grande suite avec vue sur la ville");

        RoomRowMapper rowMapper = new RoomRowMapper();

        // Act
        Room room = rowMapper.mapRow(rs, 1);

        // Assert
        assertNotNull(room);
        assertEquals(100L, room.id());
        assertEquals(10L, room.place_id());
        assertEquals(createdAt, room.created_at());
        assertEquals(42, room.room_number());
        assertEquals("Suite", room.room_type());
        assertEquals(199.99, room.price_per_night());
        assertEquals(4, room.guests_capacity());
        assertTrue(room.is_available());
        assertEquals("suite.png", room.image());
        assertEquals("Grande suite avec vue sur la ville", room.description());
    }
}
