package me.aborozdykh.hibetnatepractice.service;

import java.util.List;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;

public interface BookService {
    Book add(Book book);

    Book getBookByTitle(String title);

    List<Book> getAllByAuthor(Author author);

    List<Book> getAllByGenre(Genre genre);
}
