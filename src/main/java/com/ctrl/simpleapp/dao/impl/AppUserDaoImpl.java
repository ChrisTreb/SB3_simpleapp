package com.ctrl.simpleapp.dao.impl;

import com.ctrl.simpleapp.dao.AppUserDao;
import com.ctrl.simpleapp.dao.rowmapper.AppUserRowmapper;
import com.ctrl.simpleapp.records.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Component
public class AppUserDaoImpl implements AppUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDaoImpl.class);

    private static final String QUERY = "SELECT id, created_at, lastname, firstname, email, gender, date_of_birth, address, city, country, role, image, login, password" +
            " FROM app_user";

    private final JdbcTemplate jdbcTemplate;

    public AppUserDaoImpl(@Qualifier("datasource") DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public int countUsers() {
        String query = "SELECT COUNT(id) FROM app_user";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class);
        if (count == null) {
            count = 0;
        }
        return count;
    }

    @Override
    public List<AppUser> getUsersByStringCriteria(String criteria, String search) {

        String query = QUERY + " WHERE " + criteria + " ILIKE '%" + search + "%';";
        LOGGER.info("Query getUsersByStringCriteria, criteria : {} - search : {} - Query = {}", criteria, search, query);

        return jdbcTemplate.query(query, new AppUserRowmapper());
    }

    @Override
    public List<AppUser> getUsersByDateCriteria(Date criteria, String search) {
        // TODO
        return List.of();
    }

    @Override
    public List<AppUser> getUserById(Long id) {
        String query = QUERY + " WHERE id = " +  id;
        return jdbcTemplate.query(query, new AppUserRowmapper());
    }

    @Override
    public List<AppUser> getUserByIdRange(Long firstId, Long limit) {
        String query = QUERY + " WHERE id >= " +  firstId + " ORDER BY id limit " + limit;
        return jdbcTemplate.query(query, new AppUserRowmapper());
    }

    @Override
    public AppUser getUserWithCredentials(String login, String password) {
        AppUser user = null;
        try {
            String query = QUERY + " WHERE login = '" + login + "' AND password = '" + password + "'";
            user = jdbcTemplate.query(query, new AppUserRowmapper()).getFirst();
        } catch (Exception e) {
            LOGGER.error("User not found with login : {}", login);
        }
        return user;
    }
}
