package me.aborozdykh.hibetnatepractice.dao.impl;

import me.aborozdykh.hibetnatepractice.dao.GenreDao;
import me.aborozdykh.hibetnatepractice.exceptions.DataProcessingException;
import me.aborozdykh.hibetnatepractice.lib.Dao;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long genreId = (Long) session.save(genre);
            transaction.commit();
            genre.setId(genreId);
            return genre;
        } catch (Exception e) {
            if (session != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add genre " + genre.getName(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
