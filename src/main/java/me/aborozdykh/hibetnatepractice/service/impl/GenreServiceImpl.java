package me.aborozdykh.hibetnatepractice.service.impl;

import me.aborozdykh.hibetnatepractice.dao.GenreDao;
import me.aborozdykh.hibetnatepractice.lib.Inject;
import me.aborozdykh.hibetnatepractice.lib.Service;
import me.aborozdykh.hibetnatepractice.models.Genre;
import me.aborozdykh.hibetnatepractice.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    private GenreDao genreDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }
}
