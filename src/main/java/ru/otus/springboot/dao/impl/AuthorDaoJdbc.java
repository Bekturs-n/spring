package ru.otus.springboot.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.springboot.dao.AuthorDao;
import ru.otus.springboot.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public long count(){
        return jdbc.getJdbcOperations()
                .queryForObject("select count(*) from authors", Long.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.update("INSERT INTO authors(author, surname) values(:author, :surname)",
                Map.of("author", author.getAuthor(), "surname", author.getSurname()));
    }

    @Override
    public void update(Author author) {
        jdbc.update("UPDATE authors SET author = :author, surname =:surname WHERE id = :id",
                Map.of("author", author.getAuthor(), "surname", author.getSurname(),
                        "id", author.getId()));
    }

    @Override
    public void deleteById(long id) {
        jdbc.queryForObject("delete from persons where id = :id", Map.of("id", id), AuthorMapper.class);
    }

    @Override
    public Author getById(long id) {
        Author author = null;
        try {
            author = jdbc.queryForObject("SELECT * FROM authors WHERE id = :id",
                    Map.of("id", id), new AuthorMapper());
        } catch (EmptyResultDataAccessException e){
            //noop
        }
        return author;
    }

    @Override
    public Author getByName(String author) {
        Author result = null;
        try {
            result = jdbc.queryForObject("SELECT * FROM authors WHERE author = :author",
                    Map.of("author", author), new AuthorMapper());
        } catch (EmptyResultDataAccessException e){
            //noop
        }
        return result;
    }

    static class AuthorMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String author = rs.getString("author");
            String surname = rs.getString("surname");
            return new Author(id, author, surname);
        }
    }
}
