package me.aborozdykh.hibetnatepractice.dao.impl;

import me.aborozdykh.hibetnatepractice.dao.BookDao;
import me.aborozdykh.hibetnatepractice.exceptions.DataProcessingException;
import me.aborozdykh.hibetnatepractice.lib.Dao;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long bookId = (Long) session.save(book);
            transaction.commit();
            book.setId(bookId);
            return book;
        } catch (Exception e){
            if (session != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add Genre " + book.getTitle(), e);
        } finally{
            if (session != null) {
                session.close();
            }
        }
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
