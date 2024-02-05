package com.ctrl.simpleapp.rowmapper;

import com.ctrl.simpleapp.records.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getLong("id"),
                rs.getTimestamp("created_at"),
                rs.getString("book_title"),
                rs.getString("author"),
                rs.getString("isbn"),
                rs.getBoolean("available")
        );
    }
}
