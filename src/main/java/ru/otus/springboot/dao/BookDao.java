package ru.otus.springboot.dao;

import ru.otus.springboot.domain.Book;

public interface BookDao {

    void insert(Book book);
    void update(Book book);
    void deleteById(long id);
    Book getById(long id);

}
