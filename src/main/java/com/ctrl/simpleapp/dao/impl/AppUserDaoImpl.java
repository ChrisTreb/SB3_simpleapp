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

    private static final String QUERY = "SELECT id, created_at, lastname, firstname, email, gender, date_of_birth, address, city, country, role" +
            " FROM app_user";

    private final JdbcTemplate jdbcTemplate;

    public AppUserDaoImpl(@Qualifier("datasource") DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<AppUser> getUserByStringCriteria(String criteria, String search) {

        String query = QUERY + " WHERE " + criteria + " LIKE '%" + search + "%';";
        LOGGER.info("Query getUserByStringCriteria, criteria : {} - search : {} - Query = {}", criteria, search, query);

        return jdbcTemplate.query(query, new AppUserRowmapper());
    }

    @Override
    public List<AppUser> getUserByDateCriteria(Date criteria, String search) {
        return List.of();
    }


}
