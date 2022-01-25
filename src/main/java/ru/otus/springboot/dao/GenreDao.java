package ru.otus.springboot.dao;

import ru.otus.springboot.domain.Genre;

public interface GenreDao {

    long count();

    void insert(Genre genre);
    void update(Genre genre);
    void deleteById(long id);
    Genre getById(long id);

    Genre getByName(String genreName);
}
