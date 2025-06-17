package com.ctrl.simpleapp.dao.impl;

import com.ctrl.simpleapp.dao.rowmapper.PlaceRowMapper;
import com.ctrl.simpleapp.records.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceDaoImplTest {

    @Mock
    private DataSource dataSource;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PlaceDaoImpl placeDao;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        // On remplace le JdbcTemplate initialisé dans le constructeur
        placeDao = new PlaceDaoImpl(dataSource);
        Field field = PlaceDaoImpl.class.getDeclaredField("jdbcTemplate");
        field.setAccessible(true);
        field.set(placeDao, jdbcTemplate);
    }

    @Test
    void getPlacesByStringCriteria_shouldReturnPlaces() {
        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class)))
                .thenReturn(List.of(mock(Place.class)));

        List<Place> result = placeDao.getPlacesByStringCriteria("city", "Paris");

        assertEquals(1, result.size());
        verify(jdbcTemplate).query(contains("city ILIKE '%Paris%'"), any(PlaceRowMapper.class));
    }

    @Test
    void getPlaceById_shouldReturnPlaces() {
        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class)))
                .thenReturn(List.of(mock(Place.class)));

        List<Place> result = placeDao.getPlaceById(5L);

        assertEquals(1, result.size());
        verify(jdbcTemplate).query(contains("WHERE id = 5"), any(PlaceRowMapper.class));
    }

    @Test
    void getPlacesByRating_shouldReturnPlaces() {
        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class)))
                .thenReturn(List.of(mock(Place.class)));

        List<Place> result = placeDao.getPlacesByRating(4);

        assertEquals(1, result.size());
        verify(jdbcTemplate).query(contains("WHERE rating = 4"), any(PlaceRowMapper.class));
    }

    @Test
    void getCountries_shouldReturnCountries() {
        when(jdbcTemplate.queryForList(anyString(), eq(String.class)))
                .thenReturn(List.of("France", "Italie"));

        List<String> countries = placeDao.getCountries();

        assertEquals(List.of("France", "Italie"), countries);
        verify(jdbcTemplate).queryForList(contains("SELECT DISTINCT country"), eq(String.class));
    }

    @Test
    void getCitiesByCountry_shouldReturnCities() {
        when(jdbcTemplate.queryForList(anyString(), eq(String.class)))
                .thenReturn(List.of("Paris", "Lyon"));

        List<String> cities = placeDao.getCitiesByCountry("France");

        assertEquals(List.of("Paris", "Lyon"), cities);
        verify(jdbcTemplate).queryForList(contains("WHERE country = 'France'"), eq(String.class));
    }

    @Test
    void getPlacesByIdRange_shouldReturnPlaces() {
        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class)))
                .thenReturn(List.of(mock(Place.class)));

        List<Place> result = placeDao.getPlacesByIdRange(10L, 5L);

        assertEquals(1, result.size());
        verify(jdbcTemplate).query(contains("WHERE id >= 10"), any(PlaceRowMapper.class));
        verify(jdbcTemplate).query(contains("limit 5"), any(PlaceRowMapper.class));
    }
}
