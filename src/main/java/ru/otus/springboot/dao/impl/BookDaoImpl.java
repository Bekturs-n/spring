package ru.otus.springboot.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.springboot.dao.AuthorDao;
import ru.otus.springboot.dao.BookDao;
import ru.otus.springboot.dao.GenreDao;
import ru.otus.springboot.domain.Author;
import ru.otus.springboot.domain.Book;
import ru.otus.springboot.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations jdbc;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Override
    public void insert(Book book) {
        jdbc.update("INSERT INTO books(bookName, author_id, genre_id) VALUES(:bookName, :author_id, :genre_id)",
                Map.of("bookName", book.getBookName(), "author_id", book.getAuthor().getId(),
                        "genre_id", book.getGenre().getId()));
    }

    @Override
    public void update(Book book) {
        jdbc.update("UPDATE books SET bookName = :bookName, author_id = :authorId, genre_id = :genreId",
                Map.of("bookName", book.getBookName(), "author_id", book.getAuthor().getId(),
                        "genre_id", book.getGenre().getId()));
    }

    @Override
    public void deleteById(long id) {
        jdbc.queryForObject("DELETE FROM books WHERE id = :id", Map.of("id", id), new BookMapper());
    }

    @Override
    public Book getById(long id) {
        Book book = null;
        try {
            book = jdbc.queryForObject("SELECT * FROM books WHERE id = :id",
                    Map.of("id", id), new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            //noop
        }
        return book;
    }

    class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String bookName = rs.getString("bookName");
            Author author = authorDao.getById(rs.getLong("author_id"));
            Genre genre = genreDao.getById(rs.getLong("genre_id"));
            return new Book(id, bookName, author, genre);
        }
    }
}
