package com.ctrl.simpleapp.dao.impl;

import com.ctrl.simpleapp.dao.RoomDao;
import com.ctrl.simpleapp.dao.rowmapper.RoomRowMapper;
import com.ctrl.simpleapp.records.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class RoomDaoImpl implements RoomDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomDaoImpl.class);

    private static final String QUERY = "SELECT id, place_id, created_at, room_number, room_type, price_per_night, guests_capacity, is_available, image " +
            " FROM room";

    private final JdbcTemplate jdbcTemplate;

    public RoomDaoImpl(@Qualifier("datasource") DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public Room getRoomById(Long roomId) {
        String query = QUERY + " WHERE id = " + roomId;
        LOGGER.info("Query getRoomById, Query = {}", query);
        return jdbcTemplate.query(query, new RoomRowMapper()).getFirst();
    }

    @Override
    public List<Room> getRoomsByPlaceId(Long placeId) {
        String query = QUERY + " WHERE place_id = " + placeId;
        return jdbcTemplate.query(query, new RoomRowMapper());
    }
}
