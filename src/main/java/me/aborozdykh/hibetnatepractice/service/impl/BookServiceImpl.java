package me.aborozdykh.hibetnatepractice.service.impl;

import java.util.List;
import me.aborozdykh.hibetnatepractice.dao.BookDao;
import me.aborozdykh.hibetnatepractice.lib.Inject;
import me.aborozdykh.hibetnatepractice.lib.Service;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getAllByAuthor(Author author) {
        return bookDao.getAllByAuthor(author);
    }

    @Override
    public List<Book> getAllByGenre(Genre genre) {
        return bookDao.getAllByGenre(genre);
    }

}
