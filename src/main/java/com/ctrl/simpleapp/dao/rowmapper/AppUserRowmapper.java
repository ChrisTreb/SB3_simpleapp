package com.ctrl.simpleapp.dao.rowmapper;

import com.ctrl.simpleapp.records.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserRowmapper implements RowMapper<AppUser> {

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AppUser(
                rs.getLong("id"),
                rs.getTimestamp("created_at"),
                rs.getString("lastname"),
                rs.getString("firstname"),
                rs.getString("email"),
                rs.getString("gender"),
                rs.getDate("date_of_birth"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("country"),
                rs.getString("role")
        );
    }
}
