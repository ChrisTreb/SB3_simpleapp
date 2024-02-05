package com.ctrl.simpleapp.rowmapper;

import com.ctrl.simpleapp.records.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("gender"),
                rs.getString("phone"),
                rs.getString("adress"),
                rs.getString("city"),
                rs.getString("country"),
                rs.getString("postal_code")
        );
    }
}
