package com.ctrl.simpleapp.rowmapper;

import com.ctrl.simpleapp.records.BookLoan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookLoanRowMapper implements RowMapper<BookLoan> {
    @Override
    public BookLoan mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookLoan(
                rs.getLong("id"),
                rs.getTimestamp("created_at"),
                rs.getLong("book_id"),
                rs.getLong("user_id")
        );
    }
}
