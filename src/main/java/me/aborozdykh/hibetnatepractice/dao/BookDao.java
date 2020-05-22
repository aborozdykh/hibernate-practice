package me.aborozdykh.hibetnatepractice.dao;

import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    Book getBookByTitle(String title);

    List<Book> getAllByAuthor(Author author);

    List<Book> getAllByGenre(Genre genre);
}
