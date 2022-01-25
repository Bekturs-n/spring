package ru.otus.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.springboot.dao.BookDao;
import ru.otus.springboot.domain.Author;
import ru.otus.springboot.domain.Book;
import ru.otus.springboot.domain.Genre;
import ru.otus.springboot.service.BookService;

import java.sql.SQLException;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

        Author author = Author.builder().author("Jules").surname("Verne").build();
        Genre genre = Genre.builder().genre("Historical novel").build();
        Book book = Book.builder()
                .bookName("Dick Sand, A Captain at Fifteen")
                .author(author)
                .genre(genre)
                .build();
        BookService bookService = context.getBean(BookService.class);
        bookService.insertBook(book);

        System.out.println(bookService.getBookById(2));;
//        Console.main(args);
    }

}
