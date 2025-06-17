package com.ctrl.simpleapp.dao.impl;

import com.ctrl.simpleapp.dao.rowmapper.RoomRowMapper;
import com.ctrl.simpleapp.records.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RoomDaoImplTest {

    private JdbcTemplate jdbcTemplate;
    private RoomDaoImpl roomDao;

    @BeforeEach
    void setUp() throws Exception {
        jdbcTemplate = mock(JdbcTemplate.class);
        DataSource dataSource = mock(DataSource.class);
        roomDao = new RoomDaoImpl(dataSource);

        // Injection du mock JdbcTemplate par réflexion
        Field field = RoomDaoImpl.class.getDeclaredField("jdbcTemplate");
        field.setAccessible(true);
        field.set(roomDao, jdbcTemplate);
    }

    @Test
    void getRoomById_shouldReturnRoom() {
        Room expectedRoom = new Room(
                1L, 2L, Timestamp.valueOf("2024-06-17 12:00:00"), 101, "Suite",
                150.0, 2, true, "suite.png", "Belle suite"
        );
        when(jdbcTemplate.query(anyString(), any(RoomRowMapper.class)))
                .thenReturn(List.of(expectedRoom));

        Room result = roomDao.getRoomById(1L);

        assertNotNull(result);
        assertEquals(expectedRoom, result);
        verify(jdbcTemplate).query(contains("WHERE id = 1"), any(RoomRowMapper.class));
    }

    @Test
    void getRoomById_shouldThrowExceptionIfNoRoom() {
        when(jdbcTemplate.query(anyString(), any(RoomRowMapper.class)))
                .thenReturn(List.of());

        assertThrows(java.util.NoSuchElementException.class, () -> roomDao.getRoomById(99L));
    }

    @Test
    void getRoomsByPlaceId_shouldReturnRooms() {
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);
        when(jdbcTemplate.query(anyString(), any(RoomRowMapper.class)))
                .thenReturn(List.of(room1, room2));

        List<Room> result = roomDao.getRoomsByPlaceId(5L);

        assertEquals(2, result.size());
        verify(jdbcTemplate).query(contains("WHERE place_id = 5"), any(RoomRowMapper.class));
    }

    @Test
    void getRoomsByPlaceId_shouldReturnEmptyListIfNone() {
        when(jdbcTemplate.query(anyString(), any(RoomRowMapper.class)))
                .thenReturn(List.of());

        List<Room> result = roomDao.getRoomsByPlaceId(123L);

        assertTrue(result.isEmpty());
        verify(jdbcTemplate).query(contains("WHERE place_id = 123"), any(RoomRowMapper.class));
    }
}