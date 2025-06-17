package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.AppUser;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppUserRowmapperTest {

    @Test
    void mapRow_shouldMapResultSetToAppUser() throws Exception {
        // Arrange
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("id")).thenReturn(1L);
        Timestamp createdAt = Timestamp.valueOf("2023-01-01 10:00:00");
        when(rs.getTimestamp("created_at")).thenReturn(createdAt);
        when(rs.getString("lastname")).thenReturn("Doe");
        when(rs.getString("firstname")).thenReturn("John");
        when(rs.getString("email")).thenReturn("john.doe@example.com");
        when(rs.getString("gender")).thenReturn("M");
        Date dob = Date.valueOf("1990-01-01");
        when(rs.getDate("date_of_birth")).thenReturn(dob);
        when(rs.getString("address")).thenReturn("1 rue de Paris");
        when(rs.getString("city")).thenReturn("Paris");
        when(rs.getString("country")).thenReturn("France");
        when(rs.getString("role")).thenReturn("USER");
        when(rs.getString("image")).thenReturn("avatar.png");
        when(rs.getString("login")).thenReturn("johndoe");
        when(rs.getString("password")).thenReturn("secret");

        AppUserRowmapper rowmapper = new AppUserRowmapper();

        // Act
        AppUser user = rowmapper.mapRow(rs, 1);

        // Assert
        assertNotNull(user);
        assertEquals(1L, user.id());
        assertEquals(createdAt, user.created_at());
        assertEquals("Doe", user.lastname());
        assertEquals("John", user.firstname());
        assertEquals("john.doe@example.com", user.email());
        assertEquals("M", user.gender());
        assertEquals(dob, user.date_of_birth());
        assertEquals("1 rue de Paris", user.address());
        assertEquals("Paris", user.city());
        assertEquals("France", user.country());
        assertEquals("USER", user.role());
        assertEquals("avatar.png", user.image());
        assertEquals("johndoe", user.login());
        assertEquals("secret", user.password());
    }
}