package me.aborozdykh.hibetnatepractice.dao.impl;

import me.aborozdykh.hibetnatepractice.dao.BookDao;
import me.aborozdykh.hibetnatepractice.lib.Dao;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import java.util.List;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        return null;
    }

    @Override
    public Book getBookByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> getAllByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> getAllByGenre(Genre genre) {
        return null;
    }
}
