package me.aborozdykh.hibetnatepractice.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import me.aborozdykh.hibetnatepractice.dao.BookDao;
import me.aborozdykh.hibetnatepractice.exceptions.DataProcessingException;
import me.aborozdykh.hibetnatepractice.lib.Dao;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.models.Book;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        } catch (Exception e) {
            if (session != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add book " + book.getTitle(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Book> q = cb.createQuery(Book.class);
            Root<Book> root = q.from(Book.class);
            Predicate predicateForTitle
                    = cb.equal(root.get("title"), title);
            Predicate finalPredicate = cb.or(predicateForTitle);
            q.where(finalPredicate);
            return session.createQuery(q).getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find book by title " + title, e);
        }
    }

    @Override
    public List<Book> getAllByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Book> bookCriteriaQuery = cb.createQuery(Book.class);
            Root<Book> bookRoot = bookCriteriaQuery.from(Book.class);
            Predicate predicateForBook = cb.isMember(author, bookRoot.get("authors"));
            bookCriteriaQuery.where(predicateForBook);
            return session.createQuery(bookCriteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available sessions", e);
        }
    }

    @Override
    public List<Book> getAllByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Book> q = cb.createQuery(Book.class);
            Root<Book> root = q.from(Book.class);
            Predicate predicateForGenre
                    = cb.equal(root.get("genre"), genre.getId());
            q.where(predicateForGenre);
            return session.createQuery(q).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find books by genre " + genre, e);
        }
    }
}
