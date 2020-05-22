package me.aborozdykh.hibetnatepractice.dao.impl;

import me.aborozdykh.hibetnatepractice.dao.AuthorDao;
import me.aborozdykh.hibetnatepractice.exceptions.DataProcessingException;
import me.aborozdykh.hibetnatepractice.lib.Dao;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            transaction.commit();
            author.setId(authorId);
            return author;
        } catch (Exception e) {
            if (session != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add Genre " + author.getLastName()
                    + " " + author.getFirstName(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
