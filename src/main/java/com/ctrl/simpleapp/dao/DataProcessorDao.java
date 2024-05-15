package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.Book;
import com.ctrl.simpleapp.rowmapper.BookRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@EnableScheduling
public class DataProcessorDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataProcessorDao.class);

    private final JdbcTemplate jt;

    @Autowired
    public DataProcessorDao(@Autowired @Qualifier("datasource")DataSource dataSource) {
        this.jt = new JdbcTemplate(dataSource);
    }

    @Scheduled(fixedDelay = 10000)
    public void logBooks() {
        String dataSourceRequest = "SELECT * FROM book LIMIT 2";
        List<Book> booksList =  jt.query(dataSourceRequest, new BookRowMapper());

        for(Book book : booksList) {
            LOGGER.info(String.valueOf(book));
        }
    }
}
