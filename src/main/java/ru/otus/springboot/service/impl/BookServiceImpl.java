package ru.otus.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springboot.dao.AuthorDao;
import ru.otus.springboot.dao.BookDao;
import ru.otus.springboot.dao.GenreDao;
import ru.otus.springboot.domain.Author;
import ru.otus.springboot.domain.Book;
import ru.otus.springboot.domain.Genre;
import ru.otus.springboot.service.BookService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Override
    public void insertBook(Book book) {
        checkAuthorAndGenre(book.getAuthor(), book.getGenre());
        bookDao.insert(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public void updateBook(Book book) {
        checkAuthorAndGenre(book.getAuthor(), book.getGenre());
        bookDao.update(book);
    }

    @Override
    public void deleteBookById(long id) {
        bookDao.deleteById(id);
    }

    private void checkAuthorAndGenre(Author author, Genre genre) {
        if (authorDao.getByName(author.getAuthor()) == null) {
            author.setId(authorDao.count() + 1);
            authorDao.insert(author);
        }
        if (genreDao.getById(genre.getId()) == null) {
            genre.setId(genreDao.count() + 1);
            genreDao.insert(genre);
        }
    }
}
