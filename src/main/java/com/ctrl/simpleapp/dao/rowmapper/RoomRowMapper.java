package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Room(
                rs.getLong("id"),
                rs.getLong("place_id"),
                rs.getTimestamp("created_at"),
                rs.getInt("room_number"),
                rs.getString("room_type"),
                rs.getDouble("price_per_night"),
                rs.getInt("guests_capacity"),
                rs.getBoolean("is_available"),
                rs.getString("image")
        );
    }
}
