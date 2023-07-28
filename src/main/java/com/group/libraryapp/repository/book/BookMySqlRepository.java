package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookMySqlRepository implements BookRepository {

//    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public void saveBook() {
//        String sql = "INSERT INTO book (name, price) VALUES (?, ?)";
//        jdbcTemplate.update(sql, name, price);

        System.out.println("BookMySqlRepository");
    }
}
