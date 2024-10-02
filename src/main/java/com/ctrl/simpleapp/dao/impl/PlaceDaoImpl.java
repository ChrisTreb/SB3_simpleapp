package com.ctrl.simpleapp.dao.impl;

import com.ctrl.simpleapp.dao.PlaceDao;
import com.ctrl.simpleapp.dao.rowmapper.PlaceRowMapper;
import com.ctrl.simpleapp.records.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Component
public class PlaceDaoImpl implements PlaceDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceDaoImpl.class);
  
    private static final String QUERY = "SELECT id, created_at, name, address, city, country, description, phone_number, email, rating, image " +
            " FROM place";

    private final JdbcTemplate jdbcTemplate;

    public PlaceDaoImpl(@Qualifier("datasource") DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Place> getPlacesByStringCriteria(String criteria, String search) {

        String query = QUERY + " WHERE " + criteria + " ILIKE '%" + search + "%';";
        LOGGER.info("Query getPlacesByStringCriteria, criteria : {} - search : {} - Query = {}", criteria, search, query);

        return jdbcTemplate.query(query, new PlaceRowMapper());
    }

    @Override
    public List<Place> getPlacesByDateCriteria(Date criteria, String search) {
        // TODO
        return List.of();
    }

    @Override
    public List<Place> getPlaceById(Long id) {
        String query = QUERY + " WHERE id = " +  id;
        return jdbcTemplate.query(query, new PlaceRowMapper());
    }

    @Override
    public List<Place> getPlacesByRating(int rating) {
        String query = QUERY + " WHERE rating = " +  rating;
        return jdbcTemplate.query(query, new PlaceRowMapper());
    }

    @Override
    public List<String> getCountries() {
        String query = "SELECT DISTINCT country FROM place";
        return jdbcTemplate.queryForList(query, String.class);
    }

    @Override
    public List<String> getCitiesByCountry(String search) {
        String query = "SELECT DISTINCT city FROM place WHERE country = '" + search + "';";
        return jdbcTemplate.queryForList(query, String.class);
    }
}
