package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking> {
    @SuppressWarnings("null")
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Booking(
                rs.getLong("id"),
                rs.getTimestamp("created_at"),
                rs.getLong("user_id"),
                rs.getLong("place_id"),
                rs.getInt("room_number"),
                rs.getTimestamp("start_date"),
                rs.getTimestamp("end_date")
        );
    }
}
