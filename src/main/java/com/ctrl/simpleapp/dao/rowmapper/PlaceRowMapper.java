package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceRowMapper implements RowMapper<Place> {

    @Override
    public Place mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Place(
                rs.getLong("id"),
                rs.getTimestamp("created_at"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("country"),
                rs.getString("description"),
                rs.getString("phone_number"),
                rs.getString("email"),
                rs.getInt("rating")
        );
    }
}
