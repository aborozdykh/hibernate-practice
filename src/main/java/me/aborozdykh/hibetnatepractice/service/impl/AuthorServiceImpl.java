package me.aborozdykh.hibetnatepractice.service.impl;

import me.aborozdykh.hibetnatepractice.dao.AuthorDao;
import me.aborozdykh.hibetnatepractice.lib.Inject;
import me.aborozdykh.hibetnatepractice.lib.Service;
import me.aborozdykh.hibetnatepractice.models.Author;
import me.aborozdykh.hibetnatepractice.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
