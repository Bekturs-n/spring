package ru.otus.springboot.service;

import ru.otus.springboot.domain.Author;
import ru.otus.springboot.domain.Book;

public interface BookService {

    void insertBook(Book book);

    Book getBookById(long id);

    void updateBook(Book book);

    void deleteBookById(long id);

}
