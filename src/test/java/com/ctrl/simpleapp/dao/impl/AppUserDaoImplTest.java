package com.ctrl.simpleapp.dao.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.ctrl.simpleapp.configuration.JasyptEncryptorConfig;
import com.ctrl.simpleapp.dao.rowmapper.AppUserRowmapper;
import com.ctrl.simpleapp.records.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import javax.sql.DataSource;
import java.util.List;

class AppUserDaoImplTest {

    @Mock
    private DataSource dataSource;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private JasyptEncryptorConfig jasyptEncryptorConfig;

    @InjectMocks
    private AppUserDaoImpl appUserDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        appUserDao = new AppUserDaoImpl(dataSource, jasyptEncryptorConfig);
        // Injecter le mock JdbcTemplate
        ReflectionTestUtils.setField(appUserDao, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    void testCountUsers() {
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class))).thenReturn(5);
        int count = appUserDao.countUsers();
        assertEquals(5, count);
    }

    @Test
    void testCountUsersNull() {
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class))).thenReturn(null);
        int count = appUserDao.countUsers();
        assertEquals(0, count);
    }

    @Test
    void testGetUsersByStringCriteria() {
        List<AppUser> expected = List.of(mock(AppUser.class));
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenReturn(expected);
        List<AppUser> result = appUserDao.getUsersByStringCriteria("lastname", "Doe");
        assertEquals(expected, result);
    }

    @Test
    void testGetUserById() {
        List<AppUser> expected = List.of(mock(AppUser.class));
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenReturn(expected);
        List<AppUser> result = appUserDao.getUserById(1L);
        assertEquals(expected, result);
    }

    @Test
    void testGetUserByIdRange() {
        List<AppUser> expected = List.of(mock(AppUser.class));
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenReturn(expected);
        List<AppUser> result = appUserDao.getUserByIdRange(1L, 10L);
        assertEquals(expected, result);
    }

    @Test
    void testGetUserWithCredentialsException() {
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenThrow(new RuntimeException("DB error"));
        AppUser result = appUserDao.getUserWithCredentials("login", "password");
        assertNull(result);
    }

    @Test
    void testGetUserByLoginFound() {
        AppUser user = mock(AppUser.class);
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenReturn(List.of(user));
        AppUser result = appUserDao.getUserByLogin("login");
        assertEquals(user, result);
    }

    @Test
    void testGetUserByLoginNotFound() {
        when(jdbcTemplate.query(anyString(), any(AppUserRowmapper.class))).thenReturn(List.of());
        AppUser result = appUserDao.getUserByLogin("login");
        assertNull(result);
    }
}
